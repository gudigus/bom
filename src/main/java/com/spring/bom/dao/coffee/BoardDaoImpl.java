package com.spring.bom.dao.coffee;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bom.model.coffee.BoardUser_info;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private  SqlSession  session;
	
	@Override
	public List<BoardUser_info> sensorList() {
		List<BoardUser_info> list = new ArrayList<BoardUser_info>();
		list = session.selectList("coffeeSensorSelectBoardUser_info");
		return list;
	}

	@Override
	public List<BoardUser_info> restoreList() {
		List<BoardUser_info> list = new ArrayList<BoardUser_info>();
		list = session.selectList("coffeeRestoreSelectBoardUser_info");
		return list;
	}

	@Override
	public List<BoardUser_info> accusationList() {
		List<BoardUser_info> list = new ArrayList<BoardUser_info>();
		list = session.selectList("coffeeAccusationSelectBoardUser_info");
		return list;
	}

}
