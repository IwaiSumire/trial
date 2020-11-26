package com.example.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//@Repositoryと宣言
@Repository
public class HelloRepository {

//	@AutowiredはJDBCを使う場合につける
//	これをつけることによって、インスタンスが生成されている
//	private JdbcTemplate jdbcTemplate = new JdbcTemplate();が起きているイメージ

	@Autowired
	private JdbcTemplate jdbcTemplate;

	 public Map<String, Object>findOne(int id) {

		String query = "SELECT"
				+ "employee_id,"
				+ "employee_name,"
				+ "age "
				+ "FROM employee"
				+ "WHERE employee_id=?";

//		query=SELECT employeeはキーがselectで値が入力されたIDが入っている
		Map<String, Object> employee = jdbcTemplate.queryForMap(query, id);
		return employee;

	}
}