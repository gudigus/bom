package com.spring.bom.dao.coffee;

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
		List<User_info> list = null;
		list = session.selectList("coffeeSensorSelectUser_info");
		for(int i=0; i<list.size();i++) {
			list.get(i).setUfollowing(session.selectOne("coffeeSensorFollowing", list.get(i).getUcode()));
			list.get(i).setUfollower(session.selectOne("coffeeSensorFollower", list.get(i).getUcode()));
			
		}
		return list;
	}
	@Override
	public List<User_info> user_infoRestoreList() {
		List<User_info> list = null;
		list = session.selectList("coffeeRestoreSelectUser_info");
		for(int i=0; i<list.size();i++) {
			list.get(i).setUfollowing(session.selectOne("coffeeSensorFollowing", list.get(i).getUcode()));
			list.get(i).setUfollower(session.selectOne("coffeeSensorFollower", list.get(i).getUcode()));
			
		}
		return list;
	}
	@Override
	public List<User_info> user_infoAccusationList() {
		List<User_info> list = null;
		list = session.selectList("coffeeAccusationSelectUser_info");
		for(int i=0; i<list.size();i++) {
			list.get(i).setUfollowing(session.selectOne("coffeeSensorFollowing", list.get(i).getUcode()));
			list.get(i).setUfollower(session.selectOne("coffeeSensorFollower", list.get(i).getUcode()));
			
		}
		return list;
	}
	@Override
	public int updateUstate(int ucode, int updateValue) {
		int result = 0;
		User_info ui = new User_info();
		ui.setUcode(ucode);
		ui.setUstate(updateValue);
//		System.out.println(ucode);
//		System.out.println(updateValue);
		try{
			result = session.update("coffeeUpdateUstate", ui);
		}catch (Exception e) {
			System.out.println("User_infoDaoImpl updateUstate"+e.getMessage());
		}
		return result;
	}
	@Override
	public int memConfirmManager(int getuCode) {
		int result = 0;
		try {
			result = session.selectOne("coffeeSelectManager", getuCode);
		}catch (Exception e) {
			System.out.println("User_infoDaoImpl memConfirmManager"+e.getMessage());
		}
		return result;
	}

}
