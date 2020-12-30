package com.example.demo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
/*@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)　←エラーでる*/
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	/*パスワードの暗号用にbcryptを使用する
	 *ハッシュ化＝ハッシュ値（暗号みたいな文字の羅列）に変えている
	 * */

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override//urlごとに異なる設定をする
	protected void configure(HttpSecurity http) throws Exception {

		/*直リンクの禁止の記述*/

		http
				.authorizeRequests()//ルール、アクセスポリシーの設定
				.antMatchers("/login").permitAll()//loginは認証なしでaccessできる
				.anyRequest().authenticated()//↑以外のすべてのURLリクエストをloginしないと見れない
				//↑特定のページを見れるようにするにはauthenticated()に入れる
				.and()
				.formLogin()//ログインの設定
				.loginPage("/login")
				.failureUrl("/login")//ログイン失敗時のurl。
				.defaultSuccessUrl("/ramens/top", true)//ログインが成功したら/ramensにいく
				.usernameParameter("username")//htmlのnameと一致させる
				.passwordParameter("password")//htmlのnameと一致させる
				.and()
				.logout()//ログアウトの設定
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//ログアウト時の移行先
				.logoutSuccessUrl("/login")// ログアウト時に削除するクッキー名
				.deleteCookies("JSESSIONID")// ログアウト時のセッション破棄を有効化
				.invalidateHttpSession(true).permitAll()//ログアウトしたらsessionを無効にする
				.and()
				.rememberMe();//Remember-Meを有効化チェックボックスができる

	}

	@Autowired//認証方法の実装の設定を行う
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth
		.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder());

	}


}