package com.spring.bom.dao;

import javax.servlet.http.HttpSession;

import com.spring.bom.model.user_info;

public interface bomDao {
	public user_info login(user_info ui) throws Exception;
	public void logout(HttpSession session);

}
