package com.pulian.mall.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pulian.mall.request.UserManagerRequest;

@Controller
@RequestMapping("/user")
public class UserManagerControllerImpl {

	private static final Log log = LogFactory.getLog(UserManagerControllerImpl.class);

	
	@RequestMapping("/toUserManager")
	public String toUserLogin(Model model,HttpServletRequest request, HttpServletResponse response) {
		
	     
		return "";
	}
	
	@RequestMapping("/saveUser")
	public String toSaveCard(UserManagerRequest cardManagerRequest,Model model,HttpServletRequest request, HttpServletResponse response) {
	     
		return "";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
