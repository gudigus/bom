package com.spring.bom.dao.bro;

import javax.servlet.http.HttpSession;

import com.spring.bom.model.bro.User_info;

public interface BomDao {
	public User_info loginCheck(User_info ui) throws Exception;
	public void logout(HttpSession session);
	public int join(User_info ui);
	public int checkEmail(String uEmail);

}
