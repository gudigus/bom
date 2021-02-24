package com.spring.bom.dao.yeah;

import java.util.List;

import com.spring.bom.model.yeah.UserBookmarkBoard;



public interface BookmarkDao {
    List<UserBookmarkBoard>     ubmBoardListDao(int ucode);
}
