package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.SiteUser;

/*repositoryクラス。
データベースのaccess処理を自動的に生成して実装してくれる*/

public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {

	SiteUser findByUsername(String username);//名前を見つけてくる

	boolean existsByUsername(String username);//存在するか？

}
