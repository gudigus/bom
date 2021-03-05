package com.spring.bom.service.god;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bom.dao.god.UserDao;
import com.spring.bom.model.god.Board;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao ud;

	@Override
	public String getReserveNum(int ucode) {
		return ud.getReserveNum(ucode);
	}

	@Override
	public String getSaveNum(int ucode) {
		// TODO Auto-generated method stub
		return ud.getSaveNum(ucode);
	}
	
	@Override
	public List<Board> getReserveList(int ucode) {
		// TODO Auto-generated method stub
		return ud.getReserveList(ucode);
	}

	@Override
	public List<Board> getSaveList(int ucode) {
		// TODO Auto-generated method stub
		System.out.println("UserServiceImpl getSaveList()");
		return ud.getSaveList(ucode);
	}

}
