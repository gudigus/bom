package com.spring.bom.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.spring.bom.model.bro.User_info;

import com.spring.bom.service.bro.bomService;



@Controller
public class BroController {
	@Autowired
	private bomService bs;
	
		
	@RequestMapping(value = "bro/login" , method=RequestMethod.POST)
	public String login(User_info ui, HttpServletRequest req,Model model) throws Exception{
		HttpSession session = req.getSession();
		User_info user = bs.loginCheck(ui);
		if(user == null) {
			session.setAttribute("user", null);
			System.out.println("login off");
			return "bro/index";
		}else {
			String uemail = req.getParameter("uemail");
			model.addAttribute("uemail",uemail);

			model.addAttribute("user",user);
			System.out.println("uemail : "+ user.getuEmail());
			
			session.setAttribute("ucode", user.getuCode());
			System.out.println("ucode : " + user.getuCode());
			System.out.println("login on");
			return "bear/main";
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