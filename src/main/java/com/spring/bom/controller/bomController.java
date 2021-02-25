package com.spring.bom.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.bom.model.user_info;
import com.spring.bom.service.bomService;


@Controller
public class bomController {
	@Autowired
	private bomService bs;
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
		
	@RequestMapping(value="/logincheck")
	public String loginCheck(user_info ui, HttpServletRequest req, RedirectAttributes rttr ) throws Exception {
		HttpSession session = req.getSession();
		user_info login = bs.login(ui);
		if(login==null) {
			session.setAttribute("user_ingfo", null);
			rttr.addFlashAttribute("msg", false);
			System.out.println("login page start");
		}else {
			session.setAttribute("user_info", login);
		}
		return "login";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:/";
	}
	@RequestMapping(value="/test")
	public String gotest() {
		return "test";
	}

}
