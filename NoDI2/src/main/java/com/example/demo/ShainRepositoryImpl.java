package com.example.demo;

public class ShainRepositoryImpl implements ShainRepository {

	@Override
	//	DBにアクセスしたとする
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
			name = "日高";
			break;
		default:
			name = "登録がありません";

		}

		return name;
	}

}
