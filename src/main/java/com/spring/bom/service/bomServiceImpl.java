package com.spring.bom.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bom.dao.bomDao;
import com.spring.bom.model.user_info;
@Service
public class bomServiceImpl implements bomService {
	@Autowired
	private bomDao bd;

	@Override
	public user_info login(user_info ui) throws Exception{
		return bd.login(ui);
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
		
	}
	

	

}
