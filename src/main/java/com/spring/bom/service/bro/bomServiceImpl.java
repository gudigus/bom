package com.spring.bom.service.bro;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bom.dao.bro.BomDao;
import com.spring.bom.model.bro.User_info;
@Service
public class BomServiceImpl implements BomService {
	@Autowired
	private BomDao bd;
	

	@Override
	public User_info loginCheck(User_info ui) throws Exception{
		System.out.println("service ui      "+ui);
		return bd.loginCheck(ui);
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
		
	}

	@Override
	public int join(User_info ui) {
		System.out.println("service join start");
		return bd.join(ui);
		
	}

	@Override
	public int checkEmail(String uEmail) {
		System.out.println("service uEmail--"+uEmail);
		int i = bd.checkEmail(uEmail);
		System.out.println(i + "i는");
		return i;
	    }

	

	

}
