package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@GetMapping("/")
	public String greeting() {
		return "hello"; //このhelloはhello.htmlを表示するということ
	}

	//	http://localhost:8080/greeting?message=welcome を作る
	@GetMapping("/greeting")
	//	リクエストパラメータを取得する。取得した値をﾀｲﾑﾘｰﾌに渡すには、Modelに追加する
	//	@RequestParamでリクエストパラメーターを取得する。RequestParamがURLの一部
	//	messageがなしでも表示するときは(required = false)のデフォルトにしておく
	//	Requestパラメータを取得したら、それを引数にする。→のStringのこと。
	public String greeting(@RequestParam("test") String test2, Model model) {

		//		モデルクラスのaddAttribute("名前", 値)を使用する
		//		この名前を宣言せずにここで決めたやつでいい

		model.addAttribute("sample", test2);
		return "hello";//このhelloはhello.htmlを表示するということ
	}
}
