package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.SiteUser;
import com.example.demo.repository.SiteUserRepository;
import com.example.demo.util.Role;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //コンストラクタ生成
@Controller
public class SecurityController {

	//コンストラクタ生成されている
	private final SiteUserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/login") //URLにloginの入力がきたら
	public String login() {
		return "login";//loginのhtmlを返す
	}

	//Authenticationで承認済のユーザ情報を取得できる。

	@GetMapping("/") //ログインができて、urlが/になったとき
	public String showList(Authentication loginUser, Model model) {
		/*このような書き方もできる
		Authentication loginUser=SecurityContexHolder.getContext().getAuthentication();*/
		model.addAttribute("username", loginUser.getName());//Authenticationでとってきたnameを"username"に入れる
		model.addAttribute("role", loginUser.getAuthorities());//AuthenticationでとってきたAuthoritiesを"role"に入れる
		return "user";//usernameとroleをuser.htmlで使える
	}

	@GetMapping("admin/list")
	public String showAdminList(Model model) {
		model.addAttribute("users", userRepository.findAll());//userに全件取得分が入っている
		return "list";//list.htmlで"users"が使える
	}

	@GetMapping("/register") //＝登録//login画面から新規登録buttonが押される
	public String register(@ModelAttribute("user") SiteUser user) {
		return "register";//register.htmlへ
	}

	@PostMapping("/register") //registerで登録ボタンを押されたとき userに名前、権限、性別等詰める
	public String process(@Validated @ModelAttribute("user") SiteUser user, BindingResult result) {

		//validationにひっかかったら
		if (result.hasErrors()) {
			return "register";//register.htmlでvalidation表示
		}

		//validationにひっかからなければ、パスワードを登録
		user.setPassword(passwordEncoder.encode(user.getPassword()));//パスワードset

		if (user.isAdmin()) {//もしADMIN(管理者名なら)
			user.setRole(Role.ADMIN.name());//権限のADMINに名前を登録
		} else {
			user.setRole(Role.USER.name());//権限のUSERに名前を登録
		}

		//userの登録
		userRepository.save(user);//repositoryクラスに登録

		return "redirect:login?register";//login.htmlへ戻る
	}

}
