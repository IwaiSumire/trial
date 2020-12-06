package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;

@Controller
public class CommentController {

	//まずfinalにする
	private final CommentRepository repository;

	@Autowired //これを付けるとSpringがオブジェクトを管理、注入してくれる
	//そのあとコンストラクタインジェクションをする
	public CommentController(CommentRepository repository) {
		this.repository = repository;
	}

	//jparepositoryの機能で、findOne、FindAllが使える

	@GetMapping("/")
	public String getAllComments(@ModelAttribute Comment comment, Model model) {
		model.addAttribute("comments", repository.findAll());//全件取得
		return "list";
	}


	//BindingResultはエラーについて書いている
	@PostMapping("/add")
	public String addComment(@Validated @ModelAttribute Comment comment, BindingResult result, Model model) {
		model.addAttribute("comments", repository.findAll());

		if (result.hasErrors()) {
			return "list";//list.html
		}
		repository.save(comment);//データ保存
		return "redirect:/";//list.html
	}
}
