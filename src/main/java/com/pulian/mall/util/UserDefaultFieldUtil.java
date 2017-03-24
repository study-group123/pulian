package com.pulian.mall.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pulian.mall.dto.ApprovalTypeEnum;
import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.request.ApprovalManagerRequest;
import com.pulian.mall.request.UserManagerRequest;

public class UserDefaultFieldUtil {

	public static final String DEFAULT_PWD = "666666";
	
	public static YesOrNoEnum DEFAULT_FROZEN_STATUS = YesOrNoEnum.NO;
	
	public static YesOrNoEnum DEFAULT_ACTIVE_STATUS = YesOrNoEnum.YES;
	
	public static YesOrNoEnum DEFAULT_DISABLED = YesOrNoEnum.NO;
	
    public static  String generateDefaultPwd(){
    	
    	return MD5util.encoderPwdByMd5(DEFAULT_PWD);
    }
    
    public static void setUserDefaultFields(UserManagerRequest userManagerRequest,HttpServletRequest request, HttpServletResponse response){
    	userManagerRequest.setActiveStatus(DEFAULT_ACTIVE_STATUS);
    	userManagerRequest.setFrozenStatus(DEFAULT_FROZEN_STATUS);
    	userManagerRequest.setUserDisable(DEFAULT_DISABLED);
    	userManagerRequest.setPassWord(generateDefaultPwd());
    	UserInfoDto user = (UserInfoDto) ServletUtil.getSession(request, response, ConstantUtil.USER_SESSION_KEY);
    	userManagerRequest.setCreaterId(user.getUserId());
    	userManagerRequest.setUpdaterId(user.getUserId());
    	userManagerRequest.setCreateTime(DateUtil.getCurrentDateByFormat(DateUtil.YYMMDDHHMMSS));
    	userManagerRequest.setUpdateTime(DateUtil.getCurrentDateByFormat(DateUtil.YYMMDDHHMMSS));
    }
    
    public static void setApprovalDefaultFields(ApprovalManagerRequest approvalManagerRequest,HttpServletRequest request, HttpServletResponse response){
    	UserInfoDto user = (UserInfoDto) ServletUtil.getSession(request, response, ConstantUtil.USER_SESSION_KEY);
    	approvalManagerRequest.setApprovaltype(ApprovalTypeEnum.SILVER_TO_GOLD);
    	approvalManagerRequest.getApprovalDto().setCreaterId(user.getUserId());
    	approvalManagerRequest.getApprovalDto().setUpdaterId(user.getUserId());
    	approvalManagerRequest.getApprovalDto().setCreateTime(DateUtil.getCurrentDateByFormat(DateUtil.YYMMDDHHMMSS));
    	approvalManagerRequest.getApprovalDto().setUpdateTime(DateUtil.getCurrentDateByFormat(DateUtil.YYMMDDHHMMSS));
    }
}
