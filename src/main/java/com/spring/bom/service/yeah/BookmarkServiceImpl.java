package com.spring.bom.service.yeah;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bom.dao.yeah.BookmarkDao;
import com.spring.bom.model.yeah.Bookmark;
import com.spring.bom.model.yeah.UserBookmarkBoard;


@Service
public class BookmarkServiceImpl implements BookmarkService {
   @Autowired
   private BookmarkDao bmd;
	
	
	@Override
	public List<UserBookmarkBoard> ubmBoardList(int ucode) {
	  List<UserBookmarkBoard> ubmBoardListSrv = null;
	  ubmBoardListSrv = bmd.ubmBoardListDao(ucode);

		return ubmBoardListSrv;
	}





	@Override
	public int update(Bookmark bm) {
		// TODO Auto-generated method stub
		return bmd.update(bm);
	}



	@Override
	public int updateAll(String ucode) {
		// TODO Auto-generated method stub
		return bmd.updateAll(ucode);
	}






}
