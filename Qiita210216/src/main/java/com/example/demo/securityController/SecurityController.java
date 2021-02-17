package com.example.demo.securityController;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

	@GetMapping("/login") //configのloginPageでloginに来るように指定したので
	public String login() {
		return "login";//自作のloginページを表示
	}

	@GetMapping("/hello") //configのdefaultSuccessUrlでhelloに来るように指定したので
	public String hello(Authentication loginUser,Model model) {

		/*AuthenticationでログインUserの情報を使うことができるので
		modelを使って、"username"にusernameを詰める*/

		model.addAttribute("username",loginUser.getName());

		return "hello";//helloを表示。usernameをhelloで表示できる
	}

}
