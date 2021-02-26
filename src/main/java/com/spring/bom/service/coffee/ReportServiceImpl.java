package com.spring.bom.service.coffee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bom.dao.coffee.ReportDao;
import com.spring.bom.model.coffee.ReportUser_infoBoard;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private ReportDao rd;
	@Override
	public List<ReportUser_infoBoard> accusationList() {
		List<ReportUser_infoBoard> list = rd.accusationList();
		return list;
	}
	@Override
	public String getROPUnickname(int ropcode) {
		String rOPUnickname = rd.getROPUnickname(ropcode);
		return null;
	}
	@Override
	public String getROPUatid(int ropcode) {
		String rOPUatid = rd.getROPUatid(ropcode);
		return null;
	}

}
