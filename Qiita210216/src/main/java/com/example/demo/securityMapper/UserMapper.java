package com.example.demo.securityMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.securityUser.MyUser;

@Mapper
public interface UserMapper {

	//select文。userテーブルから、usernameが一致しているものを検索
	@Select("select * from loginuser where username = #{username}")
	public MyUser findByUsername(String username);//識別する

}
