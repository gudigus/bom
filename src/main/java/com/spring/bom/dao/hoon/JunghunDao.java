package com.spring.bom.dao.hoon;

import java.util.List;

import com.spring.bom.model.hoon.Junghun;

public interface JunghunDao {
	List<Junghun> listSearch(String search);
	List<Junghun> listUser(String search);
	List<Junghun> listNew(String search);
		
}
