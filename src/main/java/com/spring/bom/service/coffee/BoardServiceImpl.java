package com.spring.bom.service.coffee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bom.dao.coffee.BoardDao;
import com.spring.bom.model.coffee.BoardUser_info;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao bd;
	@Override
	public List<BoardUser_info> sensorList() {
		List<BoardUser_info> list = null;
		list = bd.sensorList();
		return list;
	}

	@Override
	public List<BoardUser_info> restoreList() {
		List<BoardUser_info> list = null;
		list = bd.restoreList();
		return list;
	}

	@Override
	public List<BoardUser_info> accusationList() {
		List<BoardUser_info> list = null;
		list = bd.accusationList();
		return list;
	}

	@Override
	public int updateBstate(int bcode, int updateValue) {
		int result = bd.updateBstate(bcode, updateValue);
		return result;
	}

}
