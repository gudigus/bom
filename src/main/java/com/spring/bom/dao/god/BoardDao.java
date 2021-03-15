package com.spring.bom.dao.god;

import com.spring.bom.model.god.Board;

public interface BoardDao {

	int insertBoard(Board board);

	int insertVoteBoard(Board board);

	Board getBoard(int bcode);

}
