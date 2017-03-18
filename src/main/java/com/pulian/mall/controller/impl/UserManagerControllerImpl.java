package com.pulian.mall.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.request.UserManagerRequest;
import com.pulian.mall.service.impl.UserManagerServiceImpl;
import com.pulian.mall.util.AreasEnum;
import com.pulian.mall.util.CardTypeEnum;
import com.pulian.mall.util.CodeUtil;
import com.pulian.mall.util.FirstLetterUtil;
import com.pulian.mall.util.MD5util;
import com.pulian.mall.util.VipLevelEnum;
import com.pulian.mall.util.YesOrNoEnum;

@Controller
@RequestMapping("/user")
public class UserManagerControllerImpl {

	private static final Log log = LogFactory.getLog(UserManagerControllerImpl.class);
   
	@Autowired
	private UserManagerServiceImpl userManagerService;
	
	
	
	@RequestMapping("/toUserManager")
	public String toUserLogin(Model model,HttpServletRequest request, HttpServletResponse response) {
		
	     
		return "";
	}
	
	@RequestMapping("/saveUser")
	public String saveUser(UserManagerRequest userManagerRequest,Model model,HttpServletRequest request, HttpServletResponse response) {
		
		try{
			
			//查询当前用户开过的银卡数
			int silverSons = userManagerService.queryUserByParentIdAndVipLevel(userManagerRequest);
			
			buildSaveUserRequest(userManagerRequest,silverSons);
			userManagerService.saveUserInfo(userManagerRequest);
		}catch(Exception e){
			
			log.error("save user failed",e);
		}
		
		return "";
	}
	
	@RequestMapping("/toSaveUser")
	public String toSaveUser(UserManagerRequest userManagerRequest,Model model,HttpServletRequest request, HttpServletResponse response) {
		
		
		
		return "";
	}
	
	private void buildSaveUserRequest(UserManagerRequest request, int silverSons) {
	
		request.setUserCode(request.getParentCode()+CodeUtil.padedNumberToSixDigits(silverSons));
		request.setUserAccount(FirstLetterUtil.getFirstLetter(request.getUserName())+"_"+request.getUserCode());
	}

	public static void main(String[] args) {
		UserManagerRequest userInfoDto = new UserManagerRequest();
		userInfoDto.setActiveStatus(YesOrNoEnum.YES);
		userInfoDto.setBankAddress("银行地址");
		userInfoDto.setUserName("用户名");
		//userInfoDto.setUserCode(CodeUtil.getCode(userInfoDto.getUserArea()));
		userInfoDto.setBankNo("bankno");
		userInfoDto.setBankSerialNo("banksno");
		userInfoDto.setSettlementBank("settlementBank");
		//userInfoDto.setUserAccount("账号");
		userInfoDto.setPassWord(MD5util.EncoderPwdByMd5("666666"));
		userInfoDto.setCardType(CardTypeEnum.ID);
		userInfoDto.setParentId(999);
		userInfoDto.setFrozenStatus(YesOrNoEnum.NO);
		userInfoDto.setUserDisable(YesOrNoEnum.NO);
		userInfoDto.setVipLevel(VipLevelEnum.SILVER);
		userInfoDto.setUserArea(AreasEnum.HB);
		userInfoDto.setUserAddress("用户地址");
		saveUser(userInfoDto,null,null,null);
		
		
	}

}
