package com.spring.bom.service.coffee;

import java.util.List;

import com.spring.bom.model.coffee.ReportUser_infoBoard;

public interface ReportService {
	List<ReportUser_infoBoard> accusationList();
	String getROPUnickname(int ropcode);
	String getROPUatid(int ropcode);
}
