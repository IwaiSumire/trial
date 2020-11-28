package com.example.demo.Springtry;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MenuRipository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Map<String, Object> findOne(int id) {

		String query = "SELECT "
				+ "menu_id, "
				+ "menu_name, "
				+ "price "
				+ "FROM menu "
				+ "WHERE menu_id=?";

		Map<String, Object> menuDb = jdbcTemplate.queryForMap(query, id);
		return menuDb;
	}
}