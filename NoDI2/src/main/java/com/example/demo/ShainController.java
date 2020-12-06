package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShainController {

	@ModelAttribute
	public ShainForm setUpForm() {
		return new ShainForm();
	}

	@RequestMapping("/input")
	public String index() {
		return "index.html";
	}

	@RequestMapping("/output")
	public String result(@Validated ShainForm shainForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "index.html";
		}

		String number = shainForm.getNumber();


		//service層から社員を検索する
		ShainService shainService = new ShainServiceImpl();
		String name = shainService.findByNo(number);

		model.addAttribute("number", number);
		model.addAttribute("name", name);
		return "output.html";
	}

}