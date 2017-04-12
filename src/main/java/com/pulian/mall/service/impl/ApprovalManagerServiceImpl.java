package com.pulian.mall.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.pulian.mall.dto.ApprovalDto;
import com.pulian.mall.dto.ApprovalTypeEnum;
import com.pulian.mall.dto.AreasEnum;
import com.pulian.mall.dto.DictionaryDto;
import com.pulian.mall.dto.DictionaryValueTypeEnum;
import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.dto.VipLevelEnum;
import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.persist.mapper.ApprovalMapper;
import com.pulian.mall.request.ApprovalManagerRequest;
import com.pulian.mall.request.BaseResult;
import com.pulian.mall.request.BaseResultT;
import com.pulian.mall.request.UserManagerRequest;
import com.pulian.mall.util.CodeUtil;
import com.pulian.mall.util.ConstantUtil;
import com.pulian.mall.util.DataTablesPagination;
import com.pulian.mall.util.DateUtil;
import com.pulian.mall.util.FirstLetterUtil;
import com.pulian.mall.util.JqGridPagination;
import com.pulian.mall.util.UserDefaultFieldUtil;
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
	
	public BaseResultT<ApprovalDto> queryApprovalList(ApprovalManagerRequest approvalManagerRequest){
		BaseResultT<ApprovalDto> baseResultT= new BaseResultT<ApprovalDto>();
		try{
			List<ApprovalDto> approvalList = approvalMapper.queryApprovalList(approvalManagerRequest);
			int count = approvalMapper.count(approvalManagerRequest);
			
			DataTablesPagination pagination = approvalManagerRequest.getPagination();
			pagination.setTotalCount(count);
			baseResultT.setResults(approvalList);
			baseResultT.setPagination(pagination);
		}catch(Exception e){
			log.error("ApprovalManagerServiceImpl.queryApprovalList",e);
			baseResultT.setSuccessStatus(YesOrNoEnum.NO);
		}
		
		return baseResultT;
	}
	
    public BaseResult saveApprovalDto(ApprovalManagerRequest approvalManagerRequest){
    	BaseResult baseResult = new BaseResult();
    	try{
    		boolean repeat = validateRepeat(approvalManagerRequest);
    		if(!repeat){
    			approvalMapper.saveApprovalDto(approvalManagerRequest.getApprovalDto());
    		}else{
    			baseResult.setSuccessStatus(YesOrNoEnum.NO);
    			baseResult.setMessage(ConstantUtil.APPROVAL_REPEAT);
    		}
    		
		}catch(Exception e){
			log.error("ApprovalManagerServiceImpl.saveApprovalDto",e);
			baseResult.setSuccessStatus(YesOrNoEnum.NO);
			baseResult.setMessage(ConstantUtil.APPROVAL_SILVER_TO_GOLD_ERROR);
		}
    	
		return baseResult;
	}
    
    private boolean validateRepeat(ApprovalManagerRequest approvalManagerRequest) {
    	ApprovalManagerRequest queryRequest = new ApprovalManagerRequest();
    	queryRequest.setApplicantId(approvalManagerRequest.getApplicantId());
    	queryRequest.setApprovalType(ApprovalTypeEnum.SILVER_TO_GOLD);
    	List<ApprovalDto> approvalList = approvalMapper.queryApprovalList(queryRequest);
    	
		return approvalList.size()>0;
	}

	@Transactional
    public BaseResultT<UserInfoDto> updateApprovalDtoByApprovalId(ApprovalManagerRequest approvalManagerRequest,HttpServletRequest request, HttpServletResponse response){
    	BaseResultT<UserInfoDto> baseResultT = new BaseResultT<UserInfoDto>();
    	try{
    		ApprovalDto approvalDto = approvalManagerRequest.getApprovalDto();
    		int updateCount = approvalMapper.updateApprovalDtoByApprovalId(approvalDto);
    		//银升金审批成功，新增一个金卡权限给申请人
    		if(approvalDto.getApprovalResult() == YesOrNoEnum.YES && updateCount>0){
    		  UserInfoDto newUser= addNewGoldCard(approvalDto, request,  response);
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
		userManagerRequest.setUserId(approvalDto.getApplicantId());
		userManagerService.updateUserByUserId(userManagerRequest);
	}

	private UserInfoDto addNewGoldCard(ApprovalDto approvalDto,HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//查询银卡用户信息
		UserManagerRequest userManagerRequest = new UserManagerRequest();
		userManagerRequest.setUserId(approvalDto.getApplicantId());
		BaseResultT<UserInfoDto> resultT = userManagerService.queryUserInfo(userManagerRequest);
		
		//不考虑查询不到的情况
		UserInfoDto userInfoDto  = resultT.getResults().get(0);
		
		//在所属大区下生成一个未使用过的code
		String newCode = getUnUsedUserCode(userInfoDto.getUserArea(), request,  response);
		String newAccount = FirstLetterUtil.getFirstLetter(userInfoDto.getUserName())+"_"+newCode;
		userInfoDto.setUserCode(newCode);
		userInfoDto.setUserAccount(newAccount);
		userInfoDto.setVipLevel(VipLevelEnum.GOLD_E);
		userManagerRequest.setUserInfoDto(userInfoDto);
		userManagerService.saveUserInfo(userManagerRequest);
		
		return userInfoDto;
	}

	private String getUnUsedUserCode(AreasEnum userArea,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String newCode = userArea.name()+CodeUtil.getRandomFourDigits();
		
		//查询是否已经存在
		DictionaryDto queryConditon  = new DictionaryDto();
		queryConditon.setValueType(DictionaryValueTypeEnum.USERCODE);
		queryConditon.setValue(newCode);
		BaseResultT<DictionaryDto> resultDics = dictionaryManagerService.queryDictionaryList(queryConditon);
		List<DictionaryDto> list = resultDics.getResults();
		
		//之前没用过，将新code插入字典，并返回使用
		if(resultDics.getSuccessStatus()==YesOrNoEnum.NO){
			throw new Exception(ConstantUtil.DIC_QUERY_ERROR);
		}
		if(CollectionUtils.isEmpty(list)){
			UserDefaultFieldUtil.setDefaultUpdateFields(queryConditon, request, response);
			dictionaryManagerService.saveDictionaryDto(queryConditon);
			return newCode;
			
		}else{
			
			getUnUsedUserCode(userArea, request, response);
		}
		
		return newCode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
