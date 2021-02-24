package com.spring.bom.dao.yeah;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bom.model.yeah.UserBookmarkBoard;



@Repository
public class BookmarkDaoImpl implements BookmarkDao{

	@Autowired
	private SqlSession session;    

	@Override
	public List<UserBookmarkBoard> ubmBoardListDao(int ucode) {
		List<UserBookmarkBoard>  ubmBoardListDao = null;
		try {
			ubmBoardListDao = session.selectList("ubmBoardListMapper" ,ucode );
			System.out.println("BookmarkDaoImpl ubmBoardListDao ubmBoardListDao.size()->" +ubmBoardListDao.size());
			
		} catch (Exception e) {
			System.out.println("BookmarkDaoImpl ubmBoardListDao e.getMessage()->" +e.getMessage());
			
		}	
		
		return ubmBoardListDao;
	}

}
