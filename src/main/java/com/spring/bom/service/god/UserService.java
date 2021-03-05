package com.spring.bom.service.god;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.bom.model.god.Board;

@Service
public interface UserService {

	String getReserveNum(int ucode);

	List<Board> getReserveList(int ucode);

	List<Board> getSaveList(int ucode);

	String getSaveNum(int ucode);
	
}
