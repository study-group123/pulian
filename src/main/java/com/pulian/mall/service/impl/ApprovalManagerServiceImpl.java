package com.pulian.mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pulian.mall.dto.ApprovalDto;
import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.persist.mapper.ApprovalMapper;
import com.pulian.mall.request.ApprovalManagerRequest;
import com.pulian.mall.request.BaseResult;

@Service
public class ApprovalManagerServiceImpl {

	@Autowired
	private ApprovalMapper ApprovalMapper;
	
	private static final Log log = LogFactory.getLog(ApprovalManagerServiceImpl.class);
	
	public List<ApprovalDto> queryApprovalList(ApprovalManagerRequest approvalManagerRequest){
		List<ApprovalDto> approvalList = new ArrayList<ApprovalDto>();
		try{
			approvalList = ApprovalMapper.queryApprovalList(approvalManagerRequest.getApprovalDto());
		}catch(Exception e){
			log.error("ApprovalManagerServiceImpl.queryApprovalList",e);
		}
		
		return approvalList;
	}
	
    public BaseResult saveApprovalDto(ApprovalManagerRequest approvalManagerRequest){
    	BaseResult baseResult = new BaseResult();
    	try{
    		ApprovalMapper.saveApprovalDto(approvalManagerRequest.getApprovalDto());
		}catch(Exception e){
			log.error("ApprovalManagerServiceImpl.saveApprovalDto",e);
			baseResult.setSuccessStatus(YesOrNoEnum.NO);
		}
    	
		return baseResult;
	}
    
    public BaseResult updateApprovalDtoByApprovalId(ApprovalManagerRequest approvalManagerRequest){
    	BaseResult baseResult = new BaseResult();
    	try{
    		ApprovalMapper.updateApprovalDtoByApprovalId(approvalManagerRequest.getApprovalDto());
		}catch(Exception e){
			log.error("ApprovalManagerServiceImpl.updateApprovalDtoByApprovalId",e);
			baseResult.setSuccessStatus(YesOrNoEnum.NO);
		}
    	
		return baseResult;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
