package com.spring.bom.service.god;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

	String getReserveNum(int ucode);

	List<String> getReserveList(int ucode);
	
}
