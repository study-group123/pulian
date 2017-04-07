package com.pulian.mall.controller.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pulian.mall.dto.AreasEnum;
import com.pulian.mall.dto.CardTypeEnum;
import com.pulian.mall.dto.SettlementBankEnum;
import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.dto.VipLevelEnum;
import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.request.BaseResultT;
import com.pulian.mall.request.UserManagerRequest;
import com.pulian.mall.service.impl.UserManagerServiceImpl;
import com.pulian.mall.util.CodeUtil;
import com.pulian.mall.util.ConstantUtil;
import com.pulian.mall.util.DataTablesPagination;
import com.pulian.mall.util.FirstLetterUtil;
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
	public BaseResultT<UserInfoDto> saveUser(@RequestBody UserManagerRequest userManagerRequest,Model model,HttpServletRequest request, HttpServletResponse response) {
		BaseResultT<UserInfoDto> baseResult = new BaseResultT<UserInfoDto>();
		try{
			//一个证件只能开一次账户
			//TODO
			
			//查询当前用户开过的银卡数
			userManagerRequest.setVipLevel(VipLevelEnum.SILVER);
			int silverSons = userManagerService.queryUserByParentIdAndVipLevel(userManagerRequest, request,  response);
			int maxCards = UserDefaultFieldUtil.getDefaultPublicCardNumbers(userManagerRequest.getVipLevel());
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
	public String toUserProfile(Model model,HttpServletRequest request,HttpServletResponse response) { 
		  
		  UserInfoDto user = (UserInfoDto) ServletUtil.getSession(request, response, ConstantUtil.USER_SESSION_KEY);
		  
		  UserManagerRequest userManagerRequest = new  UserManagerRequest();
		  userManagerRequest.setVipLevel(user.getVipLevel());
		  userManagerRequest.setParentId(user.getUserId());
		  int silverSons = userManagerService.queryUserByParentIdAndVipLevel(userManagerRequest,request,response);
		  
		  user.setRemainingCardsNum(UserDefaultFieldUtil.getDefaultPublicCardNumbers(user.getVipLevel())-silverSons);
		  
		  user.setInActiveChildren(getInActiveChildren(user));
		  
		  user.setFrozenChildren(getFrozenChildren(user));
		  
		  //TODO 有过购买记录的
		  user.setBoughtChildren(0);
		  
	      model.addAttribute("user", user);
		  return "/user/user_profile";
	} 

	private int getInActiveChildren(UserInfoDto user) {
		
		UserManagerRequest userManagerRequest = new UserManagerRequest();
		userManagerRequest.setParentId(user.getUserId());
		userManagerRequest.setPagination(new DataTablesPagination(0,9999));
		userManagerRequest.setActiveStatus(YesOrNoEnum.NO);
		BaseResultT<UserInfoDto> baseResultT   = userManagerService.queryUserInfo(userManagerRequest);
		
		List<UserInfoDto> sonList = baseResultT.getResults();
		
		return sonList.size();
	}
	
	private int getFrozenChildren(UserInfoDto user) {
		
		UserManagerRequest userManagerRequest = new UserManagerRequest();
		userManagerRequest.setParentId(user.getUserId());
		userManagerRequest.setPagination(new DataTablesPagination(0,9999));
		userManagerRequest.setFrozenStatus(YesOrNoEnum.YES);
		BaseResultT<UserInfoDto> baseResultT   = userManagerService.queryUserInfo(userManagerRequest);
		
		List<UserInfoDto> sonList = baseResultT.getResults();
		
		return sonList.size();
	}

	@RequestMapping(value="/toSaveUser",method={RequestMethod.POST,RequestMethod.GET})
	public String toSaveUser(Model model,HttpServletRequest request, HttpServletResponse response) {
		
		
		model.addAttribute("userAreaEnum", AreasEnum.values());
		model.addAttribute("settlementBankEnum",SettlementBankEnum.values());
		model.addAttribute("cardTypeEnum",CardTypeEnum.values());
		
		return "/user/add_user";
	}
	
	public void getChildrenOfCurrentUser(HttpServletRequest request, HttpServletResponse response){
		UserInfoDto user = (UserInfoDto) ServletUtil.getSession(request, response, ConstantUtil.USER_SESSION_KEY);
		
		UserManagerRequest userManagerRequest = new UserManagerRequest();
		userManagerRequest.setParentId(user.getUserId());
		userManagerRequest.setPagination(new DataTablesPagination(0,9999));
		BaseResultT<UserInfoDto> baseResultT   = userManagerService.queryUserInfo(userManagerRequest);
		
		List<UserInfoDto> sonList = baseResultT.getResults();
		int sonSize = sonList.size();
		for(UserInfoDto userInfo:sonList){
			
			if(VipLevelEnum.GOLD.name().equals(userInfo.getVipLevel().getParent())){
				userManagerRequest.setParentId(user.getUserId());
				baseResultT   = userManagerService.queryUserInfo(userManagerRequest);
				sonSize += baseResultT.getResults().size();
				userInfo.setSons(baseResultT.getResults());
			}
			
		}
		baseResultT.setResults(sonList);
		baseResultT.setCount(sonSize);
	}
	private void buildSaveUserRequest(UserManagerRequest userManagerRequest, int silverSons,HttpServletRequest request, HttpServletResponse response) {
		UserInfoDto user = (UserInfoDto) ServletUtil.getSession(request, response, ConstantUtil.USER_SESSION_KEY);
		userManagerRequest.setUserCode(user.getUserCode()+CodeUtil.padedNumberToSixDigits(++silverSons));
		userManagerRequest.setUserAccount(FirstLetterUtil.getFirstLetter(userManagerRequest.getUserName())+"_"+userManagerRequest.getUserCode());
		UserDefaultFieldUtil.setUserDefaultFields(userManagerRequest,request,response);
	}

	public static void main(String[] args) {
		
		
		
	}

}
