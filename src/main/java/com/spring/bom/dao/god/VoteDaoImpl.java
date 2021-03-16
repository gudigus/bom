package com.spring.bom.dao.god;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bom.model.god.Vote;

@Repository
public class VoteDaoImpl implements VoteDao {
	@Autowired
	private SqlSession session;

	@Override
	public String settingTime(Vote vote) {
		String votetime=null;
		try {
			votetime=session.selectOne("JHsetVoteTime",vote);
		} catch (Exception e) {
			System.out.println("GOD VoteDaoImpl settingTime -> "+e.getMessage());
		}
		return votetime;
	}

	@Override
	public int insertVote(Vote vote) {
		try {
			session.insert("JHinsertVote", vote);
		} catch (Exception e) {
			System.out.println("GOD VoteDaoImpl insertVote -> "+e.getMessage());
		}
		return vote.getVcode();
	}
}
