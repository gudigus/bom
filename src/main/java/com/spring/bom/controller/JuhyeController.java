package com.spring.bom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JuhyeController {

	@GetMapping(value="god/main")
	public String test() {
		return "god/main";
	}
	
	/*
	 * @RequestMapping(value="god/getTime", method=RequestMethod.POST)
	 * 
	 * @ResponseBody public String getTime(Model model) {
	 * 
	 * }
	 */
}
