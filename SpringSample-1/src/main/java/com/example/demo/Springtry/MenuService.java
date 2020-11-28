package com.example.demo.Springtry;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MenuService {

	@Autowired
	private MenuRipository menuRepository;

	//③引数でidを受け取った
	public Menu findOne(int id) {

		/*④menuRepositoryで引数idを使って1個取得してねとメソッドに指示
		    そしてmenuRepositoryでDBにアクセスして戻り値がMapmapに入っている*/
		
		Map<String, Object> map = menuRepository.findOne(id);

		//⑤Map mapから必要な情報をJava形式に変える
		int menuId = (Integer) map.get("menu_id");
		String menuName = (String) map.get("menu_name");
		int price = (Integer) map.get("price");
		
		
		//メニューのインスタンス化
		Menu menu = new Menu();
		
		//⑥インスタンスにDBの情報をJava化したデータを突っ込む
		menu.setMenuId(menuId);
		menu.setMenuName(menuName);
		menu.setMenuprice(price);

		return menu;
	}

}
