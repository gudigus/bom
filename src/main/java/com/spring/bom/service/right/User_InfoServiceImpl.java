package com.spring.bom.service.right;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bom.dao.right.User_InfoDao;
import com.spring.bom.model.right.Block;
import com.spring.bom.model.right.Interest;
import com.spring.bom.model.right.InterestDetail;
import com.spring.bom.model.right.User_Info;

@Service
public class User_InfoServiceImpl implements User_InfoService {
	@Autowired
	private User_InfoDao ud;

	@Override
	public User_Info detail(int ucode) {
		System.out.println("User_InfoServiceImpl detail ...");
		return ud.detail(ucode);
	}

	@Override
	public int changeinsert(User_Info ui) {
		System.out.println("User_InfoServiceImpl changeinsert ...");
		return ud.changeinsert(ui);
	}

	@Override
	public int changeupdate(User_Info ui) {
		System.out.println("User_InfoServiceImpl changeupdate ...");
		return ud.changeupdate(ui);
	}
	
	@Override
	public int edit(User_Info ui) {
		System.out.println("User_InfoServiceImpl edit ...");
		return ud.edit(ui);
	}

	@Override
	public int userIdCheck(String uatid) {
		System.out.println("User_InfoServiceImpl userIdCheck ...");
		return ud.userIdCheck(uatid);
	}

	@Override
	public int statedDis(User_Info ui) {
		System.out.println("User_InfoServiceImpl statedDis ...");
		return ud.statedDis(ui);
	}

	@Override
	public int changeInfoState(User_Info ui) {
		System.out.println("User_InfoServiceImpl changeInfoState ...");
		return ud.changeInfoState(ui);
	}

	@Override
	public int boardBpermission(User_Info ui) {
		System.out.println("User_InfoServiceImpl boardBpermission ...");
		return ud.boardBpermission(ui);
	}

	@Override
	public int changeinsertstate(User_Info ui) {
		System.out.println("User_InfoServiceImpl changeinsertstate ...");
		return ud.changeinsertstate(ui);
	}

	@Override
	public User_Info select(String uemail) {
		System.out.println("User_InfoServiceImpl select ...");
		return ud.select(uemail);
	}
	//2단계인증 상태 update
	@Override
	public int updouble(int ucode) {
		System.out.println("User_InfoServiceImpl updouble ...");
		return ud.updouble(ucode);
	}

	@Override
	public int userpwCheck(String upassword, int ucode) {
		System.out.println("User_InfoServiceImpl userpwCheck ...");
		return ud.userpwCheck(upassword, ucode);
	}
	//비밀번호 변경
	@Override
	public int changePwinsert(int ucode, String pwd) {
		System.out.println("User_InfoServiceImpl changePwinsert ...");
		return ud.changePwinsert(ucode,pwd);
	}

	@Override
	public int changePwupdate(int ucode, String pwd) {
		System.out.println("User_InfoServiceImpl changePwupdate ...");
		return ud.changePwupdate(ucode,pwd);
	}

	@Override
	public int editPw(int ucode, String pwd) {
		System.out.println("User_InfoServiceImpl editPw ...");
		return ud.editPw(ucode,pwd);
	}
	//관심사 변경
	@Override
	public List<Interest> itdetail(int ucode) {
		System.out.println("User_InfoServiceImpl Interest itdetail ...");
		return ud.itdetail(ucode);
	}

	@Override
	public List<InterestDetail> select(InterestDetail interestd) {
		System.out.println("User_InfoServiceImpl Interest select ...");
		return ud.select(interestd);
	}
	@Override
	public int deleteinterest(int ucode) {
		System.out.println("User_InfoServiceImpl Interest deleteinterest ...");
		return ud.deleteinterest(ucode);
	}
	@Override
	public int changeinsert1(Interest interest) {
		System.out.println("User_InfoServiceImpl Interest changeinsert1 ...");
		return ud.changeinsert1(interest);
	}

	@Override
	public int changeinsert2(Interest interest) {
		System.out.println("User_InfoServiceImpl Interest changeinsert2 ...");
		return ud.changeinsert2(interest);
	}

	@Override
	public int changeinsert3(Interest interest) {
		System.out.println("User_InfoServiceImpl Interest changeinsert3 ...");
		return ud.changeinsert3(interest);
	}
	//차단 block 조회
	@Override
	public List<Block> blockListP(int ucode) {
		System.out.println("User_InfoServiceImpl blockListP ...");
		return ud.blockListP(ucode);
	}
	@Override
	public List<Block> blockList(int ucode) {
		System.out.println("User_InfoServiceImpl blockList ...");
		return ud.blockList(ucode);
	}
	//차단 해제

	@Override
	public int deleteblock(int blcode) {
		System.out.println("User_InfoServiceImpl deleteblock ...");
		return ud.deleteblock(blcode);
	}
	//차단 추가

	@Override
	public int addBHash(int ucode, String bhashtag) {
		System.out.println("User_InfoServiceImpl addBHash ...");
		return ud.addBHash(ucode, bhashtag);
	}

	@Override
	public int addBWord(int ucode, String bword) {
		System.out.println("User_InfoServiceImpl addBWord ...");
		return ud.addBWord(ucode, bword);
	}
	//계정복구
	@Override
	public int updateUstate1(int ucode) {
		System.out.println("User_InfoServiceImpl updateUstate ...");
		return ud.updateUstate1(ucode);
	}
	@Override
	public int updateUstate2(int ucode) {
		System.out.println("User_InfoServiceImpl updateUstate ...");
		return ud.updateUstate2(ucode);
	}
}
