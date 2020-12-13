package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domein.Ramen;

@Controller
@RequestMapping("/ramen")
public class RamenController {

	@Autowired
	private RamenService ramenService;

	@GetMapping("")
	public String top(Model model) { //全件取得
		model.addAttribute("ramens", ramenService.findAll());
	}

	@PostMapping("") //players/id番号(勝手に作られたid)//postなのでURL出ない
	public String create(@ModelAttribute Ramen ramen) {
		ramenrService.save(ramen);
		return "redirect:/ramen";//一覧表に戻る
	}

}
