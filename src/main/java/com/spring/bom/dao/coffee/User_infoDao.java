package com.spring.bom.dao.coffee;

import java.util.List;

import com.spring.bom.model.coffee.User_info;

public interface User_infoDao {
	List<User_info> user_infoSensorList();
	List<User_info> user_infoRestoreList();
	List<User_info> user_infoAccusationList();
}
