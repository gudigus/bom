package com.spring.bom.dao.hoon;

import javax.servlet.http.HttpSession;

import com.spring.bom.model.hoon.user_info;

public interface bomDao {
	public user_info loginCheck(user_info ui) throws Exception;
	public void logout(HttpSession session);

}
