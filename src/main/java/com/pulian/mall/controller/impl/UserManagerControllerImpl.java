package com.pulian.mall.controller.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.request.BaseResult;
import com.pulian.mall.request.BaseResultT;
import com.pulian.mall.request.UserManagerRequest;
import com.pulian.mall.service.impl.UserManagerServiceImpl;
import com.pulian.mall.util.CodeUtil;
import com.pulian.mall.util.DateUtils;
import com.pulian.mall.util.ErrorMessageUtil;
import com.pulian.mall.util.FirstLetterUtil;
import com.pulian.mall.util.MD5util;

@Controller
@RequestMapping("/user")
public class UserManagerControllerImpl {

	private static final Log log = LogFactory.getLog(UserManagerControllerImpl.class);
   
	@Autowired
	private UserManagerServiceImpl userManagerService;
	
	
	@RequestMapping("/saveUser")
	@ResponseBody
	public BaseResult saveUser(UserManagerRequest userManagerRequest,Model model,HttpServletRequest request, HttpServletResponse response) {
		BaseResult baseResult = new BaseResult();
		try{
			//一个证件只能开一次账户
			//TODO
			
			//查询当前用户开过的银卡数
			int silverSons = userManagerService.queryUserByParentIdAndVipLevel(userManagerRequest);
			
			buildSaveUserRequest(userManagerRequest,silverSons);
			baseResult = userManagerService.saveUserInfo(userManagerRequest);
		}catch(Exception e){
			log.error("UserManagerControllerImpl.saveUser",e);
			baseResult.setSuccessStatus(YesOrNoEnum.NO);
		}
		
		return baseResult;
	}
	
	@RequestMapping("/queryUsers")
	@ResponseBody
	public BaseResultT<List<UserInfoDto>> queryUsers(UserManagerRequest userManagerRequest,HttpServletRequest request, HttpServletResponse response) {
		BaseResultT<List<UserInfoDto>> baseResultT = new BaseResultT<List<UserInfoDto>>();
		try{
			List<UserInfoDto> userList = userManagerService.queryUserInfo(userManagerRequest);
			baseResultT.setResult(userList);
		}catch(Exception e){
			log.error("UserManagerControllerImpl.queryUsers",e);
			baseResultT.setSuccessStatus(YesOrNoEnum.NO);
		}
		
		return baseResultT;
	}
	
	@RequestMapping("/updatePassWord")
	@ResponseBody
	public BaseResult updatePassWord(UserManagerRequest userManagerRequest,Model model,HttpServletRequest request, HttpServletResponse response) {
		BaseResult baseResult = new BaseResult();
		try{
			//clean user request
			UserManagerRequest searchRequest = buildUpdatePassWordSearchRequest(userManagerRequest);
			
			List<UserInfoDto> userList= userManagerService.queryUserInfo(searchRequest);
			if(!CollectionUtils.isEmpty(userList) && userList.size() == 1){
				
				UserManagerRequest commitRequest = buildUpdatePassWordCommitRequest(userList.get(0),userManagerRequest);
				baseResult = userManagerService.updateUserByUserId(commitRequest);
			}else{
				baseResult.setMessage(ErrorMessageUtil.USER_NOT_FOUND);
				baseResult.setSuccessStatus(YesOrNoEnum.NO);
			}
		}catch(Exception e){
			log.error("UserManagerControllerImpl.updatePassWord",e);
			baseResult.setSuccessStatus(YesOrNoEnum.NO);
		}
		
		return baseResult;
	}
	
	private UserManagerRequest buildUpdatePassWordCommitRequest(UserInfoDto currentUser,UserManagerRequest userManagerRequest) {
		
		UserManagerRequest commitRequest = new UserManagerRequest();
		commitRequest.setUserId(currentUser.getUserId());
		String newPwd = MD5util.EncoderPwdByMd5(userManagerRequest.getPassWord());
		commitRequest.setPassWord(newPwd);
		
		return commitRequest;
	}

	private UserManagerRequest buildUpdatePassWordSearchRequest(UserManagerRequest request) {
		
		UserManagerRequest searchRequest = new UserManagerRequest();
		searchRequest.setBankNo(request.getBankNo());	
		searchRequest.setCardType(request.getCardType());
		searchRequest.setCardNo(request.getCardNo());
		
		return searchRequest;
	}

	@RequestMapping("/toSaveUser")
	public String toSaveUser(UserManagerRequest userManagerRequest,Model model,HttpServletRequest request, HttpServletResponse response) {
		
		
		
		return "";
	}
	
	private void buildSaveUserRequest(UserManagerRequest request, int silverSons) {
	
		request.setUserCode(request.getParentCode()+CodeUtil.padedNumberToSixDigits(++silverSons));
		request.setUserAccount(FirstLetterUtil.getFirstLetter(request.getUserName())+"_"+request.getUserCode());
		request.setCreateTime(DateUtils.getDateByFormat(DateUtils.YYMMDDHHMMSS));
		request.setUpdateTime(DateUtils.getDateByFormat(DateUtils.YYMMDDHHMMSS));
	}

	public static void main(String[] args) {
		
		
		
	}

}
