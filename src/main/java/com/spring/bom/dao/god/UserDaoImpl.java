package com.spring.bom.dao.god;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public List<String> getReserveList(int ucode) {
		// TODO Auto-generated method stub
		return session.selectList("JHgetReserveList",ucode);
	}
}
