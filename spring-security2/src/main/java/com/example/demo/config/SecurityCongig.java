package com.example.demo.config;

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

import com.example.demo.util.Role;

import lombok.RequiredArgsConstructor;

//extendsする
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor //コンストラクタ生成
public class SecurityCongig extends WebSecurityConfigurerAdapter {

	//コンストラクタ生成されている
	private final UserDetailsService userDetailsService;

	@Bean//暗号化用
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();//エンコード
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		/*セキュリティの設定を無視するパスを指定
		CSS配下のものすべてと、web.jarsの配下すべて*/
		web.ignoring().antMatchers("/js/**","/css/**", "/webjars/**");
	}

	//URLごとの設定
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()//■全体設定
				.antMatchers("/login","/register").permitAll()//access可能なurl
				.antMatchers("/admin/**").hasRole(Role.ADMIN.name())// /adminはadminユーザだけaccess可能にする
				.anyRequest().authenticated()//↑以外のURLは全部認証が必要である
				.and()
				.formLogin()//■ログインの設定
				.loginPage("/login")//ログインページ
				.defaultSuccessUrl("/")//ログイン成功後のURL
				.and()
				.logout()//■ログアウトの設定
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//ログアウト時のURL
				.and()
				.rememberMe();//ログインしたままにするチャックボックスがつく
	}

	//ユーザの設定
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth

		//userDetailsServieを利用してDBからユーザを参照できるようにする
		.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder());


				/*ユーザ名adminと、userを用意する
				両方ともパスワードはpasswordにする
				authoritiesで権限に基づいた設定ができるようになる*/

				/*.inMemoryAuthentication()
				.withUser("admin")//管理者名
				.password(passwordEncoder().encode("password"))
				.authorities("ROLE_ADMIN")//管理者
				.and()
				.withUser("user")//ユーザ名
				.password(passwordEncoder().encode("password"))
				.authorities("ROLE_USER");//ユーザ
*/
		}
}
