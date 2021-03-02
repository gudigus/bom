package com.spring.bom.dao.right;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		int cnt = session.selectOne("checkId", uatid);
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
		int result = session.insert("rightUserDisabl", ui);
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
		int result1 = session.update("rightUserDisabl1", ui);
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
		int result2 = session.update("rightUserDisabl2", ui);
		try {
			result2 = session.update("rightUserDisabl2", ui);
		} catch (Exception e) {
			System.out.println("User_InfoDaoImpl changeInfoState Exception->"+e.getMessage());
		}
		return result2;
	}
	@Override
	public int boardBpermission(User_Info ui) {
		System.out.println("User_InfoDaoImpl userIdCheck start..");
		int result3 = session.update("rightUserDisabl3", ui);
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


}
