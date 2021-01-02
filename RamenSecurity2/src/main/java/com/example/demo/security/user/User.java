package com.example.demo.security.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;

/*ユーザ情報を保持するクラス
 * Entityクラス*/
@Getter //getter setter生成
@Setter
public class User {

	@Id
	private Long userId;

	@Email
	@NotBlank
	private String username;

	@Size(min = 2, max = 20)
	@NotBlank
	private String password;

}
