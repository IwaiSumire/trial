/*package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.RamenService;

@Controller
@RequestMapping("/ramens")
public class ShopSearchController {

	@Autowired
	private RamenService ramenService;


	@GetMapping("{shop}") //1件分のデータの中身を確認する
	public String show(@PathVariable String sShop, Model model) {
		model.addAttribute("ramen", ramenService.serchShop(sShop));


		return "ramens/show";
	}
}
*/