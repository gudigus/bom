package com.spring.bom.dao.god;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bom.model.god.Board;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SqlSession session;

	@Override
	public String getReserveNum(int ucode) {
		// TODO Auto-generated method stub
		return session.selectOne("JHgetReserveNum",ucode);
	}

	@Override
	public List<Board> getReserveList(int ucode) {
		// TODO Auto-generated method stub
		return session.selectList("JHgetReserveList",ucode);
	}

	@Override
	public List<Board> getSaveList(int ucode) {
		// TODO Auto-generated method stub
		System.out.println("UserDaoImpl getSaveList");
		return session.selectList("JHgetSaveList",ucode);
	}
}
