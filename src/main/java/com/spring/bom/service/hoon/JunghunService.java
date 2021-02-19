package com.spring.bom.service.hoon;

import java.util.List;

import com.spring.bom.model.hoon.Junghun;

public interface JunghunService {
	List<Junghun> listSearch(Junghun junghun);
	List<Junghun> listUser(Junghun junghun);
	List<Junghun> listNew(Junghun junghun);
	
}
