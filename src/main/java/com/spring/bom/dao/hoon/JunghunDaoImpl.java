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
	public List<Junghun> listSearch(String search) {
		System.out.println("Dao Search :: "+search);
		return session.selectList("searchfame",search);
	}

	@Override
	public List<Junghun> listUser(String search) {
		return session.selectList("searchuser",search);
	}

	@Override
	public List<Junghun> listNew(String search) {
		return session.selectList("searchnew",search);
	}

}
