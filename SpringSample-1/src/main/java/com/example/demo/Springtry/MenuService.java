package com.example.demo.Springtry;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MenuService {

	@Autowired
	private MenuRipository menuRepository;

	public Menu findOne(int id) {

		Map<String, Object> map = menuRepository.findOne(id);

		int menuId = (Integer) map.get("menu_id");
		String menuName = (String) map.get("menu_name");
		int price = (Integer) map.get("price");

		Menu menu = new Menu();

		menu.setMenuId(menuId);
		menu.setMenuName(menuName);
		menu.setMenuprice(price);

		return menu;
	}

}
