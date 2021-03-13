package com.spring.bom.service.god;

import com.spring.bom.model.god.Vote;

public interface VoteService {

	String settingTime(Vote vote);

	int insertVote(Vote vote);

}
