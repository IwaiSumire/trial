package com.example.demo.security.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.example.demo.security.user.MyUser;

@Mapper //interfaceであること
public interface UserMapper {

	//select文。userテーブルから、usernameが一致しているものを検索
	@Select("select * from user where username = #{username}")
	public MyUser findByUsername(String username);//識別する

	@Insert("insert into user (username, password,role) values (#{username}, #{password}, #{role})")
	@Options(useGeneratedKeys = true) //勝手に登録
	void insert(MyUser user);

	@Select("select nickname from user where username = #{username}")
	public String findRegistrationrname(String username);//識別する

}
