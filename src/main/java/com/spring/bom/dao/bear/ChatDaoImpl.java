package com.spring.bom.dao.bear;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bom.model.bear.User;

@Repository
public class ChatDaoImpl implements ChatDao {
	// Mybatis 세션 
	@Autowired
	private SqlSession session;
		
	@Override
	public List<User> uonline(User user){
		
		List<User> uonline = null;
		try {
			uonline = session.selectList("listOnline", user);
		} catch (Exception e) {
			System.out.println("UserDaoImpl uonline e.getMessage() -> " + e.getMessage());
			
		}
		System.out.println("UserDaoImpl uonline.size() ->  "   + uonline.size());
		return uonline;
	}
	
		

}
