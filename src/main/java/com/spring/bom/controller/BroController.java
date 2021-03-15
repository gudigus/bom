package com.spring.bom.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.spring.bom.model.bro.user_info;
import com.spring.bom.service.bro.bomService;

@Controller
public class BroController {
	@Autowired
	private bomService bs;

		
	@RequestMapping(value = "bro/login" , method=RequestMethod.POST)
	public String login(user_info ui, HttpServletRequest req,Model model) throws Exception{
		HttpSession session = req.getSession();
		user_info user = bs.loginCheck(ui);
		if(user == null) {
			session.setAttribute("user", null);
			System.out.println("login off");
			return "bro/index";
		}else if(user.getuState() == 0){
			//탈퇴 회원 로그인시 계정 복구page
			String uemail = req.getParameter("uemail");
			model.addAttribute("uemail",uemail);
			model.addAttribute("user",user);
			System.out.println("uemail : "+ user.getuEmail());
			session.setAttribute("ui",user);
			session.setAttribute("ucode", user.getuCode());
			System.out.println("탈퇴회원 login");
			return "/right/UserdisabledPage";
		}else {
			String uemail = req.getParameter("uemail");
			model.addAttribute("uemail",uemail);
			model.addAttribute("user",user);
			System.out.println("uemail : "+ user.getuEmail());
			session.setAttribute("ui",user);
			session.setAttribute("ucode", user.getuCode());
			System.out.println("login on");
			return "right/main";
		}
	}
	
	@RequestMapping(value = "bro/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:/";
	}
	@RequestMapping(value = "bro/index")
     public String index() {
	 return "bro/login";
	}

}