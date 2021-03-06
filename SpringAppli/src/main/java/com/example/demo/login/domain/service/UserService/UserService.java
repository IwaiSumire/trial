package com.example.demo.login.domain.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;


@Service
public class UserService {
	@Autowired //gettersetter生成
	UserDao dao;

	public boolean insert(User user) {
		int rowNumber =dao.insertOne(user);

		boolean result = false;

		if(rowNumber > 0) {
			result = true;
		}

		return result;
	}
	//戻り値がゼロより大きければinsert成功
}
