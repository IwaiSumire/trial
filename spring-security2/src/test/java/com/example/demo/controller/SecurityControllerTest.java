package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.model.SiteUser;
import com.example.demo.util.Role;

@SpringBootTest
@AutoConfigureMockMvc //springMVCをテストで実現できる
@Transactional
class SecurityControllerTest {

	@Autowired //インスタンス化
	MockMvc mockMvc;

	@Test
	@DisplayName("登録エラーがあるとき、エラーを表示することを期待します")
	void whenThereIsRegistrationError_expectToSeeErrors() throws Exception {

		mockMvc
				//リクエストを実行します
				.perform(
						post("/register")//@postmapping(/register)の時
								.flashAttr("user", new SiteUser())//userをpostに渡す
								.with(csrf()))//POSTの時は付ける必須
				.andExpect(model().hasErrors())//andExpect=テスト項目。エラーであることを検証します
				.andExpect(view().name("register"));//=view().name 指定したHTMLを表示しているか検証します
	}

	@Test
	@DisplayName("管理者ユーザとして登録するとき、成功することを期待します")
	void whenRefisteringAsAdminUser_expectToSucceed() throws Exception {

		//準備
		SiteUser user = new SiteUser();//user準備

		//名前やパスを仮で入れていく
		user.setUsername("管理者ユーザ");
		user.setPassword("password");
		user.setEmail("admin@example.com");
		user.setGender(0);
		user.setAdmin(true);
		user.setRole(Role.ADMIN.name());

		//@PostMappring("/register")登録されたとき
		mockMvc.perform(post("/register")
				.flashAttr("user", user).with(csrf()))

				//エラーがないことを検証します
				.andExpect(model().hasNoErrors())

				//redirectすることを検証します
				.andExpect(redirectedUrl("/login"))

				//ステータスコードがFound302であることを証明します
				.andExpect(status().isFound());

	}

	@Test
	@DisplayName("管理者ユーザでログイン時、ユーザ一覧を表示することを期待します")
	@WithMockUser(username = "admin", roles = "ADMIN")//モックユーザでログインします
	void whenLoggedInasAdminUser_expectToSeeListOfUsers() throws Exception {
		mockMvc.perform(get("/admin/list"))

				//ステータスコードがOK（２００）であることを検証します
				.andExpect(status().isOk())

				//HTMLの表示内容に、指定した文字列を含んでいるか検証します
				.andExpect(content().string(containsString("ユーザ一覧")))
				
				.andExpect(view().name("list"));
	}
}
