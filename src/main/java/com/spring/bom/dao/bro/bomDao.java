package com.spring.bom.dao.bro;

import javax.servlet.http.HttpSession;

import com.spring.bom.model.bro.User_info;

public interface bomDao {
	public User_info loginCheck(User_info ui) throws Exception;
	public void logout(HttpSession session);

}