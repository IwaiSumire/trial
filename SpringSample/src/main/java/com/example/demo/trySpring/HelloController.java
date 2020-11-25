package com.example.demo.trySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Autowired
private HelloService helloService;

//@Controllerこのクラスがコントローラーであることを宣言
//これを宣言しておくと、DIが利用できるようになる
@Controller
public class HelloController {

	//@GetMappingはアノテーションをメソッド(getHell)につけるとHTTPRequestのGETメソッドを処理できるようになる
	//localhost: 8080/ helloへGETRequest

	@GetMapping("/hello") //
	public String getHello() {
		return "hello"; //このhelloはhello.htmlのこと
	}


	//@PostMappingはPOSTメソッドで送られてきた場合の処理ができるようになる
	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1") String str, Model model) {
//		@RequestParamはメソッドの引数に付けると画面からの入力内容を受け取ることができる
//		このtext1とは、今回だとフォームのテキストエリアに付けた名前になる
		model.addAttribute("sample", str);
//		model.addAttributeは、キーと値をセットにしておく。
//		今回でいうと、sampleがキーで、値がテキストの入力値になる
		return "helloResponse";
//		helloResponse.htmlを表示する
	}


	public String postDbRequest(@RequestParm("text2")String str,Model model) {
		int id = Integer.parseInt(str);

		Employee employee = helloService.fingOne(id);

		model.addAttribute("id", employee.getEmployeeID());
		model.addAttribute("name", employee.getEmployeeName());
		model.addAttribute("age", employee.getEmployeeAge());

		return "helloResponseDB";
	}

}
