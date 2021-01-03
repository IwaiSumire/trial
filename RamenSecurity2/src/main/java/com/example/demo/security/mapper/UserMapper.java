package com.example.demo.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.userdetails.User;

@Mapper//interfaceであること
public interface UserMapper {

	//select文。userテーブルから、usernameが一致しているものを検索
	@Select("select * from user where username = #{username}")
	public User findByUsername(String username);//識別する

}
