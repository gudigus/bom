package com.spring.bom.dao.coffee;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bom.model.coffee.ReportUser_infoBoard;

@Repository
public class ReportDaoImpl implements ReportDao {
	@Autowired
	private  SqlSession  session;

	@Override
	public List<ReportUser_infoBoard> accusationList() {
		List<ReportUser_infoBoard> list = null;
		list = session.selectList("accusationSelectReportUser_infoBoard");
		
		return list;
	}

	@Override
	public String getROPUnickname(int ropcode) {
		String result = session.selectOne("getROPUnickname", ropcode);
		return result;
	}

	@Override
	public String getROPUatid(int ropcode) {
		String result = session.selectOne("getROPUatid", ropcode);
		return result;
	}

}
