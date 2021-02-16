package com.example.demo.securityController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class SecurityController {

	@GetMapping("/login") //loginに来るので
	public String success() {
		return "login";
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

}
