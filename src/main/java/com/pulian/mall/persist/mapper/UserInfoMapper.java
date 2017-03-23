package com.pulian.mall.persist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pulian.mall.dto.UserInfoDto;

public interface UserInfoMapper {
	

	 List<UserInfoDto> queryUserInfo(@Param("condition")UserInfoDto userInfoDto);
	
     int saveUserInfo(@Param("condition")UserInfoDto userInfoDto);
    
     int updateUserByUserId(@Param("condition")UserInfoDto userInfoDto);

	 int count(@Param("condition")UserInfoDto userInfoDto);


}
