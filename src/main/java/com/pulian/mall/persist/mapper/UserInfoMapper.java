package com.pulian.mall.persist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.request.BaseResult;
import com.pulian.mall.request.UserManagerRequest;

public interface UserInfoMapper {
	

	 List<UserInfoDto> queryUserInfo(@Param("condition")UserManagerRequest userManagerRequest);
	
     BaseResult saveUserInfo(@Param("condition")UserManagerRequest userManagerRequest);
    
     BaseResult updateUserInfo(@Param("condition")UserManagerRequest userManagerRequest);

	int count(@Param("condition")UserManagerRequest userManagerRequest);


}
