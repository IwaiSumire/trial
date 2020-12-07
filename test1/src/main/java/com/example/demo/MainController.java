package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test1") //URLでtest1を入力する
public class MainController {

	@Autowired
	private SyainRepository syainRepository;//repositoryクラスをインスタンス化

	@GetMapping
	public String index(Model model,Model model2) {
		List<Syain> list = syainRepository.getAll();
		model.addAttribute("SyainList", list);//listの中身をSyainListとしてHTMLで使える
		return "test1/index";//test1/index.htmlへ
	}
}
