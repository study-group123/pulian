package com.pulian.mall.controller.impl;

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
import com.pulian.mall.dto.ApprovalTypeEnum;
import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.dto.VipLevelEnum;
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
	public BaseResultT<ApprovalDto> queryApprovalList(@RequestBody ApprovalManagerRequest approvalManagerRequest,HttpServletRequest request, HttpServletResponse response) {
		BaseResultT<ApprovalDto> baseResultT = null;
		try{
			buildQueryApprovalListRequest(approvalManagerRequest);
			baseResultT  = approvalManagerService.queryApprovalList(approvalManagerRequest);
			//add new approvalDto
			UserInfoDto user = (UserInfoDto) ServletUtil.getSession(request, response, ConstantUtil.USER_SESSION_KEY);
			if(user.getVipLevel()==VipLevelEnum.SILVER && baseResultT.getResults().size()==0){
				ApprovalDto approvalDto =  new ApprovalDto();
				approvalDto.setApplicantName(user.getUserName());
				approvalDto.setApplicantPhone(user.getUserPhone());
				approvalDto.setBeforeThirtyAchievement(getBeforeThirtyAchievement());
			}
		}catch(Exception e){
			log.error("ApprovalManagerControllerImpl.queryApprovalList",e);
			baseResultT.setSuccessStatus(YesOrNoEnum.NO);
		}
		
		return baseResultT;
	}
	
	private void buildQueryApprovalListRequest(ApprovalManagerRequest approvalManagerRequest) {
		approvalManagerRequest.setApprovaltype(ApprovalTypeEnum.SILVER_TO_GOLD);
		
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
		
		UserInfoDto user = (UserInfoDto) ServletUtil.getSession(request, response, ConstantUtil.USER_SESSION_KEY);
		model.addAttribute("user", user);
		
		return "/approment/approment_manager";
	}
	
	private void buildSaveApprovalRequest(ApprovalManagerRequest approvalManagerRequest, HttpServletRequest request, HttpServletResponse response) {
	   
		//TODO: 拿到用户前三十天业绩
		approvalManagerRequest.setBeforeThirtyAchievement(getBeforeThirtyAchievement());
		
		UserDefaultFieldUtil.setApprovalDefaultFields(approvalManagerRequest, request, response);
		UserInfoDto user = (UserInfoDto) ServletUtil.getSession(request, response, ConstantUtil.USER_SESSION_KEY);
		approvalManagerRequest.setApplicantId(user.getUserId());
	}

	private String getBeforeThirtyAchievement() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		
		
		
	}

}
