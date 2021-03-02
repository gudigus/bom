package com.spring.bom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.bom.model.coffee.BoardUser_info;
import com.spring.bom.model.coffee.ReportUser_infoBoard;
import com.spring.bom.model.coffee.User_info;
import com.spring.bom.service.coffee.BoardService;
import com.spring.bom.service.coffee.ReportService;
import com.spring.bom.service.coffee.User_infoService;



@Controller
public class CoffeeController {
	@Autowired
	private User_infoService uis;
	
	@Autowired
	private BoardService bs;
	
	@Autowired
	private ReportService rs;
	
	
//	@GetMapping(value = "/coffee/example")
//	public String example() {
//		System.out.println("CoffeeController example start..");
//		return "coffee/example";
//	}
	
	
	// 회원 매니저
	@GetMapping(value = "/coffee/censorMemberManagerPage")
	public String censorMemberManagerPage(Model model) {
		System.out.println("CoffeeController censorMemberManagerPage start..");
		List<User_info> list = uis.user_infoSensorList();
		model.addAttribute("user_infoList", list);
		return "coffee/censorMemberManagerPage";
	}

	@GetMapping(value = "/coffee/restoreMemberManagerPage")
	public String restoreMemberManagerPage(Model model) {
		System.out.println("CoffeeController restoreMemberManagerPage start..");
		List<User_info> list = uis.user_infoRestoreList();
		model.addAttribute("user_infoList", list);
		return "coffee/restoreMemberManagerPage";
	}
	@GetMapping(value = "/coffee/accusationMemberManagerPage")
	public String accusationMemberManagerPage(Model model) {
		System.out.println("CoffeeController accusationMemberManagerPage start..");
		List<User_info> list = uis.user_infoAccusationList();
		model.addAttribute("user_infoList", list);
		return "coffee/accusationMemberManagerPage";
	}
	
	// 봄 매니저
	@GetMapping(value = "/coffee/censorBomManagerPage")
	public String censorBomManagerPage(Model model) {
		System.out.println("CoffeeController censorBomManagerPage start..");
		List<BoardUser_info> list = bs.sensorList();
		model.addAttribute("boardUser_infoList", list);
		return "coffee/censorBomManagerPage";
	}

	@GetMapping(value = "/coffee/restoreBomManagerPage")
	public String restoreBomManagerPage(Model model) {
		System.out.println("CoffeeController restoreBomManagerPage start..");
		List<BoardUser_info> list = bs.restoreList();
		model.addAttribute("boardUser_infoList", list);
		return "coffee/restoreBomManagerPage";
	}
	@GetMapping(value = "/coffee/accusationBomManagerPage")
	public String accusationBomManagerPage(Model model) {
		System.out.println("CoffeeController accusationBomManagerPage start..");
		List<BoardUser_info> list = bs.accusationList();
//		System.out.println(list.get(0).getBcode());
		model.addAttribute("boardUser_infoList", list);
		return "coffee/accusationBomManagerPage";
	}
	
	//신고 매니저
	@GetMapping(value = "/coffee/censorAccusationManagerPage")
	public String censorAccusationManagerPage(Model model) {
		System.out.println("CoffeeController censorAccusationManagerPage start..");
		List<ReportUser_infoBoard> list = rs.accusationList();
//		System.out.println("list.get(0).getUnickname_1()->"+list.get(0).getUnickname_1());
//		System.out.println("list.get(0).getUnickname()->"+list.get(0).getUnickname());
		
		
		model.addAttribute("ReportUser_infoBoardList", list);
		return "coffee/censorAccusationManagerPage";
	}
	@GetMapping(value = "/coffee/uncensoredAccusationManagerPage")
	public String uncensoredAccusationManagerPage(Model model) {
		System.out.println("CoffeeController uncensoredAccusationManagerPage start..");
		List<ReportUser_infoBoard> list = rs.uncensoredList();
//		System.out.println("list.get(0).getUnickname_1()->"+list.get(0).getUnickname_1());
//		System.out.println("list.get(0).getUnickname()->"+list.get(0).getUnickname());
		
		
		model.addAttribute("ReportUser_infoBoardList", list);
		return "coffee/uncensoredAccusationManagerPage";
	}
}
