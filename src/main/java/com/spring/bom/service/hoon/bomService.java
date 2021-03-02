package com.spring.bom.service.hoon;

import javax.servlet.http.HttpSession;

import com.spring.bom.model.hoon.user_info;

public interface bomService {
	public user_info loginCheck(user_info ui) throws Exception;
	public void logout(HttpSession session);

}
