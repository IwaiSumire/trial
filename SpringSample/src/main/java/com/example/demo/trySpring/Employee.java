package com.example.demo.trySpring;

import lombok.Data;

//ドメインクラス:リポジトリクラスやサービスクラスなどの間で渡すクラスのこと
//@Dataを付けると、getterとsetterを自動生成してくれる。
//DBとJavaの架け橋、はこを作った

@Data
public class Employee {

	private int employeeId; //従業員ID
	private String employeeName;//従業員名
	private int employeeAge;//年齢

}
