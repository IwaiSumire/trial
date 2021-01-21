package com.example.demo.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.security.user.MyUser;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class SecurityControllerTest {

	@Autowired
	MockMvc mocMvc;

	@Test
	@DisplayName("登録エラーがあるとき、エラー表示をすることを期待します")
	void db_error_seeError() throws Exception {

		//mocMvcでgetやpostが使える
		mocMvc
				.perform(

						//postリクエストを使用します
						post("/newUser")//newUserで登録しようとしたときのURL
								//flashAttrパラメータのこと
								//controllerのuserが、新しく作られた？
								.flashAttr("user", new MyUser())
								//csrfトークンを自動挿入します
								.with(csrf()))//postの時は必要

				//エラーがあることを検証します
				.andExpect(model().hasErrors())//hasErrors=エラーであることを検証します
				//指定したHTMLを表示しているか検証します
				.andExpect(view().name("newUser"));//newUser.htmlを表示しているか検証します
	}

}
