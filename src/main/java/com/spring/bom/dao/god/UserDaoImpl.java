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
		String reserveNum=null;
		try {
			reserveNum=session.selectOne("JHgetReserveNum",ucode);
		} catch (Exception e) {
			System.out.println("GOD UserDaoImpl getReserveNum-> "+e.getMessage());
		}
		return reserveNum;
	}

	@Override
	public String getSaveNum(int ucode) {
		String saveNum=null;
		try {
			saveNum=session.selectOne("JHgetSaveNum",ucode);
		} catch (Exception e) {
			System.out.println("GOD UserDaoImpl getSaveNum -> "+e.getMessage());
		}
		return saveNum;
	}
	
	@Override
	public List<Board> getReserveList(int ucode) {
		List<Board> list = null;
		try {
			list=session.selectList("JHgetReserveList",ucode);
		} catch (Exception e) {
			System.out.println("GOD UserDaoImpl getReserveList ->"+e.getMessage());
		}
		return list;
	}

	@Override
	public List<Board> getSaveList(int ucode) {
		List<Board> list = null;
		try {
			list=session.selectList("JHgetSaveList",ucode);
		} catch (Exception e) {
			System.out.println("GOD UserDaoImpl getSaveList -> "+e.getMessage());
		}
		return list;
	}

}
