package com.example.demo.security.user;

import lombok.Data;

/*ユーザ情報を保持するクラス
 * Entityクラス*/
@Data//getter setter生成
public class User {

	private Long userId;

	private String username;

	private String password;


}
