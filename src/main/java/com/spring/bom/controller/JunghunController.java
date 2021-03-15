package com.spring.bom.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.bom.model.hoon.Junghun;
import com.spring.bom.model.hoon.user_info;
import com.spring.bom.service.hoon.JunghunService;

@Controller
public class JunghunController {
	@Autowired
	private JunghunService js;

	@RequestMapping(value = "hoon/main")
	public String main() {
		return "hoon/main";
	}

	@RequestMapping(value = "hoon/explore")
	public String explore(Model model, Junghun junghun, HttpSession session) throws Exception {
		System.out.println("hoon Controller explore Start");
		user_info loginUser = (user_info) session.getAttribute("login");
		System.out.println("explore -> " + loginUser.getuEmail());

		// 로그인 ucode 전역 설정
		junghun.setLoginUcode(loginUser.getuCode());
		System.out.println("junghun.getLoginUcode() -> " + junghun.getLoginUcode());
		List<Junghun> listCount = js.listCount(junghun);
		List<Junghun> listHash = js.listHash(junghun);
		List<Junghun> listTrend = js.listTrend(junghun);
		List<Junghun> searchkeyword = js.searchkeyword(junghun);

		System.out.println("searchkeyword count::" + searchkeyword.size());
		System.out.println("listTrend count::" + listTrend.size());
		System.out.println("listCount count:: " + listCount.size());
		System.out.println("listHash count:: " + listHash.size());

		model.addAttribute("searchkeyword", searchkeyword);
		model.addAttribute("listTrend", listTrend);
		model.addAttribute("listHash", listHash);
		model.addAttribute("listCount", listCount);
		return "hoon/explore";
	}

	@RequestMapping(value = "hoon/searchView")
	public String searchView(HttpServletRequest request ,Model model, Junghun junghun, String search, HttpSession session) throws Exception {
		System.out.println("hoon Controller search Start");
		System.out.println("Controller ::" + search);
		user_info loginUser = (user_info) session.getAttribute("login");
		System.out.println("explore -> " + loginUser.getuEmail());
		
		if(search.trim().equals("")||search.trim()==null) {
	         return "hoon/explore";
	      }
		
		// 로그인 ucode 전역 설정
		junghun.setLoginUcode(loginUser.getuCode());
		System.out.println("junghun.getLoginUcode() -> " + junghun.getLoginUcode());
		List<Junghun> listSearch = js.listSearch(junghun);
		List<Junghun> listUser = js.listUser(junghun);
		List<Junghun> listNew = js.listNew(junghun);
		int searchData = js.searchData(junghun);
		List<Junghun> listTrend = js.listTrend(junghun);
		List<Junghun> searchkeyword = js.searchkeyword(junghun);
		List<Junghun> searchblock = js.searchblock(junghun);
		
		// 사진.동영상 세부지정
		System.out.println("Junghun Controller 첨부파일 지정 Start");
		for (int i = 0; i < listSearch.size(); i++) {
			if (listSearch.get(i).getBattach() !=null) {
				System.out.println("["+i+"]"+" battach Data : " + listSearch.get(i).getBattach());
				listSearch.get(i).setBattachType(listSearch.get(i).getBattach().substring(0, 5));
				listSearch.get(i).setBattachSrc(listSearch.get(i).getBattach().substring(6));
				System.out.println("battach Type : " + listSearch.get(i).getBattachType() + " / battach Source : "
						+ listSearch.get(i).getBattachSrc());
			}
		}
		System.out.println("Junghun Controller Type Src fail");
		
		System.out.println("searchblock ::"+searchblock.size());
		System.out.println("searchkeyword count::" + searchkeyword.size());
		System.out.println("listTrend count::" + listTrend.size());
		System.out.println("검색데이터 저장되면 1 ::" + searchData);
		System.out.println("content ::" + listSearch.size());
		System.out.println("user ::" + listUser.size());
		System.out.println("new Content ::" + listNew.size());
		
		
		model.addAttribute("searchblock",searchblock);
		model.addAttribute("searchkeyword", searchkeyword);
		model.addAttribute("listTrend", listTrend);
		model.addAttribute("search", search);
		model.addAttribute("listSearch_size", listSearch.size());
		model.addAttribute("listSearch", listSearch);
		model.addAttribute("listUser", listUser);
		model.addAttribute("listNew", listNew);
		return "hoon/searchView";
	}

	@RequestMapping(value = "like")
	public String like() {
		return "hoon/like";
	}
	
	@RequestMapping(value = "deleteRow")
	@ResponseBody
	public String deleteRow(Model model ,int ucode, HttpSession session) {
		System.out.println("del ::1");
		user_info loginUser = (user_info) session.getAttribute("login");
		System.out.println("del ::2");
		int jh =js.deleterow(ucode);
		System.out.println("deleteRow del - 리턴되면:: "+jh);
		System.out.println("del ::3");
		return "redirect:";
	}

}
