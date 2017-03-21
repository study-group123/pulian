package com.pulian.mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pulian.mall.dto.ApprovalDto;
import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.persist.mapper.ApprovalMapper;
import com.pulian.mall.request.ApprovalManagerRequest;
import com.pulian.mall.request.BaseResult;
import com.pulian.mall.request.BaseResultT;
import com.pulian.mall.request.UserManagerRequest;

@Service
public class ApprovalManagerServiceImpl {

	@Autowired
	private ApprovalMapper approvalMapper;
	
	@Autowired
	private UserManagerServiceImpl userManagerService;
	
	private static final Log log = LogFactory.getLog(ApprovalManagerServiceImpl.class);
	
	public List<ApprovalDto> queryApprovalList(ApprovalManagerRequest approvalManagerRequest){
		List<ApprovalDto> approvalList = new ArrayList<ApprovalDto>();
		try{
			approvalList = approvalMapper.queryApprovalList(approvalManagerRequest.getApprovalDto());
		}catch(Exception e){
			log.error("ApprovalManagerServiceImpl.queryApprovalList",e);
		}
		
		return approvalList;
	}
	
    public BaseResult saveApprovalDto(ApprovalManagerRequest approvalManagerRequest){
    	BaseResult baseResult = new BaseResult();
    	try{
    		approvalMapper.saveApprovalDto(approvalManagerRequest.getApprovalDto());
		}catch(Exception e){
			log.error("ApprovalManagerServiceImpl.saveApprovalDto",e);
			baseResult.setSuccessStatus(YesOrNoEnum.NO);
		}
    	
		return baseResult;
	}
    
    public BaseResultT<UserInfoDto> updateApprovalDtoByApprovalId(ApprovalManagerRequest approvalManagerRequest){
    	BaseResultT<UserInfoDto> baseResultT = new BaseResultT<UserInfoDto>();
    	try{
    		ApprovalDto approvalDto = approvalManagerRequest.getApprovalDto();
    		approvalMapper.updateApprovalDtoByApprovalId(approvalDto);
    		//银升金审批成功，新增一个金卡权限给申请人
    		if(approvalDto.getApprovalResult() == YesOrNoEnum.YES){
    		  UserInfoDto newUser= addNewGoldCard(approvalDto);
    		  baseResultT.setResult(newUser);
    		}
		}catch(Exception e){
			log.error("ApprovalManagerServiceImpl.updateApprovalDtoByApprovalId",e);
			baseResultT.setSuccessStatus(YesOrNoEnum.NO);
		}
    	
		return baseResultT;
	}

	private UserInfoDto addNewGoldCard(ApprovalDto approvalDto) {
		
		//查询银卡用户信息
		UserManagerRequest userManagerRequest = new UserManagerRequest();
		userManagerRequest.setUserId(approvalDto.getApplicantId());
		List<UserInfoDto> userList = userManagerService.queryUserInfo(userManagerRequest);
		//不考虑查询不到的情况
		UserInfoDto userInfoDto  = userList.get(0);
		userInfoDto.seta
		
		return userInfoDto;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
