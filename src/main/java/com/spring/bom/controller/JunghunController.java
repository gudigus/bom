package com.spring.bom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.bom.model.hoon.Junghun;
import com.spring.bom.service.junghun.JunghunService;

@Controller
public class JunghunController {
	@Autowired
	private JunghunService js;

	
	@RequestMapping(value = "explore")
	public String main() {
		return "hoon/explore";
	}
	@RequestMapping(value = "search")
	public String search(Model model , Junghun junghun) {
		System.out.println("Junghun Controller search Start");
		List<Junghun> listSearch = js.listSearch(junghun);
		System.out.println(listSearch.size());
		model.addAttribute("listSearch",listSearch);
		return "hoon/searchView";
	}
}
