package com.spring.bom.dao.hoon;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bom.model.hoon.Junghun;
import com.spring.bom.model.iron.Follow;

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

	@Override
	public List<Junghun> listCount(Junghun junghun) {
		return session.selectList("searchcount",junghun);
	}

	@Override
	public int searchData(Junghun junghun) {
		return session.update("searchData",junghun);
	}

	@Override
	public List<Junghun> listHash(Junghun junghun) {
		return session.selectList("searchHash",junghun);
	}

	@Override
	public List<Junghun> listTrend() {
		return session.selectList("searchTrend");
	}

	@Override
	public List<Junghun> searchkeyword(Junghun junghun) {
		return session.selectList("searchkeyword",junghun);
	}

	@Override
	public int deleterow(int ucode) {
		System.out.println("del dao::1");
		System.out.println("ucode ::"+ucode);
		return session.delete("searchdelete",ucode);
	}

	@Override
	public List<Junghun> searchblock(Junghun junghun) {
		// TODO Auto-generated method stub
		return session.selectList("searchblock",junghun);
	}

	@Override
	public int searchlike(Junghun junghun) {
		return session.update("searchlike",junghun);
	}

	@Override
	public List<Junghun> searchlistall(Junghun junghun) {
		// TODO Auto-generated method stub
		return session.selectList("searchlistall",junghun);
	}
	
	@Override
	public List<Follow> getSuggestFollowList1(int ucode) {
		List<Follow> suggestFlist = session.selectList("followWhoSameTrend",ucode);
		return suggestFlist;
	}
	
	@Override
	public List<Follow> getSuggestFollowList2(int ucode) {
		List<Follow> suggestFlist = session.selectList("followWhoIknow",ucode);
		return suggestFlist;
	}

	@Override
	public List<Junghun> searchbattach(Junghun junghun) {
		// TODO Auto-generated method stub
		return session.selectList("searchbattach",junghun);
	}

	@Override
	public List<Junghun> searchbattachvideo(Junghun junghun) {
		// TODO Auto-generated method stub
		return session.selectList("searchbattachvideo",junghun);
	}


}

