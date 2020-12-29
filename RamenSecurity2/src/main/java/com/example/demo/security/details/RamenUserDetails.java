package com.example.demo.security.details;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.security.user.User;


/*認証ユーザを管理するクラス*/
public class RamenUserDetails implements UserDetails {

	private User user;

	public RamenUserDetails(User user) {
		this.user = user;//コンストラクタ
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	//自分用に、どの列をパスワードとして使うか変えましょう
	@Override
	public String getPassword() {
		// TODO 自動生成されたメソッド・スタブ
		return this.user.getPassword();
	}

	//自分用に、どの列をユーザ名として使うか変えましょう
	@Override
	public String getUsername() {
		// TODO 自動生成されたメソッド・スタブ
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

}
