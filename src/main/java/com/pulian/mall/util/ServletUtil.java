package com.pulian.mall.util;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletUtil {

	
	public static void putSession(HttpServletRequest request,HttpServletResponse response,String key, Object obj) {
		  
		HttpSession session = request.getSession();
		session.setAttribute(key, obj);
	}
	
	public static Object getSession(HttpServletRequest request, HttpServletResponse response, String key) {
		Object result = request.getSession().getAttribute(key);
		
		return result;
	}
	
	public static void removeSession(HttpServletRequest request, HttpServletResponse response, String key) {
		HttpSession session = request.getSession(false);//防止创建Session  
	    if(session!=null)session.removeAttribute(key);  
		
	}
	
}
