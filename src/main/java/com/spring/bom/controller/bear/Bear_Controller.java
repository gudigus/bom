package com.spring.bom.controller.bear;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.bom.model.bear.Chat;
import com.spring.bom.model.bear.User;
import com.spring.bom.service.bear.ChatService;

@Controller
public class Bear_Controller {
	@Autowired
	private ChatService cs; 
	
	List<Chat> roomList = new ArrayList<Chat>();
	static int ccode = 0;
	
	@RequestMapping(value = "bear/main")
	public String gotest() {
		return "bear/main";
	}
	
	
	
	
	@RequestMapping(value = "bear/chat")
	public String uonline(User user, Model model) {
		 List<User> useronline =cs.uonline(user);
		 System.out.println("Bear_controller uonline.size -> " + useronline.size());
		 model.addAttribute("useronline",useronline);
		 return "bear/chat";
	}

	@RequestMapping(value = "bear/chat2")
	public ModelAndView chat() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bear/chat2");
		return mv;
	}
	//방 페이지
	@RequestMapping(value = "bear/room")
	public ModelAndView room() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bear/room");
		return mv;
	}
	//방생성
	@RequestMapping(value = "bear/createRoom")
	public @ResponseBody List<Chat> createRoom(@RequestParam HashMap<Object, Object> params){
		System.out.println(" createRoom start ...." );
		String uopcode = (String) params.get("uopcode");
		System.out.println(" createRoom start1 .... uopcode -> " + uopcode );
		if(uopcode != null && !uopcode.trim().equals("")) {
			Chat room = new Chat();
			room.setCcode(++ccode);
			System.out.println(" createRoom start4  ccode .... + "+ ccode );
			room.setUopcode(uopcode);
			System.out.println(" createRoom start5 ...." + room);
			roomList.add(room);
		
			System.out.println("createRoom roomList -> " + roomList);
		}
		else {
			System.out.println("createRoom error  ");
		}
		return roomList;
	}
	/**
	 * 방 정보가져오기
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "bear/getRoom")
	public @ResponseBody List<Chat> getRoom(@RequestParam HashMap<Object, Object> params){
		return roomList;
	}
	
	/**
	 * 채팅방
	 * @return
	 */
	@RequestMapping(value = "bear/moveChating")
	public ModelAndView chating(@RequestParam HashMap<Object, Object> params) {
		ModelAndView mv = new ModelAndView();
		int roomNumber = Integer.parseInt((String) params.get("roomNumber"));
		System.out.println("bear_controller chating start roomNumber -> " +roomNumber);
		String roomName = (String) params.get("roomName");
		System.out.println("bear_controller chating start roomName -> " +roomName);
		List<Chat> new_list = roomList.stream().filter(o->o.getCcode()==roomNumber).collect(Collectors.toList());
		System.out.println("new_list - > " + new_list);
		if(new_list != null && new_list.size() > 0) {
			mv.addObject("roomName", params.get("roomName"));
			mv.addObject("roomNumber", params.get("roomNumber"));
			mv.setViewName("bear/chat2");
		}else {
			System.out.println("chating else -> ");
			mv.setViewName("room");
		}
		return mv;
	}
	
}


