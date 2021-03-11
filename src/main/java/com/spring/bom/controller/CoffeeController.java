package com.spring.bom.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.bom.model.bro.user_info;
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
	
	
	@GetMapping(value = "/coffee/example")
	public String example() {
		System.out.println("CoffeeController example start..");
		return "coffee/example";
	}
	
	
	// Interceptors
	// 회원 매니저
	// interCepter 진행 Test  --> 2번째 수행 
	@GetMapping(value = "/coffee/interceptor/censorMemberManagerPage")
	public String censorMemberManagerPageI(HttpServletRequest req, Model model) {
		String url = "/coffee/censorMemberManagerPage";
		System.out.println("CoffeeController "+url+" interceptor  start..");
		// 관리자 검증
		managerVerification(req, model, url);
		return url;
	}
	
	public void managerVerification(HttpServletRequest req, Model model, String url) {
		HttpSession session = req.getSession();
		int uCode = -1;
		
		try {
			uCode = (int) session.getAttribute("uCode");

		}catch (Exception e) {
			System.out.println("CoffeeController "+url+" Interceptor ->"+e.getMessage());
		}
		System.out.println("CoffeeController session uCode->"+uCode);
		int memCnt = uis.memConfirmManager(uCode);
		// model.addAttribute("id",id);
		model.addAttribute("memCnt",memCnt);
		model.addAttribute("url", url);
		System.out.println("CoffeeController session memCnt->"+memCnt);
	}
	
	
	// Interceptors
	 // interCepter 진행 Test
	@GetMapping(value = "/coffee/censorMemberManagerPage")
	public String censorMemberManagerPage(HttpServletRequest req, Model model) {
		System.out.println("CoffeeController censorMemberManagerPage start..");
		// 관리자 검증
		HttpSession session = req.getSession();
		String manager = (String) session.getAttribute("manager");
		String returnPage = "";
		if (manager == null) manager = "9";
		System.out.println("/coffee/censorMemberManagerPage manager->"+ manager );
		// 관리자면 
		if (manager == "0") {
			List<User_info> list = uis.user_infoSensorList();
//			System.out.println("list.get(0).getUcode()->"+list.get(0).getUcode());
//			System.out.println("list.get(0).getUnickname()->"+list.get(0).getUnickname());
//			System.out.println("list.get(1).getUcode()->"+list.get(1).getUcode());
//			System.out.println("list.get(1).getUnickname()->"+list.get(1).getUnickname());
//			System.out.println("list.get(2).getUcode()->"+list.get(2).getUcode());
//			System.out.println("list.get(2).getUnickname()->"+list.get(2).getUnickname());
			model.addAttribute("user_infoList", list);
			returnPage = "/coffee/censorMemberManagerPage";
		} else {
			// returnPage = "/coffee/kkk";
			returnPage = "redirect:/bro/index";
			
		}

		return returnPage;
	}
	
//	// Interceptors
//	 // interCepter 진행 Test
//	@GetMapping(value = "/coffee/kkk")
//	public String censorMemberKKKPage(HttpServletRequest req, Model model) {
//		System.out.println("CoffeeController censorMemberKKKPage start..");
//		String returnPage = "coffee/kkk";
//	
//		return returnPage;
//	}

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

//		// Ajax  List Test JSON
//	@GetMapping(value = "/coffee/coffeeUpdateUstate3")
//	@ResponseBody
//	public User_info coffeeUpdateUstate3(int ucode, int updateValue) {
//		System.out.println("Ajax  coffeeUpdateUstate  Start");
//		System.out.println("Ajax  coffeeUpdateUstate updateValue->"+updateValue);
//		System.out.println("Ajax  coffeeUpdateUstate ucode->"+ucode);
//		
//		// Business Logic 구현
//		User_info ui = null;
//		// Return 받는 값이 객체라는 전제하에 
//		// result = uis.updateUstate(ucode, updateValue);
//		
//		
//		return ui;
//		
//	}
	
	// Interceptors
	// interCepter 진행 Test  --> 2번째 수행 
	@GetMapping(value = "/coffee/interceptor/restoreMemberManagerPage")
	public String restoreMemberManagerPageI(HttpServletRequest req, Model model) {
		String url = "/coffee/restoreMemberManagerPage";
		System.out.println("CoffeeController "+url+" interceptor  start..");
		// 관리자 검증
		managerVerification(req, model, url);
		return url;
	}
	
	@GetMapping(value = "/coffee/restoreMemberManagerPage")
	public String restoreMemberManagerPage(HttpServletRequest req, Model model) {
		System.out.println("CoffeeController restoreMemberManagerPage start..");
		// 관리자 검증
		HttpSession session = req.getSession();
		String manager = (String) session.getAttribute("manager");
		String returnPage = "";
		if (manager == null) manager = "9";
		System.out.println("/coffee/restoreMemberManagerPage manager->"+ manager );
		if(manager == "0") {
			List<User_info> list = uis.user_infoRestoreList();
			model.addAttribute("user_infoList", list);
			returnPage = "/coffee/restoreMemberManagerPage";
		}else {
			returnPage = "redirect:/bro/index";
		}
		return returnPage;
	}
	
	// Interceptors
	// interCepter 진행 Test  --> 2번째 수행 
	@GetMapping(value = "/coffee/interceptor/accusationMemberManagerPage")
	public String accusationMemberManagerPageI(HttpServletRequest req, Model model) {
		String url = "/coffee/accusationMemberManagerPage";
		System.out.println("CoffeeController "+url+" interceptor  start..");
		// 관리자 검증
		managerVerification(req, model, url);
		return url;
	}
	@GetMapping(value = "/coffee/accusationMemberManagerPage")
	public String accusationMemberManagerPage(HttpServletRequest req, Model model) {
		System.out.println("CoffeeController accusationMemberManagerPage start..");
		// 관리자 검증
		HttpSession session = req.getSession();
		String manager = (String) session.getAttribute("manager");
		String returnPage = "";
		if (manager == null) manager = "9";
		System.out.println("/coffee/accusationMemberManagerPage manager->"+ manager );
		if(manager == "0") {
			List<User_info> list = uis.user_infoAccusationList();
			model.addAttribute("user_infoList", list);
			returnPage = "/coffee/accusationMemberManagerPage";
		}else {
			returnPage = "redirect:/bro/index";
		}
		return returnPage;
	}
	
	// 봄 매니저
	
	// Interceptors
	// interCepter 진행 Test  --> 2번째 수행 
	@GetMapping(value = "/coffee/interceptor/censorBomManagerPage")
	public String censorBomManagerPageI(HttpServletRequest req, Model model) {
		String url = "/coffee/censorBomManagerPage";
		System.out.println("CoffeeController "+url+" interceptor  start..");
		// 관리자 검증
		managerVerification(req, model, url);
		return url;
	}
	@GetMapping(value = "/coffee/censorBomManagerPage")
	public String censorBomManagerPage(HttpServletRequest req, Model model) {
		String returnPage = "/coffee/censorBomManagerPage";
		System.out.println("CoffeeController" +returnPage+ "start..");
		// 관리자 검증
		HttpSession session = req.getSession();
		String manager = (String) session.getAttribute("manager");
		if (manager == null) manager = "9";
		System.out.println(returnPage+" manager->"+ manager );
		if(manager == "0") {
			List<BoardUser_info> list = bs.sensorList();
			for (int i=0; i<list.size(); i++) {
				if(list.get(i).getBattach()!= null) {
					list.get(i).setBattachType(list.get(i).getBattach().substring(0, 5));
					list.get(i).setBattachSrc(list.get(i).getBattach().substring(6));
				}
			}
//			System.out.println("CoffeeController" +returnPage+ list.get(1).getBattach());
//			System.out.println("CoffeeController" +returnPage+ list.get(1).getBattachSrc());
			model.addAttribute("boardUser_infoList", list);
		}else {
			returnPage = "redirect:/bro/index";
		}
		return returnPage;
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
	
	// Interceptors
	// interCepter 진행 Test  --> 2번째 수행 
	@GetMapping(value = "/coffee/interceptor/restoreBomManagerPage")
	public String restoreBomManagerPageI(HttpServletRequest req, Model model) {
		String url = "/coffee/restoreBomManagerPage";
		System.out.println("CoffeeController "+url+" interceptor  start..");
		// 관리자 검증
		managerVerification(req, model, url);
		return url;
	}
	@GetMapping(value = "/coffee/restoreBomManagerPage")
	public String restoreBomManagerPage(HttpServletRequest req, Model model) {
		String returnPage = "/coffee/restoreBomManagerPage";
		System.out.println("CoffeeController" +returnPage+ "start..");
		// 관리자 검증
		HttpSession session = req.getSession();
		String manager = (String) session.getAttribute("manager");
		if (manager == null) manager = "9";
		System.out.println(returnPage+" manager->"+ manager );
		if(manager == "0") {
			List<BoardUser_info> list = bs.restoreList();
			for (int i=0; i<list.size(); i++) {
				if(list.get(i).getBattach()!= null) {
					list.get(i).setBattachType(list.get(i).getBattach().substring(0, 5));
					list.get(i).setBattachSrc(list.get(i).getBattach().substring(6));
				}
			}
			model.addAttribute("boardUser_infoList", list);
		}else {
			returnPage = "redirect:/bro/index";
		}
		return returnPage;
	}
	
	
	// Interceptors
	// interCepter 진행 Test  --> 2번째 수행 
	@GetMapping(value = "/coffee/interceptor/accusationBomManagerPage")
	public String accusationBomManagerPageI(HttpServletRequest req, Model model) {
		String url = "/coffee/accusationBomManagerPage";
		System.out.println("CoffeeController "+url+" interceptor  start..");
		// 관리자 검증
		managerVerification(req, model, url);
		return url;
	}
	@GetMapping(value = "/coffee/accusationBomManagerPage")
	public String accusationBomManagerPage(HttpServletRequest req, Model model) {
		String returnPage = "/coffee/accusationBomManagerPage";
		System.out.println("CoffeeController" +returnPage+ "start..");
		// 관리자 검증
		HttpSession session = req.getSession();
		String manager = (String) session.getAttribute("manager");
		if (manager == null) manager = "9";
		System.out.println(returnPage+" manager->"+ manager );
		if(manager == "0") {
			List<BoardUser_info> list = bs.accusationList();
			for (int i=0; i<list.size(); i++) {
				if(list.get(i).getBattach()!= null) {
					list.get(i).setBattachType(list.get(i).getBattach().substring(0, 5));
					list.get(i).setBattachSrc(list.get(i).getBattach().substring(6));
				}
			}
//			System.out.println(list.get(0).getBcode());
			model.addAttribute("boardUser_infoList", list);
		}else {
			returnPage = "redirect:/bro/index";
		}
		return returnPage;
	}
	
	//신고 매니저
	
	// Interceptors
	// interCepter 진행 Test  --> 2번째 수행 
	@GetMapping(value = "/coffee/interceptor/censorAccusationManagerPage")
	public String censorAccusationManagerPageI(HttpServletRequest req, Model model) {
		String url = "/coffee/censorAccusationManagerPage";
		System.out.println("CoffeeController "+url+" interceptor  start..");
		// 관리자 검증
		managerVerification(req, model, url);
		return url;
	}
	
	
	@GetMapping(value = "/coffee/censorAccusationManagerPage")
	public String censorAccusationManagerPage(HttpServletRequest req, Model model) {
		String returnPage = "/coffee/censorAccusationManagerPage";
		System.out.println("CoffeeController" +returnPage+ "start..");
		// 관리자 검증
		HttpSession session = req.getSession();
		String manager = (String) session.getAttribute("manager");
		if (manager == null) manager = "9";
		System.out.println(returnPage+" manager->"+ manager );
		if(manager == "0") {
			List<ReportUser_infoBoard> list = rs.accusationList();
			for (int i=0; i<list.size(); i++) {
				if(list.get(i).getBattach()!= null) {
					list.get(i).setBattachType(list.get(i).getBattach().substring(0, 5));
					list.get(i).setBattachSrc(list.get(i).getBattach().substring(6));
				}
			}
//			System.out.println("list.get(0).getUnickname_1()->"+list.get(0).getUnickname_1());
//			System.out.println("list.get(0).getUnickname()->"+list.get(0).getUnickname());
			model.addAttribute("ReportUser_infoBoardList", list);
		}else {
			returnPage = "redirect:/bro/index";
		}
		return returnPage;
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
	// Interceptors
	// interCepter 진행 Test  --> 2번째 수행 
	@GetMapping(value = "/coffee/interceptor/uncensoredAccusationManagerPage")
	public String uncensoredAccusationManagerPageI(HttpServletRequest req, Model model) {
		String url = "/coffee/uncensoredAccusationManagerPage";
		System.out.println("CoffeeController "+url+" interceptor  start..");
		// 관리자 검증
		managerVerification(req, model, url);
		return url;
	}
	
	@GetMapping(value = "/coffee/uncensoredAccusationManagerPage")
	public String uncensoredAccusationManagerPage(HttpServletRequest req, Model model) {
		String returnPage = "/coffee/uncensoredAccusationManagerPage";
		System.out.println("CoffeeController" +returnPage+ "start..");
		// 관리자 검증
		HttpSession session = req.getSession();
		String manager = (String) session.getAttribute("manager");
		if (manager == null) manager = "9";
		System.out.println(returnPage+" manager->"+ manager );
		if(manager == "0") {
			List<ReportUser_infoBoard> list = rs.uncensoredList();
			for (int i=0; i<list.size(); i++) {
				if(list.get(i).getBattach()!= null) {
					list.get(i).setBattachType(list.get(i).getBattach().substring(0, 5));
					list.get(i).setBattachSrc(list.get(i).getBattach().substring(6));
				}
			}
//			System.out.println("list.get(0).getUnickname_1()->"+list.get(0).getUnickname_1());
//			System.out.println("list.get(0).getUnickname()->"+list.get(0).getUnickname());
			model.addAttribute("ReportUser_infoBoardList", list);
		}else {
			returnPage = "redirect:/bro/index";
		}
		return returnPage;
	}
}
