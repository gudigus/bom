package com.spring.bom.service.bear;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bom.dao.bear.ChatDao;
import com.spring.bom.model.bear.User;

@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	private ChatDao cd;
	
	@Override
	public List<User> uonline(User user){
		List<User> userlist = null;
		System.out.println("ChatServiceImpl uonline userlist => " + userlist);
		userlist = cd.uonline(user);
		System.out.println("ChatServiceImpl uonline userlist => " + userlist);
		
		return userlist;
	}
}
