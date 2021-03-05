package com.spring.bom.dao.god;

import java.util.List;

import com.spring.bom.model.god.Board;

public interface UserDao {

	String getReserveNum(int ucode);

	List<Board> getReserveList(int ucode);

	List<Board> getSaveList(int ucode);

	String getSaveNum(int ucode);
}
