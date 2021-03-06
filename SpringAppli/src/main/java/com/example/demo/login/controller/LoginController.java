package com.example.demo.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@GetMapping("/login") //URL /loginへ
	public String getLogin(Model model) {
		return "login/login"; //login/login.htmlへ
	}

	@PostMapping("/login") //URL /loginへ
	public String postLogin(Model model) {
		return "redirect:/home"; //loginボタンを押すとホーム画面にいく
	}

}
