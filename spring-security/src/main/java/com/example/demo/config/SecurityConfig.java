package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*セキュリティの設定の場合、WebSecurityConfigurerAdapterを継承してクラスを作成する
*/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*暗号にする*/
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		//パスワードの暗号化用。
		return new BCryptPasswordEncoder();
	}

	/*URL毎の設定をする。リクエストの設定をする*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()//認証リクエストの設定
				.anyRequest().authenticated()
				.and()
				.formLogin();//ログインの設定
	}

	/*	ユーザの設定をする
	*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.inMemoryAuthentication()//インメモリの設定
				.withUser("user")
				.password(passwordEncoder().encode("password"))//暗号化（エンコード）
				.authorities("RORE_USER");
	}

}
