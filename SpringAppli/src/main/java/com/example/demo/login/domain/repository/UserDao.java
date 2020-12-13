package com.example.demo.login.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.login.domain.model.User;

//インターフェースを作成
//後で中身の実装クラスを切り替えられるように
public interface UserDao {

	//Userテーブルの件数を取得
	public int count() throws DataAccessException;

	//Userテーブルにデータを1件insert
	public int insertOne(User user) throws DataAccessException;

	//Userテーブルのデータを１件取得
	public User selectOne(String userId) throws DataAccessException;

	//Userテーブルのすべてのデータを取得
	public List<User> selectMany() throws DataAccessException;

	//Userテーブルを1件更新
	public int updateOne(User user) throws DataAccessException;

	//Userテーブルを１件消去
	public int deleteOne(String userId) throws DataAccessException;

	//SQL取得結果をサーバにCSVで保存する
	public void userCsvOut() throws DataAccessException;
}

//DataAccessExceptionはDBで例外が発生した場合Springが提供しているエラー文を投げる。
