package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class EmployeeController {

	private final EmployeeRepository repository;

	@GetMapping("/add")
	public String showList(Model model) {
		model.addAttribute("employees", findAll());//全件取得
		return "index";
	}

	@GetMapping("/add")
	public String addEmployee(@ModelAttribute Employee employee) {
		return "form";
	}

	@PostMapping("/process")
	//Validatedはパスの値を変数に格納する パス＝URLの入力値が出るところ
	public String process(@Validated @ModelAttribute Employee employee, BindingResult binResult) {
		if (binResult.hasErrors()) {//エラーなら
			return "form";
		}

		repository.save(employee);
		return "redirect:/";
	}

}
