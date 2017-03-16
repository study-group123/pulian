package com.pulian.mall.request;

import com.pulian.mall.dto.UserInfoDto;

public class UserManagerRequest {

	
    private UserInfoDto userInfoDto;
    
    private int parentId;
    
    private String parentCode;
    
    
	public UserInfoDto getUserInfoDto() {
		return userInfoDto;
	}


	public void setUserInfoDto(UserInfoDto userInfoDto) {
		this.userInfoDto = userInfoDto;
	}


	public int getParentId() {
		return parentId;
	}


	public void setParentId(int parentId) {
		this.parentId = parentId;
	}


	public String getParentCode() {
		return parentCode;
	}


	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
