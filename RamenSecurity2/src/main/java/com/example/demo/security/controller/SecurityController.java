
package com.example.demo.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.security.user.MyUser;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("")
public class SecurityController {

	@Autowired
	private UserService userService;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/login") //loginに来るので
	public String success() {
		return "login";//url:ramensへいく
	}

	@GetMapping("/newUser")
	public String newUser(@ModelAttribute("user") MyUser user) {
		return "/newUser";
	}

	@PostMapping("/newUser")
	public String newUserOk(@ModelAttribute("user") MyUser user) {

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		userService.insert(user);

		return "redirect:/login";
	}

}
