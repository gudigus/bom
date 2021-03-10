package com.spring.bom.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.spring.bom.model.bro.user_info;
import com.spring.bom.service.bro.bomService;


@Controller
public class BroController {
	@Autowired
	private bomService bs;
	
	
		
	@RequestMapping(value = "/bro/login" , method=RequestMethod.POST)
	public String login(user_info ui, HttpServletRequest req) throws Exception{
		HttpSession session = req.getSession();
		user_info login = bs.loginCheck(ui);
		
		if(login == null) {
			session.setAttribute("uCode", "-1");
			System.out.println("login off");
			return "/bro/login";
		}else if(login.getuCode() == 0){
			session.setAttribute("uCode", login.getuCode());
			System.out.println("관리자 login on");
			return "/coffee/censorMemberManagerPage";
		}else {
			System.out.println("login on");
			session.setAttribute("uCode", login.getuCode());
			return "/coffee/example";
		}
	}
	
	@RequestMapping(value = "/bro/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:/bro/index";
	}
	@RequestMapping(value = "/bro/index")
     public String index() {
	 return "/bro/login";
	}

}
