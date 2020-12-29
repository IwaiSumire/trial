package com.example.demo.security.Userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.security.details.RamenUserDetails;
import com.example.demo.security.mapper.UserMapper;
import com.example.demo.security.user.User;

/*るUserDetailsServiceインターフェイスをの実装クラス*/
@Service
public class UserService implements UserDetailsService {//UserDetailsServiceをimplementする

	@Autowired//mapperをインスタンス化。DB接続をするMapperクラスを参照します
	private UserMapper userMapper;

	@Override//passwordのチェックはSpringSecurityがやってくれるらしい
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userMapper.findByUsername(username);//SQL発動。nameが一致したものを取得

		if (user == null) {//ユーザを取得できなければ
			throw new UsernameNotFoundException(username + "見つかりません");

		}
		return new RamenUserDetails(user);

	}

}
