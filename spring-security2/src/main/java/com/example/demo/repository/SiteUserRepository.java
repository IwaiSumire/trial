package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.SiteUser;

/*repositoryクラス。
データベースのaccess処理を自動的に生成して実装してくれる
jpaを使ってsqlを書かなくても接続してくれる*/

public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {

	SiteUser findByUsername(String username);//名前を１件取得

	boolean existsByUsername(String username);//存在するか？


}
