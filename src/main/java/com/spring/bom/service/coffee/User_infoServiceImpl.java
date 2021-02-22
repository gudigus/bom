package com.spring.bom.service.coffee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bom.dao.coffee.User_infoDao;
import com.spring.bom.model.coffee.User_info;

@Service
public class User_infoServiceImpl implements User_infoService {
	@Autowired
	private User_infoDao uid;
	@Override
	public List<User_info> user_infoSensorList() {
		List<User_info> user_infoList = null;
		user_infoList = uid.user_infoSensorList();
		return user_infoList;
	}
	@Override
	public List<User_info> user_infoRestoreList() {
		List<User_info> user_infoList = null;
		user_infoList = uid.user_infoRestoreList();
		return user_infoList;
	}
	@Override
	public List<User_info> user_infoAccusationList() {
		List<User_info> user_infoList = null;
		user_infoList = uid.user_infoAccusationList();
		return user_infoList;
	}

}
