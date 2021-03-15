package com.spring.bom.service.bro;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bom.dao.bro.bomDao;
import com.spring.bom.model.bro.User_info;
@Service
public class bomServiceImpl implements bomService {
	@Autowired
	private bomDao bd;

	@Override
	public User_info loginCheck(User_info ui) throws Exception{
		System.out.println("service ui      "+ui);
		return bd.loginCheck(ui);
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
		
	}
	

	

}