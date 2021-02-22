package com.spring.bom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JuhyeController {

	@GetMapping(value="god/main")
	public String test() {
		return "god/main";
	}
}
