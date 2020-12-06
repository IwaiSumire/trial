package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Comment;

@Repository //このクラスがリポジトリである
//JpaRepositoryを継承するだけでDBの取得、保存等できるようになる
public interface CommentRepository extends JpaRepository<Comment, Long>{

}
