package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.security.mapper.UserMapper;
import com.example.demo.security.user.MyUser;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	@Transactional
	public void insert(MyUser user) {
		userMapper.insert(user);
	}

	@Transactional
	public void selectOne(MyUser user) {
		userMapper.selectOne(user);
	}

}
