package com.spring.bom.dao.yeah;

import java.util.List;

import com.spring.bom.model.yeah.Board;
import com.spring.bom.model.yeah.UserBookmarkBoard;



public interface BookmarkDao {
    List<UserBookmarkBoard>     ubmBoardListDao(int bcode);

	int delete(Board board);
	
	int deleteAll(String ucode);




}
