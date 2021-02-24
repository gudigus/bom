package com.spring.bom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.bom.model.yeah.Board;
import com.spring.bom.model.yeah.UserBookmarkBoard;
import com.spring.bom.service.yeah.BookmarkService;





@Controller
public class Yeah_Controller {
    
	@Autowired
	private BookmarkService bms;
	
	
	
	@RequestMapping(value = "yeah/main")
	public String main() {
		System.out.println("Yeah_Controller main Start...");
		return "yeah/main";
	}

	@RequestMapping(value = "yeah/bookmark")
	 public String bookmark(String ucode, Model model) {
		//   1. int_ucode 변수 처리 
		int int_ucode = Integer.parseInt(ucode);
		System.out.println("Yeah_Controller bookmark Start...");
		System.out.println("Yeah_Controller bookmark ucode->"+int_ucode);
		
		List<UserBookmarkBoard> ubmBoardList = bms.ubmBoardList(int_ucode);
		
		System.out.println("Yeah_Controller ubmBoardList.size()"+ubmBoardList.size());
		
		model.addAttribute("ubmBoardList", ubmBoardList);
		
		
		
		return "yeah/bookmark";
	}
	
	
	
}
