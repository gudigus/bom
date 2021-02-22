package com.spring.bom.service.hoon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bom.dao.hoon.JunghunDao;
import com.spring.bom.model.hoon.Junghun;

@Service
public class JunghunServiceImpl implements JunghunService {
	@Autowired
	private JunghunDao jd;
	
	@Override
	public List<Junghun> listSearch(String search) {
		System.out.println("Service Search :: "+search);
		return jd.listSearch(search);
	}

	@Override
	public List<Junghun> listUser(String search) {
		return jd.listUser(search);
	}

	@Override
	public List<Junghun> listNew(String search) {
		return jd.listNew(search);
	}

}
