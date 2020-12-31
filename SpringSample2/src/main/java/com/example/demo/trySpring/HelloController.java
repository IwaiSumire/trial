package com.example.demo.trySpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String getHell() {
		return "hello";
	}

	@PostMapping("/hello")
	public String postRwquest(@RequestParam("text1") String str, Model model) {
		return "helloResponse";
	}

}
