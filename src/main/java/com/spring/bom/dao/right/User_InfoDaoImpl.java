package com.spring.bom.dao.right;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bom.model.right.Block;
import com.spring.bom.model.right.Interest;
import com.spring.bom.model.right.InterestDetail;
import com.spring.bom.model.right.User_Info;

@Repository
public class User_InfoDaoImpl implements User_InfoDao {
	// Mybatis 세션 
	@Autowired
	private SqlSession session;

	@Override
	public User_Info detail(int ucode) {
		System.out.println("User_InfoDaoImpl detail start..");
		
		User_Info ui = new User_Info();
		try {
			ui = session.selectOne("rightUserSelect", ucode);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl detail Exception->"+e.getMessage());
		}
		return ui;
	}
	@Override
	public int changeinsert(User_Info ui) {
		System.out.println("User_InfoDaoImpl changeinsert start..");
		int result1 = 0;
		try {
			result1 = session.insert("rightUserEdit1", ui);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl changeinsert Exception->"+e.getMessage());
		}
		return result1;
	}

	@Override
	public int changeupdate(User_Info ui) {
		System.out.println("User_InfoDaoImpl changeupdate start..");
		int result2 = 0;
		try {
			result2 = session.update("rightUserEdit2", ui);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl changeupdate Exception->"+e.getMessage());
		}
		return result2;
	}
	@Override
	public int edit(User_Info ui) {
		System.out.println("User_InfoDaoImpl edit start..");
		int result3 = 0;
		try {
			result3 = session.update("rightUserEdit3", ui);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl edit Exception->"+e.getMessage());
		}
		return result3;
	}
	@Override
	public int userIdCheck(String uatid) {
		System.out.println("User_InfoDaoImpl userIdCheck start..");
		int cnt = 0;
		try {
			cnt = session.selectOne("checkId", uatid);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl userIdCheck Exception->"+e.getMessage());
		}
		
		return cnt;
	}
	@Override
	public int changeinsertstate(User_Info ui) {
		System.out.println("User_InfoDaoImpl changeinsertstate start..");
		int result = 0;
		try {
			result = session.insert("rightUserDisabl", ui);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl changeinsertstate Exception->"+e.getMessage());
		}
		return result;
	}
	@Override
	public int statedDis(User_Info ui) {
		System.out.println("User_InfoDaoImpl statedDis start..");
		int result1 = 0;
		try {
			result1 = session.update("rightUserDisabl1", ui);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl statedDis Exception->"+e.getMessage());
		}
		return result1;
	}
	@Override
	public int changeInfoState(User_Info ui) {
		System.out.println("User_InfoDaoImpl changeInfoState start..");
		int result2 = 0;
		try {
			result2 = session.update("rightUserDisabl3", ui);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl changeInfoState Exception->"+e.getMessage());
		}
		return result2;
	}
	@Override
	public int boardBpermission(User_Info ui) {
		System.out.println("User_InfoDaoImpl userIdCheck start..");
		int result3 = 0;
		try {
			result3 = session.update("rightUserDisabl3", ui);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl boardBpermission Exception->"+e.getMessage());
		}
		return result3;
	}
	@Override
	public User_Info select(String uemail) {
		System.out.println("User_InfoDaoImpl select start..");
		
		User_Info ui = new User_Info();
		try {
			ui = session.selectOne("rightUserSelectemail", uemail);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl select Exception->"+e.getMessage());
		}
		return ui;
	}
	@Override
	public int updouble(int ucode) {
		System.out.println("User_InfoDaoImpl updouble start..");
		int result = 0;
		try {
			result = session.update("rightupdouble", ucode);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl updouble Exception->"+e.getMessage());
		}
		return result;
	}
	@Override
	public int userpwCheck(String upassword, int ucode) {
		String u_code = String.valueOf(ucode);
		System.out.println("User_InfoDaoImpl userpwCheck start..");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("upassword", upassword);
		map.put("ucode", u_code);
		
		int cnt = 0;
		try {
			cnt = session.selectOne("checkPw", map);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl userpwCheck Exception->"+e.getMessage());
		}
		return cnt;
	}
	//비밀번호 변경
	
	@Override
	public int changePwinsert(int ucode, String pwd) {
		String u_code = String.valueOf(ucode);
		System.out.println("User_InfoDaoImpl userpwCheck start..");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pwd", pwd);
		map.put("ucode", u_code);
		
		System.out.println("User_InfoDaoImpl changePwinsert start..");
		int result1 = 0;
		try {
			result1 = session.insert("rightPwchange1", map);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl changePwinsert Exception->"+e.getMessage());
		}
		return result1;
	}
	@Override
	public int changePwupdate(int ucode, String pwd) {
		String u_code = String.valueOf(ucode);
		System.out.println("User_InfoDaoImpl changePwupdate start..");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pwd", pwd);
		map.put("ucode", u_code);
		
		System.out.println("User_InfoDaoImpl changePwupdate start..");
		int result2 = 0;
		try {
			result2 = session.update("rightPwchange2", map);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl changePwupdate Exception->"+e.getMessage());
		}
		return result2;
	}
	@Override
	public int editPw(int ucode, String pwd) {
		String u_code = String.valueOf(ucode);
		System.out.println("User_InfoDaoImpl userpwCheck start..");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pwd", pwd);
		map.put("ucode", u_code);
		System.out.println("User_InfoDaoImpl editPw start..");
		int result3 = 0;
		try {
			result3 = session.update("rightPwchange3", map);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl editPw Exception->"+e.getMessage());
		}
		return result3;
	}
	//관심사변경
	@Override
	public List<Interest> itdetail(int ucode) {
		System.out.println("User_InfoDaoImpl List<Interest> itdetail start..");
		List<Interest> list_choice = new ArrayList<Interest>();
		try {
			list_choice = session.selectList("rightInterestSelect", ucode);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl List<Interest> itdetail Exception->"+e.getMessage());
		}

		return list_choice;
	}
	@Override
	public List<InterestDetail> select(InterestDetail interestd) {
		System.out.println("User_InfoDaoImpl List<InterestDetail> select start..");
		List<InterestDetail> list = new ArrayList<InterestDetail>();
		try {
			list = session.selectList("rightInterestSelectAll", interestd);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl List<InterestDetail> select Exception->"+e.getMessage());
		}

		return list;
	}
	@Override
	public int deleteinterest(int ucode) {
		System.out.println("User_InfoDaoImpl deleteinterest start..");
		
		System.out.println("User_InfoDaoImpl deleteinterest start..");
		int result1 = 0;
		try {
			result1 = session.delete("rightInterestdelete", ucode);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl deleteinterest Exception->"+e.getMessage());
		}
		return result1;
	}
	@Override
	public int changeinsert1(Interest interest) {
		System.out.println("User_InfoDaoImpl changeinsert1 start..");
		
		System.out.println("User_InfoDaoImpl changeinsert1 start..");
		int result2 = 0;
		try {
			result2 = session.insert("rightInterestchange1", interest);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl changeinsert1 Exception->"+e.getMessage());
		}
		return result2;
	}
	@Override
	public int changeinsert2(Interest interest) {
		System.out.println("User_InfoDaoImpl changeinsert2 start..");
		
		System.out.println("User_InfoDaoImpl changeinsert2 start..");
		int result3 =0;
		try {
			result3 = session.insert("rightInterestchange2", interest);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl changeinsert2 Exception->"+e.getMessage());
		}
		return result3;
	}
	@Override
	public int changeinsert3(Interest interest) {
		System.out.println("User_InfoDaoImpl changeinsert3 start..");
		int result4 = 0;
		try {
			result4 = session.insert("rightInterestchange3", interest);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl changeinsert3 Exception->"+e.getMessage());
		}
		return result4;
	}

	//차단 block 조회
	@Override
	public List<Block> blockListP(int ucode) {
		System.out.println("User_InfoDaoImpl List<Block> blockListP start..");
		List<Block> blockListP = new ArrayList<Block>();
		try {
			blockListP = session.selectList("rightBlockSelect", ucode);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl List<Block> blockListP Exception->"+e.getMessage());
		}

		return blockListP;
	}
	@Override
	public List<Block> blockList(int ucode) {
		System.out.println("User_InfoDaoImpl List<Block> blockList start..");
		List<Block> blockList = new ArrayList<Block>();
		try {
			blockList = session.selectList("rightBlockSelect2", ucode);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl List<Block> blockList Exception->"+e.getMessage());
		}

		return blockList;
	}
	//차단 해제
	@Override
	public int deleteblock(int blcode) {
		System.out.println("User_InfoDaoImpl deleteblock start..");
		int result = 0;
		try {
			result = session.delete("rightDeleteblock", blcode);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl deleteblock Exception->"+e.getMessage());
		}
		return result;
	}
	//차단 추가
	@Override
	public int addBHash(int ucode, String bhashtag) {
		String u_code = String.valueOf(ucode);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bhashtag", bhashtag);
		map.put("ucode", u_code);

		int result = 0;
		System.out.println("User_InfoDaoImpl addBHash start..");
		try {
			result = session.insert("rightaddBHash", map);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl addBHash Exception->"+e.getMessage());
		}
		return result;
	}
	@Override
	public int addBWord(int ucode, String bword) {
		String u_code = String.valueOf(ucode);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bword", bword);
		map.put("ucode", u_code);
		
		System.out.println("User_InfoDaoImpl addBWord start..");
		int result = 0;
		try {
			result = session.insert("rightaddBWord", map);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl addBWord Exception->"+e.getMessage());
		}
		return result;
	}
	//계정복구
	//change_info에 바뀐 ustate insert
	@Override
	public int updateUstate1(int ucode) {
		int result1 = 0;
		System.out.println("User_InfoDaoImpl updateUstate1 start..");
		try {
			result1 = session.insert("rightupdateUstate1", ucode);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl updateUstate1 Exception->"+e.getMessage());
		}
		return result1;
	}
	//user_info에 바뀐 ustate update
	@Override
	public int updateUstate2(int ucode) {
		int result2 = 0;
		System.out.println("User_InfoDaoImpl updateUstate2 start..");
		try {
			result2 = session.update("rightupdateUstate2", ucode);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl updateUstate2 Exception->"+e.getMessage());
		}
		return result2;
	}
}
