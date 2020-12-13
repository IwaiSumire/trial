package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Repository
public class RamenRepository {


	private final JdbcTemplate jdbcTemplate;


	public List<RamenForm> getAll() {

		String sql = "select id,name,price from sample2";

		List<Map<String, Object>> ramenList = jdbcTemplate.queryForList(sql);
		List<RamenForm> list = new ArrayList<>();

		for (Map<String, Object> x : ramenList) {

			RamenForm ramen = new RamenForm();

			ramen.setId((int)x.get("id"));
			ramen.setName((String)x.get("name"));
			ramen.setPrice((int)x.get("price"));
			list.add(ramen);
		}

		return list;
	}

}
