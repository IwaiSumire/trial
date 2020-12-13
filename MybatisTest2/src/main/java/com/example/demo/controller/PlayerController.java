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

import com.example.demo.domain.Player;
import com.example.demo.service.PlayerService;

@Controller
@RequestMapping("/players") //処理対照とするURLを指定する
public class PlayerController {

	@Autowired //インスタンス化
	private PlayerService playerService;

	@GetMapping("") //まずこれが処理される URL:/players
	public String index(Model model) {
		model.addAttribute("players", playerService.findAll());//全件検索をserviceにさせる
		return "players/index";//index.html 選手一覧画面へ
	}

	@GetMapping("new") //URL:/players/new
	public String newPlayer() {
		return "players/new"; //new.html 選手の登録画面へ
	}

	@GetMapping("{id}/edit") //players/id番号(選択した選手のid)/edit
	//@PathVariableはURLに含まれる動的なパラメータを受け取ることができる
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("player", playerService.findOne(id));
		return "players/edit";//edit.html 選択した選手のformのupdate画面へ
	}

	@GetMapping("{id}") //players/id番号(選択した選手のid)
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("player", playerService.findOne(id));//playerには選択した選手の情報が入っている
		return "players/show";//show.html 選手１人の登録内容確認画面へ
	}

	@PostMapping("") //players/id番号(勝手に作られたid)//postなのでURL出ない
	public String create(@ModelAttribute Player player) {
		playerService.save(player);
		return "redirect:/players";//一覧表に戻る
	}

	@PutMapping("{id}") //players/id番号(選択した選手のid)//postなのでURL出ない
	public String updata(@PathVariable Long id, @ModelAttribute Player player) {
		player.setId(id);
		playerService.update(player);//更新された
		return "redirect:/players";//一覧表に戻る
	}

	@DeleteMapping("{id}") //players/id番号(選択した選手のid)//postなのでURL出ない
	public String destroy(@PathVariable Long id) {
		playerService.delete(id);//idをつかって消去
		return "redirect:/players";//一覧表に戻る
	}
}
