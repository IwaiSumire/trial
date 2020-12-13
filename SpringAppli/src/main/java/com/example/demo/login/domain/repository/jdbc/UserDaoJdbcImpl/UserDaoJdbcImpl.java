package com.example.demo.login.domain.repository.jdbc.UserDaoJdbcImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;

@Repository
public class UserDaoJdbcImpl implements UserDao {

	@Autowired //これがついているフィールドに代入する
	JdbcTemplate jdbc;

	//m_userテーブル
	//insert１件登録
	@Override
	public int count() throws DataAccessException {

		return 0;
	}

	@Override
	public int insertOne(User user) throws DataAccessException {

		int rowNumber = jdbc.update("insert into m_user(user_id, "
				+"password, "
				+"user_name, "
				+"birthday, "
				+"age, "
				+"marriage, "
				+"role)"
				+"values(?,?,?,?,?,?,?) "
				,user.getUserId()
				,user.getPassword()
				,user.getUserName()
				,user.getBirthday()
				,user.getAge()
				,user.isMarriage()
				,user.getRole());
//Userクラスで作った@Data

		return rowNumber;
	}

	@Override
	public User selectOne(String userId) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<User> selectMany() throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public int updateOne(User user) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int deleteOne(String userId) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public void userCsvOut() throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ

	}

}
