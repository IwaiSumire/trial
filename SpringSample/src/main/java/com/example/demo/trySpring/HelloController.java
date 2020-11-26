package com.example.demo.trySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



//@Controllerこのクラスがコントローラーであることを宣言
//これを宣言しておくと、DIが利用できるようになる
@Controller
public class HelloController {

	@Autowired
	private HelloService helloService;

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


	@PostMapping("hello/bd")
	public String postDbRequest(@RequestParam("text2")String str,Model model) {
		int id = Integer.parseInt(str);

		//findOne(id)→入力されたidをHelloServiceにもっていく
		//引数のあるコンストラクタ
		//コントローラー→サービスへいく処理
		Employee employee = helloService.findOne(id);


		//model.addAttributeは、キーと値をセットにしておく。
		//get●●() employeeで@Dataしたので勝手に作られたgetter
		model.addAttribute("id", employee.getEmployeeId());
		model.addAttribute("name", employee.getEmployeeName());
		model.addAttribute("age", employee.getEmployeeAge());

		return "helloResponseDB"; //helloResponseDB.htmlへ画面がいく
	}

}
