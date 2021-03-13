package com.spring.bom.service.bro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bom.dao.bro.User_infoDao;
import com.spring.bom.model.bro.User_info;


@Service
public class User_infoServiceImpl implements User_infoService {
	@Autowired
	private User_infoDao ud;

	@Override
	public User_info login(User_info user_info) {
		// TODO Auto-generated method stub
				System.out.println("User_infoServiceImpl login");
				return ud.login(user_info);
	} 
}
