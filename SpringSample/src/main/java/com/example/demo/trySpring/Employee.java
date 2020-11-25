package com.example.demo.trySpring;

import lombok.Data;

//ドメインクラス:リポジトリクラスやサービスクラスなどの間で渡すクラスのこと
public class Employee {

//	@Dataを付けると、getterとsetterを自動生成してくれる。
	@Data
	private int employeeId;
	pribate String employeeName;
	private int age;


}
