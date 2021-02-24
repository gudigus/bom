package com.spring.bom.service.hoon;

import java.util.List;

import com.spring.bom.model.hoon.Junghun;

public interface JunghunService {
	List<Junghun> listSearch(String search);
	List<Junghun> listUser(String search);
	List<Junghun> listNew(String search);
	List<Junghun> listCount(Junghun junghun);
	int		      searchData(Junghun junghun);
	List<Junghun> listHash(Junghun junghun);
	List<Junghun> listTrend(Junghun junghun);
}
