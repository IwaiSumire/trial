package com.example.demo.Springtry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;

	@PostMapping("/order")
	public String postDbRequest(@RequestParam("text") String idid, Model model) {

		int id = Integer.parseInt(idid);

		Menu menu = menuService.findOne(id);

		model.addAttribute("id", menu.getMenuId());
		model.addAttribute("name", menu.getMenuId());
		model.addAttribute("price", menu.getMenuprice());

		return "menuDB";
	}

}
