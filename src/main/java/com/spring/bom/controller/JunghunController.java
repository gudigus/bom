package com.spring.bom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.bom.model.hoon.Junghun;
import com.spring.bom.service.hoon.JunghunService;

@Controller
public class JunghunController {
	@Autowired
	private JunghunService js;

	
	@RequestMapping(value = "main")
	public String main() {
		return "hoon/main";
	}
	@RequestMapping(value = "explore")
	public String explore() {
		return "hoon/explore";
	}
	@RequestMapping(value = "hoon/searchView")
	public String searchView(Model model , Junghun junghun) {
		System.out.println("hoon Controller search Start");
		List<Junghun> listSearch = js.listSearch(junghun);
		List<Junghun> listUser   = js.listUser(junghun);
		List<Junghun> listNew    = js.listNew(junghun);
		System.out.println("content ::"+listSearch.size());
		System.out.println("user ::" + listUser.size());
		System.out.println("new Content ::"+listNew.size());
		
		model.addAttribute("listSearch",listSearch);
		model.addAttribute("listUser",listUser);
		model.addAttribute("listNew",listNew);
		return "hoon/searchView";
	}
	@RequestMapping(value = "like")
	public String like() {
		return "hoon/like";
	}
	
}
