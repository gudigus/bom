package com.spring.bom.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.spring.bom.model.hoon.user_info;
import com.spring.bom.service.hoon.bomService;


@Controller
public class BroController {
	@Autowired
	private bomService bs;
	
	
		
	@RequestMapping(value = "hoon/login" , method=RequestMethod.POST)
	public String login(user_info ui, HttpServletRequest req) throws Exception{
		HttpSession session = req.getSession();
		user_info login = bs.loginCheck(ui);
		if(login == null) {
			session.setAttribute("login", null);
			System.out.println("login off");
			return "hoon/index";
		}else {
			session.setAttribute("login", login);
			System.out.println("login on");
			System.out.println(session);
			return "hoon/main";
		}
	}
	
	@RequestMapping(value = "hoon/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:/";
	}
	@RequestMapping(value = "hoon/index")
     public String index() {
	 return "hoon/login";
	}

}
