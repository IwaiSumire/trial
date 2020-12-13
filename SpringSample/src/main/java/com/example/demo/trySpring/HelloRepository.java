package com.example.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//@Repositoryと宣言。DIに登録されるから書いておく
@Repository
public class HelloRepository {

	//	@AutowiredはJDBCを使う場合につける
	//	これをつけることによって、インスタンスが生成されている
	//	private JdbcTemplate jdbcTemplate = new JdbcTemplate();が起きているイメージ
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Map<String, Object> findOne(int id) {

		String query = "SELECT "
				+ "employee_id, "
				+ "employee_name, "
				+ "age "
				+ "FROM employee "
				+ "WHERE employee_id=?";

		//		queryには、id,name,ageを出力するselect文が入っている

		//		selectを実行する
		//		？だったIDには入力された数字が入っている

		Map<String, Object> employeeDb = jdbcTemplate.queryForMap(query, id);
		return employeeDb;
		
		//queryForMapはMapにしまう→これは仕様 文＋キー
		
		
		//jdbcTemplate javaとDBを作り変えてくれる
		//queryForMapメソッド 他人がつくったやつ
		//empoyeeにという名前のMapに、キーがselect文、値がidが入っている
		//f3で中身みれるor宣言を開く
		//queryForMap
		
		//メソッドとは機能
	}
}