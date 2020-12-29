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

	@Override//ユーザに付与された権限を返す
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


	@Override//ユーザ認証に使用されるパスワードを返す。
	public String getPassword() {
		// TODO 自動生成されたメソッド・スタブ
		return this.user.getPassword();
	}


	@Override//ユーザ認証に使用されるユーザ名を返す。
	public String getUsername() {
		// TODO 自動生成されたメソッド・スタブ
		return this.user.getUsername();
	}

	@Override//アカウントの有効期限が切れているかを示す
	public boolean isAccountNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override//ユーザがロックされているか解除されているか示す
	public boolean isAccountNonLocked() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override//ユーザの資格情報（パス）の有効期限が切れているかどうか
	public boolean isCredentialsNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override//ユーザが無効か示す。
	public boolean isEnabled() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

}
