package com.spring.bom.service.right;

import java.util.List;
import java.util.Map;

import com.spring.bom.model.right.Block;
import com.spring.bom.model.right.Interest;
import com.spring.bom.model.right.InterestDetail;
import com.spring.bom.model.right.Statis;
import com.spring.bom.model.right.User_Info;

public interface StatisService {
	//10대 통계 가져오기
	List<Statis> getSearchRank1();
	//20대 통계 가져오기
	List<Statis> getSearchRank2();
	//30대 통계 가져오기
	List<Statis> getSearchRank3();
	//남자 통계 가져오기
	List<Statis> getSearchRankm();
	//여자 통계 가져오기
	List<Statis> getSearchRankw();
	
}
