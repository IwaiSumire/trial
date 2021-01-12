package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.security.UserDetailsService.UserDetailsServiceImpl;
import com.example.demo.testmapper.UserMapperTest;

/*このテストでやりたいことの前提は、
UserDetailsServiceImpl implements UserDetailsServiceがちゃんと一致するusernameを探せているか？をテストする*/

@SpringBootTest
@Transactional
class UserDetailsServiceImplTestDb2 {

	private IDatabaseTester databaseTester;
	private IDatabaseConnection connection;

	public UserDetailsServiceImplTestDb2() throws Exception {
		//テストクラスをインスタンス化するときに、DBに接続するためのtesterを作成する
		databaseTester = new JdbcDatabaseTester("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/3306", "root",
				"kururu966");
		//jdbc:mysql://localhost:3306/mydb?serverTimezone=JST
	}

	@Before
	public void before() throws Exception {
		//テーブルに初期化用のデータを投入する
		IDataSet dataSet = new FlatXmlDataSetBuilder().build(new File("data/init.xml"));
		databaseTester.setDataSet(dataSet);
		databaseTester.setSetUpOperation(DatabaseOperation.REFRESH);

		databaseTester.onSetup();
	}

	@After
	public void after() throws Exception {
		databaseTester.setTearDownOperation(DatabaseOperation.NONE);
		databaseTester.onTearDown();
	}

	@Autowired //仮で保存する用にmapper使う
	UserMapperTest userMappertest;

	@Autowired //UserDetaislServiceImplのテスト
	UserDetailsServiceImpl service;

	@Autowired
	UserService userService;

	@Test
	@DisplayName("ユーザ名がDBに登録してあった場合、ユーザ詳細を取得することを期待します")
	//@Sql("/testdata.sql") //このSQLが実行した後の状態でテストが開始されるので、データが１件入っている状態になっている
	void username_db_OK() {

		IDataSet databaseDataSet = databaseTester.getConnection().createDataSet();
		ITable actualTable = databaseDataSet.getTable("member");

		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("data/expected.xml"));
		ITable expectedTable = expectedDataSet.getTable("member");

		Assertion.assertEquals(expectedTable, actualTable);

	}

	@Test
	public void insertTable() throws Exception {
		IDatabaseConnection testerConnection = databaseTester.getConnection();
		Connection con = testerConnection.getConnection();
		IDataSet databaseDataSet = databaseTester.getConnection().createDataSet();

		Statement stmt = con.createStatement();
		stmt.executeUpdate("insert into member(id,name,birth) values('0004','yuka','1990-05-10')");

		ITable actualTable = databaseDataSet.getTable("member");
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("data/expected2.xml"));
		ITable expectedTable = expectedDataSet.getTable("member");

	}

	@Test
	@DisplayName("ユーザがDBに登録がなかった時、例外をスローします")
	@Sql("/testdata.sql")
	void username_db_NG() {
		//		例外をスローするかの検証はassertThrowsを使用する
		assertThrows(UsernameNotFoundException.class, () -> service.loadUserByUsername("hogehage@example.com"));
	}

}
