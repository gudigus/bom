package com.spring.bom.dao.bro;





import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bom.model.bro.User_info;

@Repository
public class BomDaoImpl implements BomDao {
	@Autowired
	private SqlSession session;

	@Override	
	public User_info loginCheck(User_info ui) throws Exception{
		System.out.println("dao ui      "+ui);
		return session.selectOne("login",ui);
	}

	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int join(User_info ui) {
		System.out.println("dao join start");
		int succ = 0;
		succ = session.insert("join", ui); 
		
		return succ;
		
	}

	@Override
	public int checkEmail(String uEmail) {
		System.out.println("dao uEmail--"+uEmail);
		int result = session.selectOne("checkEmail",uEmail);
		System.out.println("dao result-- "+ result );
		return result;
	}
	 

	

	
		
	
	
	

}
