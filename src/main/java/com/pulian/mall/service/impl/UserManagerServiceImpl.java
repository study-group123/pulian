package com.pulian.mall.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pulian.mall.controller.impl.UserManagerControllerImpl;
import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.persist.mapper.UserInfoMapper;
import com.pulian.mall.request.BaseResult;
import com.pulian.mall.request.UserManagerRequest;

@Service
public class UserManagerServiceImpl {

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	private static final Log log = LogFactory.getLog(UserManagerServiceImpl.class);
	
	public List<UserInfoDto> queryUserInfo(UserManagerRequest userManagerRequest){
		
		
		return null;
	}
	
    public BaseResult saveUserInfo(UserManagerRequest userManagerRequest){
    	BaseResult baseResult = new BaseResult();
    	try{
    		userInfoMapper.saveUserInfo(userManagerRequest);
		}catch(Exception e){
			log.error("UserManagerServiceImpl.saveUserInfo",e);
			baseResult.setSuccessStatus(YesOrNoEnum.NO);
		}
    	
		return baseResult;
	}
    
    public BaseResult updateUserInfo(UserManagerRequest userManagerRequest){
		
    	
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int queryUserByParentIdAndVipLevel(UserManagerRequest request) {
		UserInfoDto queryDto = new UserInfoDto();
		queryDto.setParentId(request.getParentId());
		queryDto.setVipLevel(request.getVipLevel());
		
		UserManagerRequest queryRequest = new UserManagerRequest();
		queryRequest.setUserInfoDto(queryDto);
		userInfoMapper.count(queryRequest);
		return userInfoMapper.count(queryRequest);
	}

}
