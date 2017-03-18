package com.pulian.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.persist.mapper.UserInfoMapper;
import com.pulian.mall.request.BaseResult;
import com.pulian.mall.request.UserManagerRequest;

@Service
public class UserManagerServiceImpl {

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	public List<UserInfoDto> queryUserInfo(UserManagerRequest userManagerRequest){
		
		
		return null;
	}
	
    public BaseResult saveUserInfo(UserManagerRequest userManagerRequest){
		
		
		return null;
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
