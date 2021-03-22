package com.spring.bom.dao.yeah;

import java.util.List;


import com.spring.bom.model.yeah.Board;
import com.spring.bom.model.yeah.Bookmark;
import com.spring.bom.model.yeah.UserBookmarkBoard;

public interface BookmarkDao {
	List<UserBookmarkBoard> ubmBoardListDao(int ucode);
	int update(Bookmark bm);
	int updateAll(String ucode);


	
}
