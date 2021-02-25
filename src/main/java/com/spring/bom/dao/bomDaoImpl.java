package com.spring.bom.dao;



import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bom.model.user_info;
@Repository
public class bomDaoImpl implements bomDao {
	@Autowired
	private SqlSession session;

	@Override	
	public user_info login(user_info ui) throws Exception{
		return session.selectOne("user_info",ui);
	}

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		
	}
	 

	
		
	
	
	

}
