package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test1")
public class RamenController {

	@Autowired
	private RamenRepository ramenRepository;

	@GetMapping
	public String view(Model model) {
		List<RamenForm> list = ramenRepository.getAll();
		model.addAttribute("rList", list);
		return "test1/index";
	}

}
