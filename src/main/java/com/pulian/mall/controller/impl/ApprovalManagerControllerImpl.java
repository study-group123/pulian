package com.pulian.mall.controller.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pulian.mall.dto.ApprovalDto;
import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.request.BaseResult;
import com.pulian.mall.request.BaseResultT;
import com.pulian.mall.request.ApprovalManagerRequest;
import com.pulian.mall.service.impl.ApprovalManagerServiceImpl;
import com.pulian.mall.util.ConstantUtil;
import com.pulian.mall.util.ServletUtil;
import com.pulian.mall.util.UserDefaultFieldUtil;
/**
 * 
 * @author wangxiaoqiang
 * @date 2017-3-21
 */
@Controller
@RequestMapping("/approval")
public class ApprovalManagerControllerImpl {

	private static final Log log = LogFactory.getLog(ApprovalManagerControllerImpl.class);
   
	@Autowired
	private ApprovalManagerServiceImpl approvalManagerService;
	
	
	@RequestMapping("/saveApprovalDto")
	@ResponseBody
	public BaseResult saveApprovalDto(@RequestBody ApprovalManagerRequest approvalManagerRequest,Model model,HttpServletRequest request, HttpServletResponse response) {
		BaseResult baseResult = new BaseResult();
		try{
			buildSaveApprovalRequest(approvalManagerRequest,request,response);
			baseResult = approvalManagerService.saveApprovalDto(approvalManagerRequest);
		}catch(Exception e){
			log.error("ApprovalManagerControllerImpl.saveApprovalDto",e);
			baseResult.setSuccessStatus(YesOrNoEnum.NO);
		}
		
		return baseResult;
	}
	
	@RequestMapping("/queryApprovalList")
	@ResponseBody
	public BaseResultT<List<ApprovalDto>> queryApprovalList(@RequestBody ApprovalManagerRequest approvalManagerRequest,HttpServletRequest request, HttpServletResponse response) {
		BaseResultT<List<ApprovalDto>> baseResultT = new BaseResultT<List<ApprovalDto>>();
		try{
			List<ApprovalDto> approvalList = approvalManagerService.queryApprovalList(approvalManagerRequest);
			baseResultT.setResult(approvalList);
		}catch(Exception e){
			log.error("ApprovalManagerControllerImpl.queryApprovalList",e);
			baseResultT.setSuccessStatus(YesOrNoEnum.NO);
		}
		
		return baseResultT;
	}
	
	@RequestMapping("/updateApprovalStatus")
	@ResponseBody
	public BaseResultT<UserInfoDto> updateApprovalStatus(@RequestBody ApprovalManagerRequest approvalManagerRequest,HttpServletRequest request, HttpServletResponse response) {
		BaseResultT<UserInfoDto> baseResultT = new BaseResultT<UserInfoDto>();
		try{
			ApprovalManagerRequest cleanRequest = buildUpdateApprovalStatusRequest(approvalManagerRequest);
			baseResultT =  approvalManagerService.updateApprovalDtoByApprovalId(cleanRequest);
		}catch(Exception e){
			log.error("ApprovalManagerControllerImpl.updateApprovalStatus",e);
			baseResultT.setSuccessStatus(YesOrNoEnum.NO);
		}
		
		return baseResultT;
	}
	
	private ApprovalManagerRequest buildUpdateApprovalStatusRequest(@RequestBody ApprovalManagerRequest userRequest) {
		ApprovalManagerRequest cleanRequest = new ApprovalManagerRequest();
		cleanRequest.setApprovalId(userRequest.getApprovalId());
		cleanRequest.setApprovalResult(userRequest.getApprovalResult());
		cleanRequest.setApprovalResultDesc(userRequest.getApprovalResultDesc());
		return cleanRequest;
	}

	@RequestMapping("/toSaveApprovalDto")
	public String toSaveApprovalDto(@RequestBody ApprovalManagerRequest ApprovalManagerRequest,Model model,HttpServletRequest request, HttpServletResponse response) {
		
		
		
		return "";
	}
	
	private void buildSaveApprovalRequest(ApprovalManagerRequest approvalManagerRequest, HttpServletRequest request, HttpServletResponse response) {
	   
		//TODO: 拿到用户前三十天业绩
		approvalManagerRequest.setBeforeThirtyAchievement("");
		
		UserDefaultFieldUtil.setApprovalDefaultFields(approvalManagerRequest, request, response);
		UserInfoDto user = (UserInfoDto) ServletUtil.getSession(request, response, ConstantUtil.USER_SESSION_KEY);
		approvalManagerRequest.setApplicantId(user.getUserId());
	}

	public static void main(String[] args) {
		
		
		
	}

}
