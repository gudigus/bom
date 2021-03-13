package com.spring.bom.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.bom.model.god.Board;
import com.spring.bom.model.god.Vote;
import com.spring.bom.service.god.UserService;
import com.spring.bom.service.god.VoteService;

@Controller
public class JuhyeController {
	@Autowired
	private UserService us;
	@Autowired
	private VoteService vs;
	
	@GetMapping(value = "god/main")
	public String test() {
		return "god/main";
	}

	@RequestMapping(value = "god/getReserveNum", produces = "application/text;charset=UTF-8")
	@ResponseBody
	public String getReserveNum(int ucode, Model model) {
		System.out.println("start getReserveNum");
		return us.getReserveNum(ucode);
	}

	@RequestMapping(value = "god/getSaveNum", produces = "application/text;charset=UTF-8")
	@ResponseBody
	public String getSaveNum(int ucode, Model model) {
		System.out.println("start getSaveNum");
		return us.getSaveNum(ucode);
	}

	@RequestMapping(value = "god/getReserveList", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<Board> getReserveList(int ucode, Model model) {
		System.out.println("getReserveList start");
		System.out.println("ucode -> " + ucode);
		return us.getReserveList(ucode);
	}

	@RequestMapping(value = "god/getSaveList", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<Board> getSaveList(int ucode) {
		System.out.println("getSaveList ucode -> " + ucode);
		List<Board> list = us.getSaveList(ucode);
		System.out.println("list length -> " + list.size());
		return list;
	}

	@RequestMapping(value = "god/write", method = RequestMethod.POST)
	public String write(Board board, Vote vote, Model model, @RequestParam("attach") MultipartFile file,  HttpServletRequest request) {
		System.out.println("bcontent -> " + board.getBcontent());
		if (board.getBregdate().equals("1")) {
			String regdate = request.getParameter("year").substring(2, 4) + "/"
					+ request.getParameter("month").substring(0, 2) + "/" + request.getParameter("day").substring(0, 2)
					+ " " + request.getParameter("hours").substring(0, 2) + ":"
					+ request.getParameter("minute").substring(0, 2) + ":00";
			System.out.println("regdate -> " + regdate);
			board.setBregdate(regdate);
		}
		System.out.println("btype -> " + board.getBtype());
		System.out.println("banchor -> " + board.getBanchor());
		System.out.println("bpermission -> " + board.getBpermission());
		if (request.getParameter("image").equals("1")) {
			try {
				String filename=System.currentTimeMillis()+file.getOriginalFilename();
				file.transferTo(new File(request.getServletContext().getRealPath("/image/")+filename));
				board.setBattach("/image/"+filename);
			} catch (Exception e) {
				System.out.println("JuhyeController write() -> "+e.getMessage());
			}
		}
		else if(request.getParameter("video").equals("1")) {
			try {
				String filename=System.currentTimeMillis()+file.getOriginalFilename();
				file.transferTo(new File(request.getServletContext().getRealPath("/video/")+filename));
				board.setBattach("/video/"+filename);
			} catch (Exception e) {
				System.out.println("JuhyeController write() -> "+e.getMessage());
			}
		}
		if(request.getParameter("vote").equals("1")) {
			//마감투표설정
			vote.setVendtime(vs.settingTime(vote));
			//중복투표설정
			if(request.getParameter("multipleChk")==null || request.getParameter("multipleChk").equals("")) {
				vote.setVmulti(0);
			}
			else if(request.getParameter("multipleChk").equals("on"))
				vote.setVmulti(1);
			//투표 등록
			int vcode=vs.insertVote(vote);
			System.out.println("vcode -> "+vcode);
		}
		return "redirect:main";
	}
	// 낼해바
	/*
	 * https://stackoverflow.com/questions/29251099/making-a-input-type-file-hidden-
	 * with-button
	 */
}
