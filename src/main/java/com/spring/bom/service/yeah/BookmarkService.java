package com.spring.bom.service.yeah;

import java.util.List;

import com.spring.bom.model.yeah.Board;
import com.spring.bom.model.yeah.Bookmark;
import com.spring.bom.model.yeah.UserBookmarkBoard;



public interface BookmarkService {
    List<UserBookmarkBoard> ubmBoardList(int int_ucode);

	int delete(Board bd);

	int deleteAll(String ucode);



	
    
	
}
