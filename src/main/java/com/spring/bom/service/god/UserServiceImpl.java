package com.spring.bom.service.god;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bom.dao.god.UserDao;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao ud;

	@Override
	public String getReserveNum(int ucode) {
		return ud.getReserveNum(ucode);
	}

	@Override
	public List<String> getReserveList(int ucode) {
		// TODO Auto-generated method stub
		return ud.getReserveList(ucode);
	}
}
