package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/")
	String sample(Model model) {
		model.addAttribute("name", "たろう");
		return "hello";
	}

	@RequestMapping("/sumi")
	String sample1(Model model) {
		model.addAttribute("name", "じろう");
		return "hello";
	}


	@RequestMapping("/sumi2")
	String sample2(Model model) {
		model.addAttribute("name", "さぶろう");
		return "hello1";
	}
}
