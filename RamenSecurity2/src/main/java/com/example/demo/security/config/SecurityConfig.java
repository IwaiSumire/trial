package com.example.demo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
			.authorizeRequests()//ルール、アクセスポリシーの設定
				.antMatchers("/login").permitAll()//loginは認証なしでaccessできる
				.anyRequest().authenticated()//↑以外のすべてのURLリクエストをloginしないと見れない
				//↑特定のページを見れるようにするにはauthenticated()に入れる
				.and()
			.formLogin()//ログインの設定
			    .loginPage("/login")
				.failureUrl("/login")//ログイン失敗時のurl。
				.defaultSuccessUrl("/ramens", true)//ログインが成功したら/ramensにいく
				.usernameParameter("user")
	            .passwordParameter("pass")
				.and()
			.logout()//ログアウトの設定
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//ログアウト時の移行先
				.logoutSuccessUrl("/login")// ログアウト時に削除するクッキー名
				.deleteCookies("JSESSIONID")// ログアウト時のセッション破棄を有効化
                .invalidateHttpSession(true).permitAll()//ログアウトしたらsessionを無効にする
				.and()
			.rememberMe();//Remember-Meを有効化チェックボックスができる

	}


}
