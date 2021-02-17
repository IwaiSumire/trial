package com.example.demo.SecurityUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.securityMapper.UserMapper;
import com.example.demo.securityUser.MyUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired //mapperをインスタンス化。DB接続をするMapperクラスを参照
	private UserMapper userMapper;

	//loadUserByUsernameは実装が必要
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		//findByUsernameで見つけてきたユーザ情報をmyUserに入れる
		MyUser myUser = userMapper.findByUsername(username);

		//UserDetailsにreturn
		return myUser;

	}
}
