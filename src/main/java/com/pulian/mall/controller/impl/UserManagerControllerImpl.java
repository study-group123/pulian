package com.pulian.mall.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pulian.mall.dto.MenuDto;
import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.dto.VipLevelEnum;
import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.request.BaseResult;
import com.pulian.mall.request.BaseResultT;
import com.pulian.mall.request.UserManagerRequest;
import com.pulian.mall.service.impl.UserManagerServiceImpl;
import com.pulian.mall.util.CodeUtil;
import com.pulian.mall.util.ConstantUtil;
import com.pulian.mall.util.FirstLetterUtil;
import com.pulian.mall.util.MD5util;
import com.pulian.mall.util.ServletUtil;
import com.pulian.mall.util.UserDefaultFieldUtil;
/**
 * 
 * @author wangxiaoqiang
 * @date 2017-3-21
 */
@Controller
@RequestMapping("/user")
public class UserManagerControllerImpl {

	private static final Log log = LogFactory.getLog(UserManagerControllerImpl.class);
   
	@Autowired
	private UserManagerServiceImpl userManagerService;
	
	
	@RequestMapping("/saveUser")
	@ResponseBody
	public BaseResult saveUser(@RequestBody UserManagerRequest userManagerRequest,Model model,HttpServletRequest request, HttpServletResponse response) {
		BaseResult baseResult = new BaseResult();
		try{
			//一个证件只能开一次账户
			//TODO
			
			//查询当前用户开过的银卡数
			int silverSons = userManagerService.queryUserByParentIdAndVipLevel(userManagerRequest);
			int maxCards = UserDefaultFieldUtil.getDefaultPublicCardNumbers(userManagerRequest);
			if(silverSons < maxCards){
				buildSaveUserRequest(userManagerRequest,silverSons,request, response);
				baseResult = userManagerService.saveUserInfo(userManagerRequest);
			}else{
				baseResult.setMessage(ConstantUtil.MAX_PUBLISH_CARD_NUMBERS);
				baseResult.setSuccessStatus(YesOrNoEnum.NO);
			}
			
		}catch(Exception e){
			log.error("UserManagerControllerImpl.saveUser",e);
			baseResult.setSuccessStatus(YesOrNoEnum.NO);
		}
		
		return baseResult;
	}
	
	@RequestMapping("/queryUsers")
	@ResponseBody
	public BaseResultT<UserInfoDto> queryUsers(@RequestBody UserManagerRequest userManagerRequest,HttpServletRequest request, HttpServletResponse response) {
		BaseResultT<UserInfoDto> baseResultT = new BaseResultT<UserInfoDto>();
		try{
			baseResultT = userManagerService.queryUserInfo(userManagerRequest);
		}catch(Exception e){
			log.error("UserManagerControllerImpl.queryUsers",e);
			baseResultT.setSuccessStatus(YesOrNoEnum.NO);
		}
		
		return baseResultT;
	}
	
	@RequestMapping(value="/profile",method={RequestMethod.POST,RequestMethod.GET})     
	public String toIndex(Model model,HttpServletRequest request,HttpServletResponse response) { 
		  
		  UserInfoDto user = (UserInfoDto) ServletUtil.getSession(request, response, ConstantUtil.USER_SESSION_KEY);
		  
	      model.addAttribute("user", user);
		  return "/user/profile";
	} 

	@RequestMapping("/toSaveUser")
	public String toSaveUser(@RequestBody UserManagerRequest userManagerRequest,Model model,HttpServletRequest request, HttpServletResponse response) {
		
		
		
		return "";
	}
	
	private void buildSaveUserRequest(UserManagerRequest userManagerRequest, int silverSons,HttpServletRequest request, HttpServletResponse response) {
	
		userManagerRequest.setUserCode(userManagerRequest.getParentCode()+CodeUtil.padedNumberToSixDigits(++silverSons));
		userManagerRequest.setUserAccount(FirstLetterUtil.getFirstLetter(userManagerRequest.getUserName())+"_"+userManagerRequest.getUserCode());
		UserDefaultFieldUtil.setUserDefaultFields(userManagerRequest,request,response);
	}

	public static void main(String[] args) {
		
		
		
	}

}
