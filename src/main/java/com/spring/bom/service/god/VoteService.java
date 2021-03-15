package com.spring.bom.service.god;

import org.springframework.stereotype.Service;

import com.spring.bom.model.god.Vote;

@Service
public interface VoteService {

	String settingTime(Vote vote);

	int insertVote(Vote vote);

}
