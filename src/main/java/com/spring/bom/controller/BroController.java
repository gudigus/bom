package com.spring.bom.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.bom.model.bro.User_info;
import com.spring.bom.service.bro.User_infoService;

@Controller
public class BroController {
	@Autowired
	private User_infoService us;
	
	@GetMapping(value = "bro/loginForm")
	public String login() {
		return "bro/login";
	}

	@RequestMapping(value = "bro/loginPro", method = RequestMethod.POST)
	public String login(HttpServletRequest request,User_info user_info, Model model) {
		User_info user = us.login(user_info);
		HttpSession session=request.getSession();
		session.setAttribute("user", user);
		
		 System.out.println("JuhyeController login"); 
		 if (user == null) { 
			 return "bro/loginForm"; 
		} 
		 else { 
			 return "god/main"; 
		 }
	}
}
