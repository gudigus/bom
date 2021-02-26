package com.spring.bom.dao.coffee;

import java.util.List;

import com.spring.bom.model.coffee.ReportUser_infoBoard;

public interface ReportDao {
	List<ReportUser_infoBoard> accusationList();
	String getROPUnickname(int ropcode);
	String getROPUatid(int ropcode);
}
