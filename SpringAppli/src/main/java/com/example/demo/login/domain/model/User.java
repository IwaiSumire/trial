package com.example.demo.login.domain.model;

import java.sql.Date;

import lombok.Data;

@Data //勝手にgetter setterをつくる
public class User {

	private String userId;
	private String password;
	private String userName;
	private Date birthday;
	private int age;
	private boolean marriage;
	private String role; //ロール？？
}
