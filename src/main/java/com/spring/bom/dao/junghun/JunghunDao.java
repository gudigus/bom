package com.spring.bom.dao.junghun;

import java.util.List;

import com.spring.bom.model.hoon.Junghun;

public interface JunghunDao {
	List<Junghun> listSearch(Junghun junghun);
}
