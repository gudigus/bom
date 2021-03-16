package com.spring.bom.service.god;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.spring.bom.model.god.Board;

@Service
public interface BoardService {

	int insertBoard(Board board);

	int insertVoteBoard(Board board);

	Board getBoard(int bcode);

	int deleteSaveWrite(int[] bcodes);

}
