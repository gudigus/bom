package com.spring.bom.dao.coffee;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bom.model.coffee.ReportUser_infoBoard;
import com.spring.bom.model.coffee.User_info;

@Repository
public class ReportDaoImpl implements ReportDao {
	@Autowired
	private  SqlSession  session;

	@Override
	public List<ReportUser_infoBoard> accusationList() {
		List<ReportUser_infoBoard> list = null;
		System.out.println("ReportDaoImpl accusationList start..");

		try {
			list = session.selectList("accusationSelectReportUser_infoBoard");
		}catch (Exception e) {
			System.out.println("ReportDaoImpl accusationList ->"+e.getMessage());
		}
		
		
		return list;
	}

	@Override
	public List<ReportUser_infoBoard> uncensoredList() {
		List<ReportUser_infoBoard> list = null;
		System.out.println("ReportDaoImpl uncensoredList start..");

		try {
			list = session.selectList("accusationSelectUncensoredReportUser_infoBoard");
		}catch (Exception e) {
			System.out.println("ReportDaoImpl uncensoredList ->"+e.getMessage());
		}
		return list;
	}

	
}
