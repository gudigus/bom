package com.spring.bom.dao.right;

import java.util.List;

import com.spring.bom.model.right.Block;
import com.spring.bom.model.right.Interest;
import com.spring.bom.model.right.InterestDetail;
import com.spring.bom.model.right.User_Info;

public interface User_InfoDao {
	//회원 정보 수정
	User_Info		detail(int ucode);
	int				edit(User_Info ui);
	int				changeinsert(User_Info ui);
	int				changeupdate(User_Info ui);
	int 			userIdCheck(String uatid);
	int	 			statedDis(User_Info ui);
	int 			changeInfoState(User_Info ui);
	int 			boardBpermission(User_Info ui);
	int 			changeinsertstate(User_Info ui); 
	User_Info 		select(String uemail); 
	//2단계인증 상태 업데
	int 			updouble(int ucode); 
	int 			userpwCheck(String upassword, int ucode);
	//비밀번호 변경
	int 			changePwinsert(int ucode, String pwd); 	
	int		 		changePwupdate(int ucode, String pwd);
	int 			editPw(int ucode, String pwd);
	//관심사 변경
	//체크된 관심사 조회
	List<Interest> 	itdetail(int ucode);
	//관심사 전체 조회
	List<InterestDetail>  select(InterestDetail interestd); 
	int 			deleteinterest(int ucode);
	int 			changeinsert1(Interest interest);
	int 			changeinsert2(Interest interest);
	int 			changeinsert3(Interest interest);
	//차단 block 조회
	List<Block> 	blockList(int ucode); 
	List<Block> 	blockListP(int ucode); 
	//차단 해제
	int 			deleteblock(int blcode); 
	//차단 추가
	int				addBHash(int ucode, String bhashtag);
	int 			addBWord(int ucode, String bword); 
	//계정 복구
	int 			updateUstate1(int ucode); 
	int 			updateUstate2(int ucode); 
}
