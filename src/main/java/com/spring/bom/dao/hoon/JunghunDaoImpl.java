package com.spring.bom.dao.hoon;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bom.model.hoon.Junghun;

@Repository
public class JunghunDaoImpl implements JunghunDao{
	@Autowired
	private SqlSession session;

	@Override
	public List<Junghun> listSearch(Junghun junghun) {
		return session.selectList("searchfame",junghun);
	}

	@Override
	public List<Junghun> listUser(Junghun junghun) {
		return session.selectList("searchuser",junghun);
	}

	@Override
	public List<Junghun> listNew(Junghun junghun) {
		return session.selectList("searchnew",junghun);
	}

}
