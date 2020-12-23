package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/*securityを設定する場合、WebSecurityConfigurerAdapterを継承して
クラスを作成する。アノテーションはふたつ付ける。
@EnableWebSecurityはセキュリティの機能を有効にするのに必要。*/

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	/*パスワードの暗号用にbcryptを使用する
	 *ハッシュ化＝ハッシュ値（暗号みたいな文字の羅列）に変えている
	 * */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*httpはリクエストの設定*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		//リクエストの設定
		.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.formLogin();
	}


	/*authはユーザの設定*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth
		.inMemoryAuthentication()
		.withUser("user")
		.password(passwordEncoder().encode("password"))
		.authorities("ROLE_USER");
	}

}
