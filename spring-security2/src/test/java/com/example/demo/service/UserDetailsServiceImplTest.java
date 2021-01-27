/*package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.model.SiteUser;
import com.example.demo.repository.SiteUserRepository;

//publicがないクラスができる
@SpringBootTest //テストします
@Transactional //テストの開始～終了までトランザクション処理します
//↑があると各テスト後にデータが初期化される
class UserDetailsServiceImplTest {//セキュリティのserviceのテスト

	@Autowired
	SiteUserRepository repository;//リポシトリにあるか見るから

	@Autowired
	UserDetailsServiceImple service;//serviceに探すよう指示

	//メソッドにもpublicがない
	@Test
	@DisplayName("ユーザ名が存在するとき、ユーザの詳細を取得することを期待します")//分かりやすいように
	void whenUsernameExists_expectToGetUserDetails() {

		//{A]Arrange 準備する
		SiteUser user = new SiteUser();//Userに名前とかつっこむ

		user.setUsername("原田");
		user.setPassword("password");
		user.setEmail("harada@example.com");//example.comは第三者に影響がない。これ使う。
		user.setRole("Role.User.name()");
		repository.save(user);//リポシトリに保存するように指示（DB）

		//{A]実行する（actua）
		UserDetails actual = service.loadUserByUsername("原田");

		//{A]検証する（assert）assertEquals=同じか検証する
		//保存してある名前と、一致しているか？
		assertEquals(user.getUsername(), actual.getUsername());

	}

	@Test
	@DisplayName("ユーザが存在しないとき、例外をスローします")
	void whenUsernameDoesNotExist_throwException() {
		assertThrows(UsernameNotFoundException.class, () -> service.loadUserByUsername("武田"));
	}

}*/
