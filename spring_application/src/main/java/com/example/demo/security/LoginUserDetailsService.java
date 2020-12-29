package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Employee;
import com.example.demo.domain.EmployeeExample;
import com.example.demo.mybatis.mapper.EmployeeMapper;

/***
 * ログインイン時に認証ユーザーを「employeeテーブル」から情報を取得するクラス
 */
@Service
public class LoginUserDetailsService implements UserDetailsService {

    @Autowired
    EmployeeExample employeeExample;

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        //入力された名前をキーにemployeeテーブルのレコードを1件取得

        Employee employee = employeeMapper.selectByName(name);

        //該当レコードが取得できなかった場合はエラーにする
        if  (employee   ==  null)   {
            throw new UsernameNotFoundException("Wrong email or password");
        }

        //ログインユーザー権限を設定
        String role = "ROLE_ADMIN";

        return new LoginUserDetails(employee, role);
    }

}
