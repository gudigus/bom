package com.spring.bom.service;

import javax.servlet.http.HttpSession;

import com.spring.bom.model.user_info;

public interface bomService {
	public user_info login(user_info ui) throws Exception;
	public void logout(HttpSession session);

}
