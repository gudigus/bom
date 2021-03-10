package com.spring.bom.service.hoon;

import java.util.List;

import com.spring.bom.model.hoon.Junghun;
import com.spring.bom.model.hoon.user_info;

public interface JunghunService {
	List<Junghun> listSearch(Junghun junghun);
	List<Junghun> listUser(String search);
	List<Junghun> listNew(String search);
	List<Junghun> listCount(Junghun junghun);
	int		      searchData(Junghun junghun);
	List<Junghun> listHash(Junghun junghun);
	List<Junghun> listTrend(Junghun junghun);
	List<Junghun> searchkeyword(Junghun junghun);
	int			  deleterow(int ucode);
}
