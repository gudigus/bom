package com.spring.bom.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

	@RequestMapping(value = "hoon/main")
	public String main() {
		return "hoon/main";
	}

	@RequestMapping(value = "hoon/explore")
	public String explore(Model model, Junghun junghun) {
		System.out.println("hoon Controller explore Start");
		List<Junghun> listCount = js.listCount(junghun);
		List<Junghun> listHash = js.listHash(junghun);
		List<Junghun> listTrend = js.listTrend(junghun);

		System.out.println("listTrend count::" + listTrend.size());
		System.out.println("listCount count:: " + listCount.size());
		System.out.println("listHash count:: " + listHash.size());

		model.addAttribute("listTrend", listTrend);
		model.addAttribute("listHash", listHash);
		model.addAttribute("listCount", listCount);
		return "hoon/explore";
	}

	@RequestMapping(value = "hoon/searchView")
	public String searchView(Model model, Junghun junghun, String search) throws Exception {
		System.out.println("hoon Controller search Start");
		System.out.println("Controller ::" + search);
		List<Junghun> listSearch = js.listSearch(search);
		List<Junghun> listUser = js.listUser(search);
		List<Junghun> listNew = js.listNew(search);
		int searchData = js.searchData(junghun);
		List<Junghun> listTrend = js.listTrend(junghun);

		System.out.println("listTrend count::" + listTrend.size());
		System.out.println("검색데이터 저장되면 1 ::" + searchData);
		System.out.println("content ::" + listSearch.size());
		System.out.println("user ::" + listUser.size());
		System.out.println("new Content ::" + listNew.size());
		
		model.addAttribute("listTrend", listTrend);
		model.addAttribute("search", search);
		model.addAttribute("listSearch", listSearch);
		model.addAttribute("listUser", listUser);
		model.addAttribute("listNew", listNew);
		return "hoon/searchView";
	}

	@RequestMapping(value = "like")
	public String like() {
		return "hoon/like";
	}

}
