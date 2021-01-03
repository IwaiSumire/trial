package com.example.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.SiteUser;
import com.example.demo.repository.SiteUserRepository;

import lombok.RequiredArgsConstructor;

/*Springsecurityの機能のクラスで、認証を行ってくれる
*/
@RequiredArgsConstructor //コンストラクタの自動生成
@Service //service層である
public class UserDetailsServiceImple implements UserDetailsService {
	//UserDetailsServiceはユーザを特定するために仕様される
	//↑にはloadUserByUsernameメソッドを実装しなければいけない

	//this.userRepository=userRepositoryされている
	private final SiteUserRepository userRepository;

	@Override//loadUserByUsernameでユーザを特定
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		//findByUsernameでrepositoryの中にあったらuserに入れる
		SiteUser user = userRepository.findByUsername(username);

		if (user == null) {//見つからなかった場合
			throw new UsernameNotFoundException(username + "見つかりません");
		}

		//GrantedAuthorityはROLE_ADMINやUSERなど、頭にROLE_を付けた文字を渡す
				Set<GrantedAuthority> grantedAuthories = new HashSet<>();
				grantedAuthories.add(new SimpleGrantedAuthority(user.getRole()));

		return new User(user.getUsername(), user.getPassword(), grantedAuthories);
	}

	/*	このUserは標準で備わっているの。
		今回はROLE_に文字を足さないといけなかったけど、そうじゃなければ
		↑のpublic UserDetails loadUserByUsernameでreturn new User(user.getUsername(), user.getPassword(), user.getRole());*/

	/*public User createUserDetails(SiteUser user) {
		//GrantedAuthorityはROLE_ADMINやUSERなど、頭にROLE_を付けた文字を渡す
		Set<GrantedAuthority> grantedAuthories = new HashSet<>();
		grantedAuthories.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));

		return new User(user.getUsername(), user.getPassword(), grantedAuthories);
	}*/
}
