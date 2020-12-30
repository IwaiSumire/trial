package com.example.demo.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.security.user.User;

@Mapper//interfaceであること
public interface UserMapper {

	//select文。userテーブルから、usernameが一致しているものを検索
	@Select("select * from user where username = #{username}")
	User findByUsername(String username);//識別する

}