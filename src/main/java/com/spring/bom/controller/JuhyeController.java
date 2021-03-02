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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.bom.service.god.UserService;

@Controller
public class JuhyeController {
	@Autowired
	private UserService us;
	
	@GetMapping(value = "god/main")
	public String test() {
		return "god/main";
	}
	
	@RequestMapping(value="god/getReserveNum", produces="application/text;charset=UTF-8")
	@ResponseBody
	public String getReserveNum(int ucode, Model model) {
		System.out.println("start getReserveNum");
		return us.getReserveNum(ucode);
	}
	
	@RequestMapping(value="god/getReserveList", produces="application/text;charset=UTF-8")
	@ResponseBody
	public List<String> getReserveList(int ucode, Model model){
		return us.getReserveList(ucode);
	}
}
