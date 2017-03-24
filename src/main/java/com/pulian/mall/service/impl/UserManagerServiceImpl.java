package com.pulian.mall.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.persist.mapper.UserInfoMapper;
import com.pulian.mall.request.BaseResult;
import com.pulian.mall.request.BaseResultT;
import com.pulian.mall.request.UserManagerRequest;
import com.pulian.mall.util.Pagination;
/**
 * 
 * @author wangxiaoqiang
 * @date 2017-3-21
 */
@Service
public class UserManagerServiceImpl {

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	private static final Log log = LogFactory.getLog(UserManagerServiceImpl.class);
	
	public BaseResultT<UserInfoDto> queryUserInfo(UserManagerRequest userManagerRequest){
		BaseResultT<UserInfoDto> baseResultT= new BaseResultT<UserInfoDto>();
		try{
			List<UserInfoDto> userList = userInfoMapper.queryUserInfo(userManagerRequest);
			
			int count = userInfoMapper.count(userManagerRequest);
			
			Pagination pagination = userManagerRequest.getPagination();
			pagination.setRecords(count);
			pagination.countRecords(count);			
			baseResultT.setResults(userList);
			baseResultT.setPagination(pagination);
		}catch(Exception e){
			log.error("UserManagerServiceImpl.queryUserInfo",e);
			baseResultT.setSuccessStatus(YesOrNoEnum.NO);
		}
		
		return baseResultT;
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

		UserManagerRequest queryRequest = new UserManagerRequest();
		queryRequest.setParentId(request.getParentId());
		queryRequest.setVipLevel(request.getVipLevel());
		
		return userInfoMapper.count(queryRequest);
	}

}
