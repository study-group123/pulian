package com.pulian.mall.util;

import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.request.UserManagerRequest;

public class UserDefaultFieldUtil {

	public static final String DEFAULT_PWD = "666666";
	
	public static YesOrNoEnum DEFAULT_FROZEN_STATUS = YesOrNoEnum.NO;
	
	public static YesOrNoEnum DEFAULT_ACTIVE_STATUS = YesOrNoEnum.YES;
	
	public static YesOrNoEnum DEFAULT_DISABLED = YesOrNoEnum.NO;
	
    public static  String generateDefaultPwd(){
    	
    	return MD5util.encoderPwdByMd5(DEFAULT_PWD);
    }
    
    public static void setUserDefaultFields(UserManagerRequest userManagerRequest){
    	userManagerRequest.setActiveStatus(DEFAULT_ACTIVE_STATUS);
    	userManagerRequest.setFrozenStatus(DEFAULT_FROZEN_STATUS);
    	userManagerRequest.setUserDisable(DEFAULT_DISABLED);
    	userManagerRequest.setPassWord(generateDefaultPwd());
    	userManagerRequest.setCreateTime(DateUtil.getCurrentDateByFormat(DateUtil.YYMMDDHHMMSS));
    	userManagerRequest.setUpdateTime(DateUtil.getCurrentDateByFormat(DateUtil.YYMMDDHHMMSS));
    }
}
