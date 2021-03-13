package com.spring.bom.service.god;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bom.dao.god.VoteDao;
import com.spring.bom.model.god.Vote;

@Service
public class VoteServiceImpl implements VoteService {
	@Autowired
	private VoteDao vd;
	@Override
	public String settingTime(Vote vote) {
		return vd.settingTime(vote);
	}
	@Override
	public int insertVote(Vote vote) {
		// TODO Auto-generated method stub
		return vd.insertVote(vote);
	}

}
