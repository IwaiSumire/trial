package com.example.demo.testmapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.security.user.MyUser;

@Mapper //interfaceであること
public interface UserMapperTest {

	//select文。userテーブルから、usernameが一致しているものを検索
	@Select("select * from usertest where username = #{username}")
	public MyUser findByUsername(String username);//識別する
}
