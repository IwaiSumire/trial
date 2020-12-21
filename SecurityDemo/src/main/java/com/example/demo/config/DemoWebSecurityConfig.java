package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class DemoWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception { //configure=構成

		http
				.authorizeRequests()//対象のリクエストを指定
				.mvcMatchers("/hello").permitAll()//hello.htmlが常にaccess可
				.anyRequest().authenticated()//すべてのリクエストは承認が必要（↑以外）
				.and()
				.formLogin()//フォーム認証の設定をする
				.defaultSuccessUrl("/success");//成功の時のページ

	}

}
