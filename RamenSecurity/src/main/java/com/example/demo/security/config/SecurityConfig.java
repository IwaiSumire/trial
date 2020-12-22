package com.example.demo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/*直リンクの禁止の記述*/

		http
				.authorizeRequests()
				.anyRequest().authenticated()
				.and()
				.formLogin();
		//.authorizeRequests()
		//.antMatchers("/login").permitAll()//ログインページは直リンクOK
		//.anyRequest().fullyAuthenticated();//↑以外は直リンク禁止

		/*ログインの処理*/

		/*http
				.formLogin()
				.loginProcessingUrl("/login")//ログイン処理のパス
				.loginPage("/login")//ログインページ指定
				.failureUrl("/login")//ログイン失敗時の遷移先
				.usernameParameter("userId")//ID
				.passwordParameter("password")//パス
				.defaultSuccessUrl("/top", true);//ログイン成功時の遷移先
		*/

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.inMemoryAuthentication()
				.withUser("user")
				.password(passwordEncoder().encode("password"))
				.authorities("ROLE_USER");
	}
}
