package com.example.demo.util;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;


public class Type {

	//変更しないGENDERSmapを作成
	public static final Map<Integer, String> GENDERS;

	/*staticイニシャライザ
	クラスをロード時に一度だけ実行されるコードブロック*/
	static {
		Map<Integer, String> genders = new LinkedHashMap<>();
		genders.put(0, "選択しない");
		genders.put(1, "男性");
		genders.put(2, "女性");
		genders.put(3, "その他");


		//unmodifiableMapは変更不可能なmapを返す
		GENDERS = Collections.unmodifiableMap(genders);
		//genderの中には0～３が入っている
		//Collections.unmodifiableMapで変更不可能にする

	}

}
