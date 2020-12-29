
package com.example.demo.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {


	@GetMapping("/login") //loginに来るので
	public String success() {
		return "login";//url:ramensへいく
	}
}
