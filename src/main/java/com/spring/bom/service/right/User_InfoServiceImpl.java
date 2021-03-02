package com.spring.bom.service.right;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bom.dao.right.User_InfoDao;
import com.spring.bom.model.right.User_Info;

@Service
public class User_InfoServiceImpl implements User_InfoService {
	@Autowired
	private User_InfoDao ud;

	@Override
	public User_Info detail(int ucode) {
		System.out.println("User_InfoServiceImpl detail ...");
		return ud.detail(ucode);
	}

	@Override
	public int changeinsert(User_Info ui) {
		System.out.println("User_InfoServiceImpl changeinsert ...");
		return ud.changeinsert(ui);
	}

	@Override
	public int changeupdate(User_Info ui) {
		System.out.println("User_InfoServiceImpl changeupdate ...");
		return ud.changeupdate(ui);
	}
	
	@Override
	public int edit(User_Info ui) {
		System.out.println("User_InfoServiceImpl edit ...");
		return ud.edit(ui);
	}

	@Override
	public int userIdCheck(String uatid) {
		System.out.println("User_InfoServiceImpl userIdCheck ...");
		return ud.userIdCheck(uatid);
	}

	@Override
	public int statedDis(User_Info ui) {
		System.out.println("User_InfoServiceImpl statedDis ...");
		return ud.statedDis(ui);
	}

	@Override
	public int changeInfoState(User_Info ui) {
		System.out.println("User_InfoServiceImpl changeInfoState ...");
		return ud.changeInfoState(ui);
	}

	@Override
	public int boardBpermission(User_Info ui) {
		System.out.println("User_InfoServiceImpl boardBpermission ...");
		return ud.boardBpermission(ui);
	}

	@Override
	public int changeinsertstate(User_Info ui) {
		System.out.println("User_InfoServiceImpl changeinsertstate ...");
		return ud.changeinsertstate(ui);
	}

	@Override
	public User_Info select(String uemail) {
		System.out.println("User_InfoServiceImpl select ...");
		return ud.select(uemail);
	}

	
	
}
