package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domein.Ramen;
import com.example.demo.service.RamenService;

@Controller
@RequestMapping("/ramens")
public class RamenController {

	@Autowired
	private RamenService ramenService;

	@GetMapping("") //最初の画面
	public String top(Model model) { //全件取得
		model.addAttribute("ramen", ramenService.findAll());
		return "ramens/top";
	}

	@GetMapping("new") //top→form画面への移動用
	public String newRamen() {
		return "ramens/new";
	}

	@PostMapping("") //formから作成された画面
	public String create(@ModelAttribute Ramen ramen) {
		ramenService.save(ramen);
		return "redirect:/ramens";//一覧表に戻る
	}

	@GetMapping("{id}") //1件分のデータの中身を確認する
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("ramen", ramenService.findOne(id));
		return "ramens/show";
	}

	@GetMapping("{id}/change") //編集画面に行くまでの画面
	public String change(@PathVariable Long id, Model model) {
		model.addAttribute("ramen", ramenService.findOne(id));
		return "ramens/change";//取得したidを使って、change画面へ
	}

	@PutMapping("{id}") //更新画面
	public String update(@PathVariable Long id, @ModelAttribute Ramen ramen) {
		ramen.setId(id);
		ramenService.update(ramen);
		return "redirect:/ramens";
	}

	@DeleteMapping("{id}") //消去画面
	public String dast(@PathVariable Long id) {
		ramenService.delete(id);
		return "redirect:/ramens";
	}
}
