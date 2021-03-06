package com.example.demo.login.controller;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.GroupOrder;
import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.service.UserService.UserService;

@Controller
public class SignupController {

	@Autowired
	private UserService userService;

	//このクラスでしか仕様できないmap radioMarriageを定義
	private Map<String, String> radioMarriage;

	//	ラジオボタンの初期化メソッド
	private Map<String, String> initRadioMarriage() {

		//		LinkedHashMapはマップを追加した順序を保持する
		Map<String, String> radio = new LinkedHashMap<String, String>();

		//		linkedhashmapのradioに、キーと値をつめる
		radio.put("既婚", "true");
		radio.put("未婚", "false");

		return radio; //Map型のinitRadioMarriageには未婚、既婚が入っている

	}

	//	ユーザの登録画面のGEt用コントローラー

	@GetMapping("/signup")
	public String getSignUp(@ModelAttribute SignupForm form, Model model) {

		//		radioMarriageに、nitRadioMarriage()で呼び出したキーと値を渡す。
		radioMarriage = initRadioMarriage();

		//		既婚、未婚Mapをmodel名「radioMariage」に登録する。
		model.addAttribute("radioMarriage", radioMarriage);

		return "login/signup";//signup.htmlへ画面がいく
	}

	//	ユーザの登録画面のPOST用コントローラー
	//	データバインド結果の受け取り
	@PostMapping("/signup")
	//ModelAttributeに登録すると、Modelクラスに勝手に登録される
	//	データバインドを受け取るには、引数にBindingResult bindingResultを追加する
//	バリデーションの実装
	public String postSignUp(@ModelAttribute @Validated(GroupOrder.class) SignupForm form,

			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) { //入力エラーがありますか？
			return getSignUp(form, model); //あるとfalseがかえってくる
		}


		System.out.println(form);

		User user = new User();

		user.setUserId(form.getUserId());
		user.setPassword(form.getPassword());
		user.setUserName(form.getUserName());
		user.setBirthday((Date) form.getBirthday());
		user.setAge(form.getAge());
		user.setMarriage(form.isMarriage());
		user.setRole("RPLE_GENERAL");


		boolean result = userService.insert(user);

		if(result == true) {
			System.out.println("insert成功");
		}else {
			System.out.println("insert失敗");
		}

		//		POST送信で来た場合、リダイレクトしている
		return "redirect:/login";
	}
}
