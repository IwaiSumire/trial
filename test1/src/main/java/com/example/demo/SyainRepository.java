package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//このクラスでDBとaccessする

@Repository
public class SyainRepository {

	//これがあるとDBと連携が簡単にできる
	//getAllとかqueryForListとかsaveとかが使えるようになる

	private final JdbcTemplate jdbcTemplate;

	public SyainRepository(JdbcTemplate jdTemplate) {
		this.jdbcTemplate = jdTemplate;
	}

	//ListのgetAllに全データをいれる
	public List<Syain> getAll() {

		//SQL文を定義 users
		String sql = "select id,last_name,first_name from users";

		//queryForList()で全部取得
		//List<Map<String, Object>>には
		//	List	【Map：id/lastname/firstname】【Map：id/lastname/firstname】…
		List<Map<String, Object>> syainList = jdbcTemplate.queryForList(sql);

		//Listを使う前に、空のリストを用意する
		List<Syain> list = new ArrayList<>();



		for (Map<String, Object> str1 : syainList) { //syainListが終わるまで
			Syain syain = new Syain();//syainインスタンス化
			//インスタンス化したsyainの中に、情報をつっこんでいく
			syain.setId((int) str1.get("id"));
			syain.setFirst_name((String) str1.get("last_name"));
			syain.setLast_name((String) str1.get("first_name"));
			list.add(syain);
		}

		return list;
	}

}
