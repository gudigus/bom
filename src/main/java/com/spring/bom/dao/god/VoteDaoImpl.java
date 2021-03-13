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
		return session.selectOne("JHsetVoteTime",vote);
	}

	@Override
	public int insertVote(Vote vote) {
		//vote.setVcode(session.selectOne("JHselectMaxVcode", vote));
		int vcode=session.insert("JHinsertVote", vote);
		vote.setVcode(vcode);
		return vote.getVcode();
	}
}
