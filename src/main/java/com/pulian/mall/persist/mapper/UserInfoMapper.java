package com.pulian.mall.persist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.request.UserManagerRequest;

public interface UserInfoMapper {
	

	 List<UserInfoDto> queryUserInfo(@Param("condition")UserManagerRequest userManagerRequest);
	
     int saveUserInfo(@Param("condition")UserInfoDto userInfoDto);
    
     int updateUserByUserId(@Param("condition")UserInfoDto userInfoDto);

	 int count(@Param("condition")UserManagerRequest userManagerRequest);


}
