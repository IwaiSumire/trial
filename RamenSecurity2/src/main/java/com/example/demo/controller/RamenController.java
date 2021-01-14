package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.Ramen;
import com.example.demo.service.RamenService;

@Controller
@RequestMapping("/ramens")
public class RamenController {

	@Autowired
	private RamenService ramenService;

	@GetMapping("") //最初の画面
	public String top(Authentication loginUser, Model model) { //全件取得
		model.addAttribute("ramen", ramenService.selectAll());
		model.addAttribute("username", loginUser.getName());
		return "ramens/top";//topでramen(全件入っている)を使える
	}

	@GetMapping("new") //top→newボタンから「ramens/new」へ行く処理を受け取ったので"new"のとき
	public String newRamen(Authentication loginUser, Model model, @ModelAttribute Ramen ramen) {//objectの値を受け取る必要がある
		model.addAttribute("username", loginUser.getName());
		return "ramens/new";//ramens/newへいく（何もしていない）
	}

	@PostMapping("new") //formから作成された画面
	public String create(@Validated @ModelAttribute Ramen ramen, BindingResult result, MultipartFile file) {

		if (result.hasErrors()) {
			return "ramens/new";//"redirect:/ramens/new"
		}



		ramenService.insert(ramen);
		return "redirect:/ramens";//一覧表に戻る
	}

	@GetMapping("{id}") //1件分のデータの中身を確認する
	public String show(Authentication loginUser, @PathVariable Long id, Model model) {
		model.addAttribute("ramen", ramenService.selectOne(id));
		model.addAttribute("username", loginUser.getName());

		return "ramens/show";
	}

	@GetMapping("{id}/change") //編集画面に行くまでの画面
	public String change(Authentication loginUser, @PathVariable Long id, Model model) {
		model.addAttribute("ramen", ramenService.selectOne(id));
		model.addAttribute("username", loginUser.getName());


		return "ramens/change";//取得したidを使って、change画面へ
	}

	@PutMapping("put/{id}") //更新画面
	public String update(@PathVariable Long id, Ramen ramen) {
		ramen.setId(id);
		ramenService.update(ramen);
		return "redirect:/ramens";
	}

	@DeleteMapping("{id}/delete") //消去画面
	public String dast(@PathVariable Long id) {
		ramenService.delete(id);
		return "redirect:/ramens";
	}
}
