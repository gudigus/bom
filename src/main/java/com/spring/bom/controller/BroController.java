package com.spring.bom.controller;







import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.bom.model.bro.User_info;

import com.spring.bom.service.bro.BomService;


@Controller
public class BroController {
	@Autowired
	private BomService bs;
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="bro/email", method = RequestMethod.POST)
	public String emailPage(User_info ui, Model model, HttpServletRequest request) {
	
		return "bro/email";
	}
	
	
		
	@RequestMapping(value = "bro/login" , method=RequestMethod.POST)
	public String login(User_info ui, HttpServletRequest req) throws Exception{
		HttpSession session = req.getSession();
		User_info login = bs.loginCheck(ui);
		if(login == null) {
			session.setAttribute("login", null);
			System.out.println("login off");
			return "bro/index";
		}else {
		
			;
			session.setAttribute("login", login);
			System.out.println("login on");
			return "bro/main";
		}
	}
	
	@RequestMapping(value = "bro/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:/";
	}
	@RequestMapping(value = "bro/index")
     public String index() {
	 return "bro/login";
	}
	@RequestMapping(value ="bro/joinForm", method = RequestMethod.GET)
	public String joinForm(User_info ui, Model model, HttpServletRequest request, String uEmail) {
		System.out.println("controller join start");
		bs.join(ui);
		System.out.println("mailSending...");
		String tomail = uEmail;              // 받는 사람 이메일
		System.out.println(tomail);
		String setfrom = "ppk453678@gamil.com";
		String title = "mailTransport 입니다";                 // 제목
		try {
			// Mime 전자우편 Internet 표준 Format
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom(setfrom);    // 보내는사람 생략하거나 하면 정상작동을 안함
			messageHelper.setTo(tomail);       // 받는사람 이메일
			messageHelper.setSubject(title);   // 메일제목은 생략이 가능하다
			String tempPassword = (int) (Math.random() * 999999) + 1 + "";
			messageHelper.setText("인증번호입니다 : " + tempPassword); // 메일 내용
			System.out.println("인증번호입니다 : " + tempPassword);
			DataSource dataSource = new FileDataSource("c:\\log\\jung1.jpg");
		    messageHelper.addAttachment(MimeUtility.encodeText("airport.png", "UTF-8", "B"), dataSource);
			mailSender.send(message);
			model.addAttribute("check", 1);   // 정상 전달
			model.addAttribute("tempPassword",tempPassword);
//			s.tempPw(u_id, tempPassword)  ;// db에 비밀번호를 임시비밀번호로 업데이트
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("check", 2);  // 메일 전달 실패
		}
		
		return "bro/mailResult";
	}
	@RequestMapping(value ="bro/join")
	public String join() {
		return "bro/joinForm";
	}

	 @RequestMapping(value = "/checkEmail", method= RequestMethod.GET)
     @ResponseBody	
	 public int checkEmail(@RequestParam("uEmail") String uEmail) {
		 System.out.println("checkEmail uEmail--"+uEmail);
		 int j = bs.checkEmail(uEmail);
		 return j;
	 }
	
	
	
	

}
