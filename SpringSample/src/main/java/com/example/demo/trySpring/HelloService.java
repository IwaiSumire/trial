package com.example.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Serviceはサービスクラスにつけるアノテーション
//イメージは　private HelloRepository helloRepository = new HelloRepository();
@Service
public class HelloService {

	//	@Autowiredをつけるとインスタンス化みたいになる。HelloRepositoryインスタンス
	@Autowired
	private HelloRepository helloRepository;

	//引数のあるコンストラクタからここに呼ばれる
	//int idは、コントローラーから来た入力されたＩＤのこと
	public Employee findOne(int id) {

		//1件検索実行
		//MapのキーString型、値の型Object(何でもつっこめる)
		//		コンストラクタが呼ばれる。HelloRepositoryのpublic Map<String, Object>findOne(int id)へ

		Map<String, Object> map = helloRepository.findOne(id);

		//		コンストラクタからselect文の実行結果（employee）が返ってきた

		//Mapから値を取得
		//map.getの意味Mapに入っている
		int employeeId = (Integer) map.get("employee_id");
		String employeeName = (String) map.get("employee_name");
		int age = (Integer) map.get("age");

		//		Employeeクラスに値をセット

		Employee employee = new Employee();

		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(employeeName);
		employee.setEmployeeAge(age);

		return employee;
	}

}
