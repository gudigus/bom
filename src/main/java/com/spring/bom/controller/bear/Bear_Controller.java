package com.spring.bom.controller.bear;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Bear_Controller {
	@RequestMapping(value = "test")
	public String gotest() {
		return "bear/test";
	}

}


