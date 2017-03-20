package com.pulian.mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		List<UserInfoDto> userList = new ArrayList<UserInfoDto>();
		try{
			userList = userInfoMapper.queryUserInfo(userManagerRequest.getUserInfoDto());
		}catch(Exception e){
			log.error("UserManagerServiceImpl.queryUserInfo",e);
		}
		
		return userList;
	}
	
    public BaseResult saveUserInfo(UserManagerRequest userManagerRequest){
    	BaseResult baseResult = new BaseResult();
    	try{
    		userInfoMapper.saveUserInfo(userManagerRequest.getUserInfoDto());
		}catch(Exception e){
			log.error("UserManagerServiceImpl.saveUserInfo",e);
			baseResult.setSuccessStatus(YesOrNoEnum.NO);
		}
    	
		return baseResult;
	}
    
    public BaseResult updateUserByUserId(UserManagerRequest userManagerRequest){
    	BaseResult baseResult = new BaseResult();
    	try{
    		userInfoMapper.updateUserByUserId(userManagerRequest.getUserInfoDto());
		}catch(Exception e){
			log.error("UserManagerServiceImpl.updateUserInfo",e);
			baseResult.setSuccessStatus(YesOrNoEnum.NO);
		}
    	
		return baseResult;
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
		return userInfoMapper.count(queryRequest.getUserInfoDto());
	}

}
