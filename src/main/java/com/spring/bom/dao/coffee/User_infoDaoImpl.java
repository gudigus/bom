package com.spring.bom.dao.coffee;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bom.model.coffee.User_info;

@Repository
public class User_infoDaoImpl implements User_infoDao {
	@Autowired
	private  SqlSession  session;
	@Override
	public List<User_info> user_infoSensorList() {
		List<User_info> user_infoList = new ArrayList<User_info>();
		user_infoList = session.selectList("coffeeSensorSelectUser_info");
		return user_infoList;
	}
	@Override
	public List<User_info> user_infoRestoreList() {
		List<User_info> user_infoList = new ArrayList<User_info>();
		user_infoList = session.selectList("coffeeRestoreSelectUser_info");
		return user_infoList;
	}
	@Override
	public List<User_info> user_infoAccusationList() {
		List<User_info> user_infoList = new ArrayList<User_info>();
		user_infoList = session.selectList("coffeeAccusationSelectUser_info");
		return user_infoList;
	}

}
