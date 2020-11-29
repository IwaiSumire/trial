package com.example.demo.login.domain.model;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data //勝手にgettr、setterを生成してくれる機能
public class SignupForm {

	private String userId;
	
	private String password;
	
	private String userName;

	@DateTimeFormat(pattern = "yyyy/MM/dd")//日付変換も表示の仕方も変えてくれる
	private Date birthday;

	private int age;

	private boolean marriage;
}
