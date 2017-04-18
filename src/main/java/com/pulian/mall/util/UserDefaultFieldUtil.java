package com.pulian.mall.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pulian.mall.dto.ApprovalTypeEnum;
import com.pulian.mall.dto.DictionaryDto;
import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.dto.VipLevelEnum;
import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.request.ApprovalManagerRequest;
import com.pulian.mall.request.UserManagerRequest;

public class UserDefaultFieldUtil {

	public static final String DEFAULT_PWD = "666666";
	
	public static YesOrNoEnum DEFAULT_FROZEN_STATUS = YesOrNoEnum.NO;
	
	public static YesOrNoEnum DEFAULT_ACTIVE_STATUS = YesOrNoEnum.NO;
	
	public static YesOrNoEnum DEFAULT_DISABLED = YesOrNoEnum.NO;
	
	public static int DEFAULT_PUBLISH_CARDS_SYSTEM = 1000;
	
	public static int DEFAULT_PUBLISH_CARDS_A = 60;
	
	public static int DEFAULT_PUBLISH_CARDS_B = 50;
	
	public static int DEFAULT_PUBLISH_CARDS_C = 30;
	
	public static int DEFAULT_PUBLISH_CARDS_D = 20;
	
	public static int DEFAULT_PUBLISH_CARDS_E = 10;
	
	
	//取用户最大发卡数
	public static int getDefaultPublicCardNumbers(VipLevelEnum vipLevelEnum){
		int cards = 0;
		switch(vipLevelEnum.getValue()){
		
		case VipLevelEnum.GOLD_A_VALUE:
			cards = DEFAULT_PUBLISH_CARDS_A;
			break;
		case VipLevelEnum.GOLD_B_VALUE:
			cards = DEFAULT_PUBLISH_CARDS_B;
			break;
		case VipLevelEnum.GOLD_C_VALUE:
			cards = DEFAULT_PUBLISH_CARDS_C;
			break;
		case VipLevelEnum.GOLD_D_VALUE:
			cards = DEFAULT_PUBLISH_CARDS_D;
			break;
		case VipLevelEnum.GOLD_E_VALUE:
			cards = DEFAULT_PUBLISH_CARDS_E;
			break;
		case VipLevelEnum.SYSTEM_VALUE:
			cards = DEFAULT_PUBLISH_CARDS_SYSTEM;
			break;
		
		}
		return cards;
	}
	
	//产生默认密码
    public static  String generateDefaultPwd(){
    	
    	return MD5util.encoderPwdByMd5(DEFAULT_PWD);
    }
    
    //新增用户默认属性
    public static void setUserDefaultFields(UserManagerRequest userManagerRequest,HttpServletRequest request, HttpServletResponse response){
    	userManagerRequest.setActiveStatus(DEFAULT_ACTIVE_STATUS);
    	userManagerRequest.setFrozenStatus(DEFAULT_FROZEN_STATUS);
    	userManagerRequest.setUserDisable(DEFAULT_DISABLED);
    	userManagerRequest.setPassWord(generateDefaultPwd());
    	UserInfoDto user = (UserInfoDto) ServletUtil.getSession(request, response, ConstantUtil.USER_SESSION_KEY);
    	userManagerRequest.setParentId(user.getUserId());
    	userManagerRequest.setCreaterId(user.getUserId());
    	//userManagerRequest.setUpdaterId(user.getUserId());
    	userManagerRequest.setCreateTime(DateUtil.getCurrentDateByFormat(DateUtil.YYMMDDHHMMSS));
    	//userManagerRequest.setUpdateTime(DateUtil.getCurrentDateByFormat(DateUtil.YYMMDDHHMMSS));
    }
    
    //新增审批默认属性
    public static void setApprovalDefaultFields(ApprovalManagerRequest approvalManagerRequest,HttpServletRequest request, HttpServletResponse response){
    	UserInfoDto user = (UserInfoDto) ServletUtil.getSession(request, response, ConstantUtil.USER_SESSION_KEY);
    	if(user.getVipLevel() == VipLevelEnum.SILVER){
    		approvalManagerRequest.setApprovalType(ApprovalTypeEnum.SILVER_TO_GOLD);
    	}else if(user.getVipLevel() == VipLevelEnum.GOLD){
    		approvalManagerRequest.setApprovalType(ApprovalTypeEnum.GOLD_TO_FAMILY);
    	}
    	
    	approvalManagerRequest.getApprovalDto().setCreaterId(user.getUserId());
    	//approvalManagerRequest.getApprovalDto().setUpdaterId(user.getUserId());
    	approvalManagerRequest.getApprovalDto().setCreateTime(DateUtil.getCurrentDateByFormat(DateUtil.YYMMDDHHMMSS));
    	//approvalManagerRequest.getApprovalDto().setUpdateTime(DateUtil.getCurrentDateByFormat(DateUtil.YYMMDDHHMMSS));
    }
    
    //update默认属性
    public static void setDefaultUpdateFields(ApprovalManagerRequest approvalManagerRequest,HttpServletRequest request, HttpServletResponse response){
    	UserInfoDto user = (UserInfoDto) ServletUtil.getSession(request, response, ConstantUtil.USER_SESSION_KEY);
    	approvalManagerRequest.getApprovalDto().setUpdaterId(user.getUserId());
    	approvalManagerRequest.getApprovalDto().setUpdateTime(DateUtil.getCurrentDateByFormat(DateUtil.YYMMDDHHMMSS));
    	approvalManagerRequest.getApprovalDto().setApproverId(user.getUserId());
    }

	public static void setDefaultUpdateFields(DictionaryDto queryConditon,HttpServletRequest request, HttpServletResponse response) {
		UserInfoDto user = (UserInfoDto) ServletUtil.getSession(request, response, ConstantUtil.USER_SESSION_KEY);
		queryConditon.setCreaterId(user.getUserId());
		queryConditon.setCreateTime(DateUtil.getCurrentDateByFormat(DateUtil.YYMMDDHHMMSS));
		
	}
}
