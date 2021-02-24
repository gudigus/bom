package com.spring.bom.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.bom.model.right.User_Info;
import com.spring.bom.service.right.User_InfoService;


@Controller
public class Right_Controller {
	private static final Logger logger = LoggerFactory.getLogger(Right_Controller.class);

	@Autowired
	private User_InfoService us;
	@Autowired
	private JavaMailSender  mailSender;
	
	@RequestMapping(value =  "/right/main")
	public String main(HttpServletRequest request,Model model) {
		String ucode = request.getParameter("ucode");
		model.addAttribute("ucode",ucode);
		HttpSession session = request.getSession();
		session.setAttribute("ucode",ucode);

		return "/right/main";
	}
	//더보기
	@RequestMapping(value =  "right/moreSee")
	public String moreSee(HttpServletRequest request,Model model) {
		//int ucode = Integer.parseInt(request.getParameter("ucode"));
		int ucode = 2;
		model.addAttribute("ucode",ucode);
		HttpSession session = request.getSession();
		session.setAttribute("ucode",ucode);

		return "/right/moreSee";
	}
	//회원수정 전 비밀번호 입력
	@RequestMapping(value = "right/insertpw") 
	public String insertpw(HttpServletRequest request,Model model) { 
		//int ucode = Integer.parseInt(request.getParameter("ucode")); 
		int ucode = 2;
		model.addAttribute("ucode",ucode); HttpSession session =
		request.getSession();
		User_Info ui = us.detail(ucode);
		session.setAttribute("ucode",ucode); model.addAttribute("ui",ui);
		  
		return "/right/insertpw"; 
	}
	 
	//회원수정 edit
	@RequestMapping(value =  "right/userInfoEditForm")
	public String userInfoEditForm(HttpServletRequest request,Model model) {
		//int ucode = Integer.parseInt(request.getParameter("ucode"));
		int ucode = 2;
		model.addAttribute("ucode",ucode);
		HttpSession session = request.getSession();
		
		User_Info ui = us.detail(ucode);
		
		session.setAttribute("ucode",ucode);
		model.addAttribute("ui",ui);

		return "/right/userInfoEditForm";
	}
	
	@PostMapping(value =  "right/userInfoEdit")
	public String userInfoEdit(User_Info ui,Model model) {
		int result1 = us.changeinsert(ui);
		int result2 = us.changeupdate(ui);
		int result3 = us.edit(ui);
		model.addAttribute("result1",result1);
		model.addAttribute("result2",result2);
		model.addAttribute("result3",result3);

		return "/right/userInfoEdit";
	}
	// id 중복 체크 컨트롤러
	@RequestMapping(value = "/user/idCheck", method = RequestMethod.GET)
	@ResponseBody
	public int idCheck(@RequestParam("u_atid") String uatid) {

		return us.userIdCheck(uatid);
	}
	
	//2단계 인증
	@RequestMapping(value =  "right/doubleSecurity")
	public String doubleSecurity(HttpServletRequest request,Model model) {
		String ucode = request.getParameter("ucode");
		model.addAttribute("ucode",ucode);
		HttpSession session = request.getSession();
		session.setAttribute("ucode",ucode);

		return "/right/doubleSecurity";
	}
	// 비번 변경
	@RequestMapping(value =  "right/changePw")
	public String changePw(HttpServletRequest request,Model model) {
		String ucode = request.getParameter("ucode");
		model.addAttribute("ucode",ucode);
		HttpSession session = request.getSession();
		session.setAttribute("ucode",ucode);

		return "/right/changePw";
	}
	
	@RequestMapping(value =  "right/block")
	public String block(HttpServletRequest request,Model model) {
		String ucode = request.getParameter("ucode");
		model.addAttribute("ucode",ucode);
		HttpSession session = request.getSession();
		session.setAttribute("ucode",ucode);

		return "/right/block";
	}
	
	@RequestMapping(value =  "right/userDisabled")
	public String userDisabled(HttpServletRequest request,Model model) {
		String ucode = request.getParameter("ucode");
		model.addAttribute("ucode",ucode);
		HttpSession session = request.getSession();
		session.setAttribute("ucode",ucode);

		return "/right/userDisabled";
	}
}
