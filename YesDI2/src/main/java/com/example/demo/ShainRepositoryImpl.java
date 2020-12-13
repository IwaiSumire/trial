package com.example.demo;

import org.springframework.stereotype.Repository;

@Repository
public class ShainRepositoryImpl implements ShainRepository {

	@Override
	public String selectByNo(String number) {
		String name;

		switch (number) {
		case "100":
			name = "佐藤";
			break;
		case "101":
			name = "鈴木";
			break;
		case "102":
			name = "岩井";
			break;
		default:
			name = "登録させていません";
			break;
		}
		return name;
	}

}
