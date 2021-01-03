package com.example.demo.security.Userservice;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.security.mapper.UserMapper;
import com.example.demo.security.user.SIteUser;

import lombok.RequiredArgsConstructor;

/*UserDetailsServiceインターフェイスをの実装クラス*/
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {//UserDetailsServiceをimplementする

	@Autowired //mapperをインスタンス化。DB接続をするMapperクラスを参照します
	private UserMapper userMapper;

	@Override //passwordのチェックはSpringSecurityがやってくれるらしい
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//loadUserByUsernameは実装が必要

		SIteUser user = userMapper.findByUsername(username);//SQL発動。nameが一致したものを取得

		if (user == null) {//ユーザを取得できなければ
			throw new UsernameNotFoundException(username + "見つかりません");//エラー

		}

		Set<GrantedAuthority> grantedAuthories = new HashSet<>();
		grantedAuthories.add(new SimpleGrantedAuthority(user.getRole()));


		return new User(user.getUsername(), user.getPassword(), grantedAuthories);



	}

}