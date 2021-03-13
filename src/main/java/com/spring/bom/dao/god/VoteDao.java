package com.spring.bom.dao.god;

import com.spring.bom.model.god.Vote;

public interface VoteDao {

	String settingTime(Vote vote);

	int insertVote(Vote vote);

}
