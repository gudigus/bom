package com.spring.bom.service.coffee;

import java.util.List;

import com.spring.bom.model.coffee.BoardUser_info;

public interface BoardService {
	List<BoardUser_info> sensorList();
	List<BoardUser_info> restoreList();
	List<BoardUser_info> accusationList();
	int updateBstate(int bcode, int updateValue);
	List<BoardUser_info> accusationList(String search);
	List<BoardUser_info> sensorList(String search);
	List<BoardUser_info> restoreList(String search);
}
