package com.spring.bom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
//		System.out.println("list.get(0).getUcode()->"+list.get(0).getUcode());
//		System.out.println("list.get(0).getUnickname()->"+list.get(0).getUnickname());
//		System.out.println("list.get(1).getUcode()->"+list.get(1).getUcode());
//		System.out.println("list.get(1).getUnickname()->"+list.get(1).getUnickname());
//		System.out.println("list.get(2).getUcode()->"+list.get(2).getUcode());
//		System.out.println("list.get(2).getUnickname()->"+list.get(2).getUnickname());
		model.addAttribute("user_infoList", list);
		return "coffee/censorMemberManagerPage";
	}
	
		// Ajax  List Test String
	@GetMapping(value = "/coffee/coffeeUpdateUstate", produces = "application/text;charset=UTF-8")
	@ResponseBody
	public String coffeeUpdateUstate(int ucode, int updateValue) {
		System.out.println("Ajax  coffeeUpdateUstate  Start");
		System.out.println("Ajax  coffeeUpdateUstate updateValue->"+updateValue);
		System.out.println("Ajax  coffeeUpdateUstate ucode->"+ucode);
		
		// Business Logic 구현
		String result = "";
		result += uis.updateUstate(ucode, updateValue);
		return result;
		
	}

		// Ajax  List Test JSON
	@GetMapping(value = "/coffee/coffeeUpdateUstate3")
	@ResponseBody
	public User_info coffeeUpdateUstate3(int ucode, int updateValue) {
		System.out.println("Ajax  coffeeUpdateUstate  Start");
		System.out.println("Ajax  coffeeUpdateUstate updateValue->"+updateValue);
		System.out.println("Ajax  coffeeUpdateUstate ucode->"+ucode);
		
		// Business Logic 구현
		User_info ui = null;
		// Return 받는 값이 객체라는 전제하에 
		// result = uis.updateUstate(ucode, updateValue);
		
		
		return ui;
		
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

		// Ajax  List Test String
	@GetMapping(value = "/coffee/coffeeUpdateBstate", produces = "application/text;charset=UTF-8")
	@ResponseBody
	public String coffeeUpdateBstate(int bcode, int updateValue) {
		System.out.println("Ajax  coffeeUpdateBstate  Start");
		System.out.println("Ajax  coffeeUpdateBstate updateValue->"+updateValue);
		System.out.println("Ajax  coffeeUpdateBstate bcode->"+bcode);
		
		// Business Logic 구현
		String result = "";
		result += bs.updateBstate(bcode, updateValue);
		return result;
		
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
	
	// Ajax  List Test String
	@GetMapping(value = "/coffee/coffeeUpdateRaction", produces = "application/text;charset=UTF-8")
	@ResponseBody
	public String coffeeUpdateRaction(int rcode, int updateValue) {
		System.out.println("Ajax  coffeeUpdateRaction  Start");
		System.out.println("Ajax  coffeeUpdateRaction updateValue->"+updateValue);
		System.out.println("Ajax  coffeeUpdateRaction rcode->"+rcode);
		
		// Business Logic 구현
		String result = "";
		result += rs.updateRaction(rcode, updateValue);
		return result;
		
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
