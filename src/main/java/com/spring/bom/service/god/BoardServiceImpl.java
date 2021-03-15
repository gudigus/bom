package com.spring.bom.service.god;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bom.dao.god.BoardDao;
import com.spring.bom.model.god.Board;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao bd;
	
	@Override
	public int insertBoard(Board board) {
		// TODO Auto-generated method stub
		System.out.println("service -> board.getsavebcode() -> "+board.getSavebcode());
		return bd.insertBoard(board);
	}

	@Override
	public int insertVoteBoard(Board board) {
		// TODO Auto-generated method stub
		return bd.insertVoteBoard(board);
	}

	@Override
	public Board getBoard(int bcode) {
		// TODO Auto-generated method stub
		return bd.getBoard(bcode);
	}

}
