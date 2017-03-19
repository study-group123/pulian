package com.pulian.mall.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.request.BaseResult;
import com.pulian.mall.request.UserManagerRequest;
import com.pulian.mall.service.impl.UserManagerServiceImpl;
import com.pulian.mall.util.CodeUtil;
import com.pulian.mall.util.DateUtils;
import com.pulian.mall.util.FirstLetterUtil;

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
