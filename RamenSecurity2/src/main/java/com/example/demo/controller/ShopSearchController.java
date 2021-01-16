package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.RamenService;

@Controller
@RequestMapping("/ramens")
public class ShopSearchController {

	@Autowired
	private RamenService ramenService;

	@GetMapping("afterTop") //top→newボタンから「ramens/new」へ行く処理を受け取ったので"new"のとき
	public String newRamen(Model model, @ModelAttribute String sShop) {//objectの値を受け取る必要がある
		return "ramens/top";//ramens/newへいく（何もしていない）
	}

	@PostMapping("afterTop") //1件分のデータの中身を確認する
	public String show(@ModelAttribute String sShop, Model model) {


		Long id = ramenService.serchShopId(sShop);

		model.addAttribute("ramen", id);

		return "ramens/afterTop";
	}
}