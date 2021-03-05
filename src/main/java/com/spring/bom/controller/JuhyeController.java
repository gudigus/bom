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

import com.spring.bom.model.god.Board;
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
	
	@RequestMapping(value="god/getSaveNum", produces="application/text;charset=UTF-8")
	@ResponseBody
	public String getSaveNum(int ucode, Model model) {
		System.out.println("start getSaveNum");
		return us.getSaveNum(ucode);
	}
	
	@RequestMapping(value="god/getReserveList", produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<Board> getReserveList(int ucode, Model model){
		System.out.println("getReserveList start");
		System.out.println("ucode -> "+ucode);
		return us.getReserveList(ucode);
	}
	
	@RequestMapping(value="god/getSaveList", produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<Board> getSaveList(int ucode){
		System.out.println("getSaveList ucode -> "+ucode);
		List<Board> list=us.getSaveList(ucode);
		System.out.println("list length -> "+list.size());
		return list;
	} 
	
	@PostMapping(value="god/write")
	public String write(Board board, Model model) {
		System.out.println("bcontent : "+board.getBcontent());
		
		return "redirect:main";
	}
	//낼해바
	/*https://stackoverflow.com/questions/29251099/making-a-input-type-file-hidden-with-button*/
}
