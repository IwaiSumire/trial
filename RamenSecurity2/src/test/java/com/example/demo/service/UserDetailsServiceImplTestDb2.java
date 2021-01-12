package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.security.UserDetailsService.UserDetailsServiceImpl;
import com.example.demo.security.user.MyUser;
import com.example.demo.testmapper.UserMapperTest;


/*このテストでやりたいことの前提は、
UserDetailsServiceImpl implements UserDetailsServiceがちゃんと一致するusernameを探せているか？をテストする*/

@SpringBootTest
@Transactional
class UserDetailsServiceImplTestDb2 {

	@Autowired //仮で保存する用にmapper使う
	UserMapperTest userMappertest;

	@Autowired //UserDetaislServiceImplのテスト
	UserDetailsServiceImpl service;

	@Autowired
	UserService userService;

	@Test
	@DisplayName("ユーザ名がDBに登録してあった場合、ユーザ詳細を取得することを期待します")
	@Sql("/testdata.sql") //このSQLが実行した後の状態でテストが開始されるので、データが１件入っている状態になっている
	void username_db_OK() {

		//■準備段階 これって@Beforにした方がいいの？
		MyUser myUser = new MyUser();

		//myUser.setUsername("hoge@example.com");//仮で登録
		//myUser.setPassword("$2a$08$DTjs9boNV2HQXh6LwWmHquZJPuzpRWnbrYC3ZHhwSpIAVPdkKUX9O");//仮で登録

		//userMapper.insert(myUser);//仮で登録

		//■実行 hoge@gmail.comで実行している

		//MyUser user = userService.selectOne("hoge@example.com");

		//usernameの中に、
		//UserDetails actual = userMappertest.findByUsername("hoge@example.com");

		//DBの中で一致しているものがあるか見る
		UserDetails actual = service.loadUserByUsername("hoge@example.com");

		assertEquals(userMappertest(), actual.getUsername());

		//assertEquals(myUser.getUsername(), actual.getUsername());

	}

	@Test
	@DisplayName("ユーザがDBに登録がなかった時、例外をスローします")
	@Sql("/testdata.sql")
	void username_db_NG() {
		//		例外をスローするかの検証はassertThrowsを使用する
		assertThrows(UsernameNotFoundException.class, () -> service.loadUserByUsername("hogehage@example.com"));
	}

}
