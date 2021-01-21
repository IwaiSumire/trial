package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Ramen;
import com.example.demo.service.RamenService;

@Controller
@RequestMapping("/ramens")
public class ShopSearchController {

	@Autowired
	private RamenService ramenService;

	/*@GetMapping("afterTop") //top→newボタンから「ramens/new」へ行く処理を受け取ったので"new"のとき
	public String newRamen(Model model, @ModelAttribute String sShop) {//objectの値を受け取る必要がある
		return "ramens/top";//ramens/newへいく（何もしていない）
	}*/

	@PostMapping("afterTop") //1件分のデータの中身を確認する
	public String show(Authentication loginUser, @ModelAttribute("sShop") String sShop, Model model) {

		List<Ramen> ramen = ramenService.serchShopId(sShop);
		model.addAttribute("ramen", ramen);
		model.addAttribute("username", loginUser.getName());
		return "ramens/top";

	}
}
