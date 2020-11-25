package com.example.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Serviceはサービスクラスにつけるアノテーション
@Service
public class HelloService {

//	@Autowiredをつけるとインスタンス化みたいになる。HelloRepositoryインスタンス
	@Autowired
	private HelloRepository helloRepository;

	public Employee findOne(int id) {
		Map<String,Object> map = helloRepository.findOne(id);


		int employeeId = (Integer)map.get("employee_id");

		String employeeName = (String)map.get("employee_name");
		int age = (Integer)map.get("age");

		return employee;
	}

}
