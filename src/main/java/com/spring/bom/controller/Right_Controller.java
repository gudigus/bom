package com.spring.bom.controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.bom.model.right.User_Info;
import com.spring.bom.service.right.User_InfoService;

@Controller
public class Right_Controller {
	private static final Logger logger = LoggerFactory.getLogger(Right_Controller.class);

	@Autowired
	private User_InfoService us;
	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(value = "/right/main")
	public String main(HttpServletRequest request, Model model) {
		String uemail = request.getParameter("uemail");
		model.addAttribute("uemail", uemail);
		User_Info ui = us.select(uemail);
		model.addAttribute("ui", ui);
		System.out.println("uemail : " + uemail);

		return "/right/main";
	}

	// 더보기
	@RequestMapping(value = "right/moreSee")
	public String moreSee(HttpServletRequest request, Model model) {
		int ucode = Integer.parseInt(request.getParameter("ucode"));
		model.addAttribute("ucode", ucode);
		User_Info ui = us.detail(ucode);
		HttpSession session = request.getSession();
		session.setAttribute("ucode", ucode);
		model.addAttribute("ui", ui);

		return "/right/moreSee";
	}

	// 회원수정 전 비밀번호 입력
	@RequestMapping(value = "right/insertpw")
	public String insertpw(HttpServletRequest request, Model model) {
		int ucode = Integer.parseInt(request.getParameter("ucode"));
		model.addAttribute("ucode", ucode);
		HttpSession session = request.getSession();
		User_Info ui = us.detail(ucode);
		session.setAttribute("ucode", ucode);
		model.addAttribute("ui", ui);
		System.out.println("insertpw -- request.getRequestURI()->" + request.getContextPath());
		return "/right/insertpw";
	}

	// 회원수정 edit
	@RequestMapping(value = "right/userInfoEditForm")
	public String userInfoEditForm(HttpServletRequest request, Model model) {
		int ucode = Integer.parseInt(request.getParameter("ucode"));
		model.addAttribute("ucode", ucode);
		HttpSession session = request.getSession();

		User_Info ui = us.detail(ucode);

		session.setAttribute("ucode", ucode);
		model.addAttribute("ui", ui);

		return "/right/userInfoEditForm";
	}

	@PostMapping(value = "right/userInfoEdit")
	public String userInfoEdit(User_Info ui, Model model) {
		int result1 = us.changeinsert(ui);
		int result2 = us.changeupdate(ui);
		int result3 = us.edit(ui);
		model.addAttribute("result1", result1);
		model.addAttribute("result2", result2);
		model.addAttribute("result3", result3);

		return "/right/userInfoEdit";
	}

	// id 중복 체크 컨트롤러
	@RequestMapping(value = "right/idCheck", produces = "application/text;charset=UTF-8")
	@ResponseBody
	public String idCheck(String uatid) {
		System.out.println("uatid->" + uatid);
		int cnt = us.userIdCheck(uatid);

		System.out.println("idCheck " + cnt);

		return String.valueOf(cnt);
	}

	// 2단계 인증
	@RequestMapping(value = "right/doubleSecurity")
	public String doubleSecurity(HttpServletRequest request, Model model) {
		int ucode = Integer.parseInt(request.getParameter("ucode"));
		model.addAttribute("ucode", ucode);
		HttpSession session = request.getSession();
		User_Info ui = us.detail(ucode);

		session.setAttribute("ucode", ucode);
		model.addAttribute("ui", ui);

		return "/right/doubleSecurity";
	}

	@GetMapping(value = "right/mailTransport")
	public String mailTransport(HttpServletRequest request, Model model) {
		int ucode = Integer.parseInt(request.getParameter("ucode"));
		model.addAttribute("ucode", ucode);
		HttpSession session = request.getSession();

		User_Info ui = us.detail(ucode);

		session.setAttribute("ucode", ucode);
		model.addAttribute("ui", ui);

		System.out.println("mailSending...");
		String tomail = request.getParameter("uemail"); // 받는 사람 이메일
		System.out.println(tomail);
		String setfrom = request.getParameter("uemail");
		String title = "Bom 2단계 인증 메일 입니다."; // 제목
		int checknum = (int) (Math.random() * 999999) + 1;
		try {
			// Mime 전자우편 Internet 표준 Format
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom(setfrom); // 보내는사람 생략하거나 하면 정상작동을 안함
			messageHelper.setTo(tomail); // 받는사람 이메일
			messageHelper.setSubject(title); // 메일제목은 생략이 가능하다

			messageHelper.setText("인증번호 : " + checknum); // 메일 내용
			System.out.println("인증번호 : " + checknum);
			mailSender.send(message);
			model.addAttribute("check", 1); // 정상 전달

		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("check", 2); // 메일 전달 실패
		}
		String num = Integer.toString(checknum);
		return "right/mailResult";
	}

	// 비번 변경
	@RequestMapping(value = "right/changePw")
	public String changePw(HttpServletRequest request, Model model) {
		int ucode = Integer.parseInt(request.getParameter("ucode"));
		model.addAttribute("ucode", ucode);
		HttpSession session = request.getSession();
		session.setAttribute("ucode", ucode);

		return "/right/changePw";
	}

	// 차단
	@RequestMapping(value = "right/block")
	public String block(HttpServletRequest request, Model model) {
		int ucode = Integer.parseInt(request.getParameter("ucode"));
		model.addAttribute("ucode", ucode);
		HttpSession session = request.getSession();
		session.setAttribute("ucode", ucode);

		return "/right/block";
	}

	// 탈퇴
	@RequestMapping(value = "right/userDisabled")
	public String userDisabled(HttpServletRequest request, Model model) {
		int ucode = Integer.parseInt(request.getParameter("ucode"));
		model.addAttribute("ucode", ucode);
		HttpSession session = request.getSession();
		session.setAttribute("ucode", ucode);

		return "/right/userDisabled";
	}

	@PostMapping(value = "right/userDisabledPro")
	public String userDisabledPro(User_Info ui, Model model) {
		int result = us.changeinsertstate(ui);
		int result1 = us.statedDis(ui);
		int result2 = us.changeInfoState(ui);
		int result3 = us.boardBpermission(ui);
		model.addAttribute("result", result);
		model.addAttribute("result1", result1);
		model.addAttribute("result2", result2);
		model.addAttribute("result3", result3);

		return "/right/userDisabledPro";
	}
}
