package com.example.demo.security.UserDetailsService;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.security.mapper.UserMapper;
import com.example.demo.security.user.MyUser;

import lombok.RequiredArgsConstructor;

/*UserDetailsServiceインターフェイスをの実装クラス*/
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {//UserDetailsServiceをimplementする

	@Autowired //mapperをインスタンス化。DB接続をするMapperクラスを参照します
	private UserMapper userMapper;

	@Override //passwordのチェックはSpringSecurityがやってくれるらしい
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		//Set<GrantedAuthority> grantedAuthories = new HashSet<>();
		//grantedAuthories.add(new SimpleGrantedAuthority(MyUser.getRole()));

		//loadUserByUsernameは実装が必要

		MyUser myUser = userMapper.findByUsername(username);//SQL発動。nameが一致したものを取得

		if (myUser == null) {//ユーザを取得できなければ
			throw new UsernameNotFoundException(username + "見つかりません");//エラー

		}

		try {

		} catch (UsernameNotFoundException e) {
			throw new UsernameNotFoundException("It can not be acquired User");
		}
		if (userMapper.findByUsername(username) == null) {
			throw new UsernameNotFoundException("User not found for login id: " + username);
		}

		Collection<GrantedAuthority> getAuthrities = new HashSet<>();

		String role = myUser.getRole();

		if ("admin".equals(role)) {
			getAuthrities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

		} else {
			getAuthrities.add(new SimpleGrantedAuthority("ROLE_USER"));

		}

		MyUser returnMyUser = new MyUser();

		returnMyUser.setUsername(myUser.getUsername());
		returnMyUser.setPassword(myUser.getPassword());

		returnMyUser.setAuthorities(getAuthrities);

		return returnMyUser;

		//MyUser myUser = new MyUser();

		//myUser.setUsername("aaaa.docomo");
		//myUser.setPassword("$2a$08$DTjs9boNV2HQXh6LwWmHquZJPuzpRWnbrYC3ZHhwSpIAVPdkKUX9O");

		//return myUser;

	}
	/*
		private UserDetails createUserDetails(MyUser myUser) {

			Collection<GrantedAuthority> getAuthrities = new HashSet<>();
			String role = myUser.getRole();

			if ("admin".equals(role)) {
				getAuthrities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

			} else {
				getAuthrities.add(new SimpleGrantedAuthority("ROLE_USER"));

			}
			// TODO 自動生成されたメソッド・スタブ
			return myUser;

		}*/

	/*
		private UserDetails createUserDetails(MyUser myUser) {
			// TODO 自動生成されたメソッド・スタブ

			Collection<GrantedAuthority> authorityList = new HashSet<>();

			String role = myUser.getRole();

			if ("admin".equals(role)) {
				authorityList.add(new SimpleGrantedAuthority("ADMIN"));
			} else {
				authorityList.add(new SimpleGrantedAuthority("USER"));

			}

			return MyUser(myUser.getUsername(), myUser.getPassword(), myUser.getNickname(), authorityList);
		}
	*/
}
