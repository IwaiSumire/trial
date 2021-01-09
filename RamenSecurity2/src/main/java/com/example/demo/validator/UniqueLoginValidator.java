package com.example.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.security.mapper.UserMapper;

public class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {

	private final UserMapper userMapper;

	public UniqueLoginValidator() {
		this.userMapper = null;
	}

	@Autowired //初期処理
	public UniqueLoginValidator(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override //ここにチェック処理を実装する
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return userMapper == null || userMapper.findByUsername(value) == null;
		//パターンに合っていたらtrue、違ったらfalse
	}
}
