package com.spring.bom.service.god;

import org.springframework.stereotype.Service;

import com.spring.bom.model.god.Board;

@Service
public interface BoardService {

	int insertBoard(Board board);

	int insertVoteBoard(Board board);

	Board getBoard(int bcode);

}
