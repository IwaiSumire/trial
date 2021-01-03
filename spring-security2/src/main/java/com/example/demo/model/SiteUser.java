package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.demo.validator.UniqueLogin;

import lombok.Data;
import lombok.Setter;

/*Entityクラス
ゲッターセッターの生成
validationの設定*/

@Setter
@Entity
@Data
public class SiteUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//主キーに対して値を自動生成する
	private Long id;

	@Size(min = 2, max = 20)
	@UniqueLogin//自作validationの同じ名前を登録できないようにする
	private String username;

	@Size(min = 4,max=255)
	private String password;

	@NotBlank
	@Email
	private String email;

	private int gender;
	private boolean admin;
	private String role;
	private boolean active = true;


}
