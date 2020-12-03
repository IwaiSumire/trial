package com.example.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Serviceはサービスクラスにつけるアノテーション

//serviceは指示があれば指示にしたがって提供する
//もらったものに対して何か返す service

@Service
public class HelloService {

	// @Autowiredをつけるとインスタンス化みたいになる。HelloRepositoryインスタンス
	// イメージは private HelloRepository helloRepository = new HelloRepository();
	@Autowired
	private HelloRepository helloRepository;//インスタンス化

	//int idは、コントローラーから来た入力されたＩＤのこと
	public Employee findOne(int id) {

		//1件検索実行
		//MapのキーString型、値の型Object(何でもつっこめる)
		//。HelloRepositoryのpublic Map<String, Object>findOne(int id)へ

		Map<String, Object> map = helloRepository.findOne(id);
		//findOne(id);に引数にidを入れているから実行される
		//select文の実行結果（employee）が返ってきた

		//Mapから値を取得
		//map.getの意味Mapに入っている
		int employeeId = (Integer) map.get("employee_id");
		String employeeName = (String) map.get("employee_name");
		int age = (Integer) map.get("age");

		//		Employeeクラスに値をセット
		//employee＝従業員　インスタンス化

		Employee employee = new Employee();
		//コンストラクタが呼ばれる→getterとsetter取得
		//箱をインスタンス化
		//findOne

		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(employeeName);
		employee.setEmployeeAge(age);

		//箱たちに抽出した値をつめていく

		return employee;
	}

}