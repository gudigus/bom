package com.spring.bom.dao.bro;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bom.model.bro.User_info;

@Repository
public class User_infoDaoImpl implements User_infoDao {
	@Autowired
	private SqlSession session;

	@Override
	public User_info login(User_info user_info) {
		System.out.println("User_infoDaoImp login");
		
		return session.selectOne("user_check",user_info);
	}
	
}
