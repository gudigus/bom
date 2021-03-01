package com.spring.bom.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



@Component
public class LoginIntercepter extends HandlerInterceptorAdapter{
	private static final String LOGIN = "login";
	
	
	@Override 
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    HttpSession httpSession = request.getSession(); 
    ModelMap modelMap = modelAndView.getModelMap(); 
    Object user_info = modelMap.get("login");
    if (user_info != null) { 
	httpSession.setAttribute(LOGIN, user_info); 
	response.sendRedirect("/main"); 
	} 
    }

	

	
}
