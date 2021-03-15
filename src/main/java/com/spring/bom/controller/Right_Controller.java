package com.spring.bom.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.bom.model.right.Block;
import com.spring.bom.model.right.Interest;
import com.spring.bom.model.right.InterestDetail;
import com.spring.bom.model.right.User_Info;
import com.spring.bom.service.right.User_InfoService;

@Controller
public class Right_Controller {
	private static final Logger logger = LoggerFactory.getLogger(Right_Controller.class);

	@Autowired
	private User_InfoService us;
	@Autowired
	private JavaMailSender mailSender;
	
	//탈퇴회원 로그인시
	@RequestMapping(value = "/right/UserdisabledPage")
	public String UserdisabledPage(HttpSession session, Model model) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);
		User_Info ui = us.detail(ucode);
		model.addAttribute("ui", ui);

		return "/right/UserdisabledPage";
	}
	//복구버튼 클릭시
	@RequestMapping(value = "/right/userAble")
	public String userAble(HttpSession session, Model model) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);
		User_Info ui = us.detail(ucode);
		model.addAttribute("ui", ui);
		int result1 = us.updateUstate1(ucode);
		int result2 = us.updateUstate2(ucode);
		model.addAttribute("result1", result1);
		model.addAttribute("result2", result2);
		
		return "/right/userAble";
	}
	/*@RequestMapping(value = "/right/userAbleResult")
	public String userAbleResult(HttpSession session, Model model) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		System.out.println("ucode -> "+ucode);
		model.addAttribute("ucode", ucode);
		int result1 = us.updateUstate1(ucode);
		int result2 = us.updateUstate2(ucode);
		model.addAttribute("result1", result1);
		model.addAttribute("result2", result2);
		
		return "/right/main";
	}*/
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
	public String moreSee(HttpSession session, Model model) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);
		User_Info ui = us.detail(ucode);
		model.addAttribute("ui", ui);

		return "/right/moreSee";
	} 
	//회원수정
	@RequestMapping(value = "right/updateEv")
	public String updateEv(HttpSession session, Model model) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);
		User_Info ui = us.detail(ucode);
		model.addAttribute("ui", ui);

		return "/right/updateEv";
	}
	/*
	 * 웹브라우저를 켰음. 크롬 세션이 한개.
	로그인 했음. 웹은 동작이 사용자의 요청 , 서버의 응답으로 구동이되요.
	HttpSession jungchurl = request.getSession();
	jungchurl.setAttribute("banana",세션에저장할 값 or 변수 or 객체)
	jsp페이지상 -> ${banana}  -> 이제 컨트롤러로 가자 why ? 기능수행을해야지.
	
	컨트롤러 왔음 -> HttpSession jungchurl, ~~~, ~~~
	 * 
	 */
	 
	// 회원수정 전 비밀번호 입력
	@RequestMapping(value = "right/insertpw")
	public String insertpw(HttpSession session, Model model) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);
		User_Info ui = us.detail(ucode);
		model.addAttribute("ui", ui);
		return "/right/insertpw";
	}

	// 회원수정 edit
	@RequestMapping(value = "right/userInfoEditForm")
	public String userInfoEditForm(HttpSession session, Model model) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);
		User_Info ui = us.detail(ucode);
		model.addAttribute("ui", ui);

		return "/right/userInfoEditForm";
	}

	@PostMapping(value = "right/userInfoEdit")
	public String userInfoEdit(User_Info ui, Model model) {
		int result1 = us.changeinsert(ui);
		System.out.println("ui.ucode "+ ui.getUcode());
		int result2 = us.changeupdate(ui);
		System.out.println("ui.ucode "+ ui.getUcode());
		int result3 = us.edit(ui);
		System.out.println("ui.ucode "+ ui.getUcode());
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
	public String doubleSecurity(HttpSession session, Model model) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);

		User_Info ui = us.detail(ucode);

		model.addAttribute("ui", ui);

		return "/right/doubleSecurity";
	}

	@GetMapping(value = "right/mailTransport")
	public String mailTransport(HttpSession session, Model model,String uemail) {
		
		System.out.println("uemail->"+uemail);

		System.out.println("mailSending...");
		String tomail = uemail; // 받는 사람 이메일
		System.out.println(tomail);
		String setfrom = "jo7021@gmail.com";
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
		String num = String.valueOf(checknum);
		model.addAttribute("num", num);
		System.out.println("num => "+ num);

		return "right/mailResult";
	}
	@PostMapping(value = "right/checknum")
	public String checknum(HttpSession session,@RequestParam String num, Model model) {
	//	String num = request.getParameter("num");
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);
		System.out.println("num->"+ num);
		model.addAttribute("num", num);
		User_Info ui = us.detail(ucode);
		model.addAttribute("ui", ui);
		
		return "right/checknum";
	}
	//2단계인증 DB 0->1로 업데이트
	@RequestMapping(value = "right/updateDouble")
	public String updateDouble(HttpSession session, Model model) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		User_Info ui = us.detail(ucode);
		model.addAttribute("ui", ui);
		int result = us.updouble(ucode);
		model.addAttribute("result", result);
		
		return "right/updateEv";
	}
	// 비번 변경 화면
	@RequestMapping(value = "right/changePw")
	public String changePw(HttpSession session, Model model) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);
		User_Info ui = us.detail(ucode);
		model.addAttribute("ui", ui);

		return "/right/changePw";
	}
	// pw 체크 컨트롤러
		@RequestMapping(value = "right/pwCheck", produces = "application/text;charset=UTF-8")
		@ResponseBody
		public String pwCheck(HttpSession session,String upassword, Model model) {
			int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
			model.addAttribute("ucode", ucode);
			User_Info ui = us.detail(ucode);
			model.addAttribute("ui", ui);
			System.out.println("upassword->" + upassword);
			int cnt = us.userpwCheck(upassword, ucode);

			System.out.println("upassword " + cnt);

			return String.valueOf(cnt);
		}
		//2단계 인증 0인지 1인지 판단
		@PostMapping(value = "right/changePwPro")
		public String changePwPro(HttpSession session, Model model,@RequestParam String pwd) {
			int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
			model.addAttribute("ucode", ucode);
			User_Info ui = us.detail(ucode);
			model.addAttribute("pwd", pwd);
			model.addAttribute("ui", ui);
			
			return "/right/changePwPro";
		}
	//2단계 인증 아닌 자 비번 번경
	@PostMapping(value = "right/changePw1")
	public String changePw1(HttpSession session, Model model,@RequestParam String pwd) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);
	
		int result1 = us.changePwinsert(ucode, pwd);
		int result2 = us.changePwupdate(ucode, pwd); 
		int result3 = us.editPw(ucode, pwd);
		model.addAttribute("result1", result1);
		model.addAttribute("result2", result2);
		model.addAttribute("result3", result3);

		return "/right/userInfoEdit";
	}
	// 2단계 인증 자 비번 번경
	//메일
	@PostMapping(value = "right/changePw2Mail")
	public String changePw2Mail(HttpSession session, Model model,@RequestParam String pwd) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);
		User_Info ui = us.detail(ucode);

		System.out.println("mailSending...");
		String tomail = ui.getUemail(); // 받는 사람 이메일
		System.out.println(tomail);
		String setfrom = "jo7021@gmail.com";
		String title = "Bom 비밀번호 변경 인증 메일 입니다."; // 제목
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
		String num = String.valueOf(checknum);
		model.addAttribute("num", num);
		model.addAttribute("pwd", pwd);
		System.out.println("num => "+ num);
		System.out.println("pwd => "+ pwd);

		return "right/pwmailResult";
	}
	@PostMapping(value = "right/pwchecknum")
	public String pwchecknum(HttpSession session,@RequestParam String num, Model model,@RequestParam String pwd) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);
	//	String num = request.getParameter("num");
		System.out.println("num->"+ num);
		model.addAttribute("num", num);
		model.addAttribute("pwd", pwd);
		System.out.println("pwd => "+ pwd);
		User_Info ui = us.detail(ucode);
		model.addAttribute("ui", ui);
		
		return "right/pwchecknum";
	}
	@PostMapping(value = "right/changePw2")
	public String changePw2(HttpSession session, Model model,@RequestParam String pwd) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);
		
		int result1 = us.changePwinsert(ucode, pwd);
		int result2 = us.changePwupdate(ucode, pwd); 
		int result3 = us.editPw(ucode, pwd);
		model.addAttribute("result1", result1);
		model.addAttribute("result2", result2);
		model.addAttribute("result3", result3);

		return "/right/userInfoEdit";
	}
	//관심사 변경
	//조회
	@RequestMapping(value = "right/likeForm")
	public String likeForm(HttpSession session, Model model,Interest interest,InterestDetail interestd) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);
		List<Interest> list_choice = us.itdetail(ucode);
		List<InterestDetail> list = us.select(interestd);
		model.addAttribute("interest", interest);
		model.addAttribute("list_choice", list_choice);
		model.addAttribute("list", list);
		model.addAttribute("interestd", interestd);
		
		System.out.println("list ->"+list);
		System.out.println("list_choice ->"+list_choice);
		
		return "/right/likeForm";
	}

	//관심사 변경 결과
	@PostMapping(value = "right/likeResult")
	public String likeResult(HttpSession session, Interest interest, Model model, @RequestParam ArrayList<Integer> hiddenValue) {
		System.out.println("hiddenValue1 : "+ hiddenValue);
		System.out.println("hiddenValueindex : "+ hiddenValue.get(0));
		System.out.println("hiddenValueindex : "+ hiddenValue.get(1));
		System.out.println("hiddenValueindex : "+ hiddenValue.get(2));
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);
		//hiddenValue.put("ucode", ucode);
		interest.setUcode(ucode);
		interest.setIcode1(hiddenValue.get(0));
		interest.setIcode2(hiddenValue.get(1));
		interest.setIcode3(hiddenValue.get(2));
		System.out.println("hiddenValue2 : "+ hiddenValue);
		int result1 = us.deleteinterest(ucode);
		int result2 = us.changeinsert1(interest);
		int result3 = us.changeinsert2(interest);
		int result4 = us.changeinsert3(interest);
		System.out.println("interest.icontent "+ interest.getIcontent());
		model.addAttribute("result2", result2);
		model.addAttribute("result1", result1);
		model.addAttribute("result3", result3);
		model.addAttribute("result4", result4);
		
		return "/right/likeResult";
	}
	
	// 차단
	//계정
	@RequestMapping(value = "right/block")
	public String block(HttpSession session, Model model) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);
		session.setAttribute("ucode", ucode);
		List<Block> bListP = us.blockListP(ucode);
		model.addAttribute("bListP", bListP);

		return "/right/block";
	}
	//해시태그
	@RequestMapping(value = "right/blockhash")
	public String blockhash(HttpSession session, Model model) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);
		session.setAttribute("ucode", ucode);
		List<Block> bList = us.blockList(ucode);
		model.addAttribute("bList", bList);

		return "/right/blockhash";
	}
	//해시태그 추가
	@RequestMapping(value = "right/plusBhash")
	public String plusBhash(HttpSession session, Model model) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);
		session.setAttribute("ucode", ucode);
		List<Block> bList = us.blockList(ucode);
		model.addAttribute("bList", bList);
				
		return "/right/plusBhash";
	}
	@PostMapping(value = "right/plusBhashRe")
	public String plusBhashRe(HttpSession session, Model model,@RequestParam String bhashtag) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);
		session.setAttribute("ucode", ucode);
		int result = us.addBHash(ucode,bhashtag);
		model.addAttribute("result", result);
				
		return "/right/plusBhashRe";
	}
	//단어
	@RequestMapping(value = "right/blockword")
	public String blockword(HttpSession session, Model model) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);
		session.setAttribute("ucode", ucode);
		List<Block> bList = us.blockList(ucode);
		model.addAttribute("bList", bList);

		return "/right/blockword";
	}
	//단어 추가
	@RequestMapping(value = "right/plusBword")
		public String plusBword(HttpSession session, Model model) {
			int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
			model.addAttribute("ucode", ucode);
			session.setAttribute("ucode", ucode);
			List<Block> bList = us.blockList(ucode);
			model.addAttribute("bList", bList);

			return "/right/plusBword";
		}
		@PostMapping(value = "right/plusBwordRe")
		public String plusBwordRe(HttpSession session, Model model,@RequestParam String bword) {
			int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
			model.addAttribute("ucode", ucode);
			session.setAttribute("ucode", ucode);
			int result = us.addBWord(ucode,bword);
			model.addAttribute("result", result);

			return "/right/plusBwordRe";
		}
	//차단 해제
	@RequestMapping(value = "right/blockdelete")
	public String blockdelete(Model model,@RequestParam int blcode) {
		int result = us.deleteblock(blcode);
		model.addAttribute("result", result);

		return "right/blockdeleteResult";
	}
	@RequestMapping(value = "right/blockdeleteResult")
	public String blockdeleteResult(HttpSession session,Model model) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);
		session.setAttribute("ucode", ucode);

		return "right/blockdeleteResult";
	}
	// 탈퇴
	@RequestMapping(value = "right/userDisabled")
	public String userDisabled(HttpSession session, Model model) {
		int ucode = Integer.parseInt(session.getAttribute("ucode").toString());
		model.addAttribute("ucode", ucode);
		session.setAttribute("ucode", ucode);
		User_Info ui = us.detail(ucode);
		model.addAttribute("ui", ui);

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

		return "/bro/login";
	}
}
