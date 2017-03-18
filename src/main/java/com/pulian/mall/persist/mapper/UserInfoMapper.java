package com.pulian.mall.persist.mapper;

import java.util.List;

import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.request.BaseResult;
import com.pulian.mall.request.UserManagerRequest;

public interface UserInfoMapper {
	

	 List<UserInfoDto> queryUserInfo(UserManagerRequest userManagerRequest);
	
     BaseResult saveUserInfo(UserManagerRequest userManagerRequest);
    
     BaseResult updateUserInfo(UserManagerRequest userManagerRequest);

	int count(UserManagerRequest userManagerRequest);


}
