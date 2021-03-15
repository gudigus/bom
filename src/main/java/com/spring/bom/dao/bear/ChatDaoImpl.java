package com.spring.bom.dao.bear;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.bom.model.bear.Chat;
import com.spring.bom.model.bear.User;

@Repository
public class ChatDaoImpl implements ChatDao {
	// Mybatis 세션 
	@Autowired
	private SqlSession session;
		
	@Override
	public List<User> uonline(User user){
		
		List<User> uonline = null;
		try {
			uonline = session.selectList("listOnline", user);
		} catch (Exception e) {
			System.out.println("UserDaoImpl uonline e.getMessage() -> " + e.getMessage());
			
		}
		System.out.println("UserDaoImpl uonline.size() ->  "   + uonline.size());
		return uonline;
	}

	@Override
	public int chatmsg(Chat chat) {
		
		
		return session.insert("insertmsg",chat);
	}

	@Override
	public List<Chat> roomId(int sessionId) {
		List<Chat> roomId = null;
		System.out.println("chatDaoImple roomId - > "  + sessionId);
		try {
			roomId = session.selectList("listId",sessionId); 
			
		} catch (Exception e) {
			System.out.println("ChatDaoImpl chatinglist exception - > " + e.getMessage());
		}
		return roomId;
	}

	@Override
	public List<Chat> chatinglist(Chat chat) {
		List<Chat> chatinglist = null;
		try {
			chatinglist = session.selectList("chainglist", chat); 
			
		} catch (Exception e) {
			System.out.println("ChatDaoImpl chatinglist exception - > " + e.getMessage());
		}
		return chatinglist;
	}

	@Override
	public int mycreate(Chat chat) {
		System.out.println("chatDaoImpl mycreate 진행 - > chat 안에 있는 uopcode -> " + chat.getUopcode());
		return session.insert("mycreate",chat);
	}

	@Override
	public int youcreate(Chat chat) {
		System.out.println("chatDaoImpl youcreate 진행 ");
		return session.insert("youcreate",chat);
	}

	@Override
	public String selectcode(String atid) {
		System.out.println("chatDaoImpl selectcode 진행 - > atid " +atid);
		return session.selectOne("selectcode" ,atid);
	}
	
		

}
