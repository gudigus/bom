package com.spring.bom.dao.god;

import java.util.ArrayList;

import com.spring.bom.model.god.Board;

public interface BoardDao {

	int insertBoard(Board board);

	int insertVoteBoard(Board board);

	Board getBoard(int bcode);

	int deleteSaveWrite(int[] bcodes);

}
