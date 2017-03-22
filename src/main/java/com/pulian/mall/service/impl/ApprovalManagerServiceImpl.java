package com.pulian.mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.pulian.mall.dto.ApprovalDto;
import com.pulian.mall.dto.AreasEnum;
import com.pulian.mall.dto.DictionaryDto;
import com.pulian.mall.dto.DictionaryValueTypeEnum;
import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.persist.mapper.ApprovalMapper;
import com.pulian.mall.request.ApprovalManagerRequest;
import com.pulian.mall.request.BaseResult;
import com.pulian.mall.request.BaseResultT;
import com.pulian.mall.request.UserManagerRequest;
import com.pulian.mall.util.CodeUtil;
import com.pulian.mall.util.DateUtils;
import com.pulian.mall.util.FirstLetterUtil;
/**
 * 
 * @author wangxiaoqiang
 * @date 2017-3-21
 */
@Service
public class ApprovalManagerServiceImpl {

	@Autowired
	private ApprovalMapper approvalMapper;
	
	@Autowired
	private UserManagerServiceImpl userManagerService;
	
	@Autowired
	private DictionaryManagerServiceImpl dictionaryManagerService;
	
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
    
    @Transactional
    public BaseResultT<UserInfoDto> updateApprovalDtoByApprovalId(ApprovalManagerRequest approvalManagerRequest){
    	BaseResultT<UserInfoDto> baseResultT = new BaseResultT<UserInfoDto>();
    	try{
    		ApprovalDto approvalDto = approvalManagerRequest.getApprovalDto();
    		approvalMapper.updateApprovalDtoByApprovalId(approvalDto);
    		//银升金审批成功，新增一个金卡权限给申请人
    		if(approvalDto.getApprovalResult() == YesOrNoEnum.YES){
    		  UserInfoDto newUser= addNewGoldCard(approvalDto);
    		  baseResultT.setResult(newUser);
    		  frozenOlderUser(approvalDto);
    		}
		}catch(Exception e){
			log.error("ApprovalManagerServiceImpl.updateApprovalDtoByApprovalId",e);
			baseResultT.setSuccessStatus(YesOrNoEnum.NO);
		}
    	
		return baseResultT;
	}

	private void frozenOlderUser(ApprovalDto approvalDto) {
		UserManagerRequest userManagerRequest = new UserManagerRequest();
		userManagerRequest.setFrozenStatus(YesOrNoEnum.YES);
		userManagerService.updateUserByUserId(userManagerRequest);
	}

	private UserInfoDto addNewGoldCard(ApprovalDto approvalDto) {
		
		//查询银卡用户信息
		UserManagerRequest userManagerRequest = new UserManagerRequest();
		userManagerRequest.setUserId(approvalDto.getApplicantId());
		List<UserInfoDto> userList = userManagerService.queryUserInfo(userManagerRequest);
		
		//不考虑查询不到的情况
		UserInfoDto userInfoDto  = userList.get(0);
		
		//在所属大区下生成一个未使用过的code
		String newCode = getUnUsedUserCode(userInfoDto.getUserArea());
		String newAccount = FirstLetterUtil.getFirstLetter(userInfoDto.getUserName())+"_"+getUnUsedUserCode(userInfoDto.getUserArea());
		userInfoDto.setUserCode(newCode);
		userInfoDto.setUserAccount(newAccount);
		
		userManagerRequest.setUserInfoDto(userInfoDto);
		userManagerService.saveUserInfo(userManagerRequest);
		
		return userInfoDto;
	}

	private String getUnUsedUserCode(AreasEnum userArea) {
		String newCode = userArea.name()+CodeUtil.getRandomFourDigits();
		
		//查询是否已经存在
		DictionaryDto queryConditon  = new DictionaryDto();
		queryConditon.setValueType(DictionaryValueTypeEnum.USERCODE);
		queryConditon.setValue(newCode);
		List<DictionaryDto> list = dictionaryManagerService.queryDictionaryList(queryConditon);
		
		//之前没用过，将新code插入字典，并返回使用
		if(CollectionUtils.isEmpty(list)){
			
			queryConditon.setCreateTime(DateUtils.getDateByFormat(DateUtils.YYMMDDHHMMSS));
			queryConditon.setUpdateTime(DateUtils.getDateByFormat(DateUtils.YYMMDDHHMMSS));
			dictionaryManagerService.saveDictionaryDto(queryConditon);
			return newCode;
			
		}else{
			
			getUnUsedUserCode(userArea);
		}
		
		return newCode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
