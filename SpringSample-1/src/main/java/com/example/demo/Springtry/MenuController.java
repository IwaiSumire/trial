package com.example.demo.Springtry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;

	@GetMapping("/menu")
	public String getMenu() {
		return "menu";
	}
	//①/menu.htmlを表示する

	@PostMapping("/menu/db")
	public String postDbRequest(@RequestParam("text") int id, Model model) {

		//②入力された値がidに入っていて、menuService.findOne(id)のfind.Oneへ→
		Menu menu = menuService.findOne(id);
		//⑦インスタンス化したMenuにDBの情報を返す

		model.addAttribute("id", menu.getMenuId());
		model.addAttribute("name", menu.getMenuName());
		model.addAttribute("price", menu.getMenuprice());
		//⑧model.addAttributeで表示する
		return "menuDB";
	}

}
