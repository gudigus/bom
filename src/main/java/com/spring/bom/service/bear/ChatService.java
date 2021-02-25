package com.spring.bom.service.bear;

import java.util.List;

import com.spring.bom.model.bear.User;

public interface ChatService {

	
	
	//user 온라인유저 조회
	List<User> 		uonline(User user);
}
