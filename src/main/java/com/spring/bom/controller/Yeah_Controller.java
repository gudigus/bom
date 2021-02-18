package com.spring.bom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Yeah_Controller {

	@RequestMapping(value = "/bookmark")
	public String bookmark() {

		return "yeah/bookmark";
	}

	/*
	 * // 북마크
	 * 
	 * @GetMapping(value = "bookmark") public String bookmark(Model model) { 모델
	 * <-회원코드, 글코드 } return "bookmark"; // 북마크 삭제
	 * 
	 * @GetMapping(value="delete") public String delete(글코드, 회원코드) { 모델 <- 회원코드 ,글코드
	 * } return "delete";
	 * 
	 * 북마크 전체 삭제
	 * 
	 * 최신 북마크한 순으로 나열-> db
	 * 
	 * // 북마크 안에서의 검색
	 * 
	 * @GetMapping(value="search") public String search(Model model) 모델 <- 글코드, 회원코드
	 * or 회원 아이디
	 * 
	 * return "search";
	 */
	 
}
