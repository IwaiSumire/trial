package com.example.demo.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http)throws Exception {

		/*直リンクの禁止の記述*/

		http
		.authorizeRequests()
		 .antMatchers("/login").permitAll()//ログインページは直リンクOK
		 .anyRequest().fullyAuthenticated();//↑以外は直リンク禁止


		/*ログインの処理*/

		http
		.formLogin()
		 .loginProcessingUrl("/login/login")//ログイン処理のパス
		 .loginPage("/login/login")//ログインページ指定
		 .failureUrl("/login/login")//ログイン失敗時の遷移先
		 .usernameParameter("userId")//ID
		 .passwordParameter("password")//パス
		 .defaultSuccessUrl("/top", true);//ログイン成功時の遷移先
	}

}
