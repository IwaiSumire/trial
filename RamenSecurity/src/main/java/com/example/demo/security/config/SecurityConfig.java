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

	/*パスワードの暗号用にbcryptを使用する
	 *ハッシュ化＝ハッシュ値（暗号みたいな文字の羅列）に変えている
	 * */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/*直リンクの禁止の記述*/

		http
				.authorizeRequests()//ルール
				.anyRequest().authenticated()//すべてのURLリクエストをloginしないと見れない
				//↑特定のページを見れるようにするにはauthenticated()に入れる
				.and()
				.formLogin()
				.failureUrl("/login")//ログイン失敗時のurlなくてもたぶんいい。
				.defaultSuccessUrl("/ramens", true);//ログインが成功したら/ramensにいく
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
				.defaultSuccessUrl("/ramens", true);//ログイン成功時の遷移先
		*/

	}

	/*インメモリにユーザー情報を設定する*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.inMemoryAuthentication()//インメモリの設定をします。
				.withUser("user")
				.password(passwordEncoder().encode("pass"))
				.authorities("ROLE_USER");//権限情報を設定

	}
}
