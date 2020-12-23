package com.example.demo.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

	@GetMapping("/rames") //ログインが成功すると/ramenに来るので
	public String success() {
		return "ramens/top";
	}
}
