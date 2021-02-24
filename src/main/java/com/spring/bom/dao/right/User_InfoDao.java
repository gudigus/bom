package com.spring.bom.dao.right;

import com.spring.bom.model.right.User_Info;

public interface User_InfoDao {
	//회원 정보 수정
	User_Info		detail(int ucode);
	int				edit(User_Info ui);
	int				changeinsert(User_Info ui);
	int				changeupdate(User_Info ui);
	int 			userIdCheck(String uatid);
}
