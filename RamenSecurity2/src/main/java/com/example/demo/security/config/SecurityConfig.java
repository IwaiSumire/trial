package com.example.demo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
/*@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)　←エラーでる*/
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;



	/*パスワードの暗号用にbcryptを使用する
	 *ハッシュ化＝ハッシュ値（暗号みたいな文字の羅列）に変えている
	 * */

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		web.ignoring().antMatchers("/css/**");
	}

	@Bean //パスワードのエンコードの指定（エンコード化は他にも色々ある）
	public BCryptPasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Override //urlごとに異なる設定をする
	protected void configure(HttpSecurity http) throws Exception {

		/*直リンクの禁止の記述*/

		http
				.authorizeRequests()//ルール、アクセスポリシーの設定
				.antMatchers("/login", "/newUser").permitAll()//loginは認証なしでaccessできる
				.antMatchers("/newUser").hasRole("ADMIN")
				.anyRequest().authenticated()//↑以外のすべてのURLリクエストをloginしないと見れない
				//↑特定のページを見れるようにするにはauthenticated()に入れる
				.and()
				.formLogin()//ログインの設定
				.loginPage("/login")
				//.failureUrl("/login")//ログイン失敗時のurl。デフォルトでerror?になってる
				.defaultSuccessUrl("/ramens", true)//ログインが成功したら/ramensにいく
				.and()
				.logout()//ログアウトの設定
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//ログアウトページ
				.and()
				.rememberMe();//Remember-Meを有効化チェックボックスができる

	}

	@Override //認証方法の実装の設定を行う
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth
				.userDetailsService(userDetailsService);//userDetailsServiceを使って、DBからユーザを参照する

		//.passwordEncoder((new BCryptPasswordEncoder()));←上で設定してるから不要

	}

}
