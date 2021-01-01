package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.SiteUser;
import com.example.demo.repository.SiteUserRepository;


//publicがないクラスができる
@SpringBootTest//テストします
@Transactional//テストの開始～終了までトランザクション処理します
//↑があると各テスト後にデータが初期化される
class UserDetailsServiceImplTest {

	@Autowired
	SiteUserRepository repository;

	@Autowired
	UserDetailsServiceImple service;

	//メソッドにもpublicがない
	@Test
	@DisplayName("ユーザ名が存在するとき、ユーザの詳細を取得することを期待します")
	void whenUsernameExists_expectToGetUserDetails() {

		SiteUser user = new SiteUser();

		user.setUsername("原田");
		user.setPassword("password");
		user.setEmail("harada@example.com");
		user.setRole("Role.User.name()");
		repository.save(user);

		//実行する（actua）
		UserDetails actual = service.loadUserByUsername("原田");

		//検証する（assert）
		assertEquals(user.getUsername(), actual.getUsername());

	}

}
