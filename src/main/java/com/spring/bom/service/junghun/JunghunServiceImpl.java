package com.spring.bom.service.junghun;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bom.dao.junghun.JunghunDao;
import com.spring.bom.model.hoon.Junghun;

@Service
public class JunghunServiceImpl implements JunghunService {
	@Autowired
	private JunghunDao jd;
	
	@Override
	public List<Junghun> listSearch(Junghun junghun) {
		return jd.listSearch(junghun);
	}

}
