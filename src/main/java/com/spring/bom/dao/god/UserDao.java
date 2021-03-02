package com.spring.bom.dao.god;

import java.util.List;

public interface UserDao {

	String getReserveNum(int ucode);

	List<String> getReserveList(int ucode);
}
