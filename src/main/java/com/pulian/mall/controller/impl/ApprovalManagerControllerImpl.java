package com.pulian.mall.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
import com.pulian.mall.util.AjaxDataTableObj;
import com.pulian.mall.util.ConstantUtil;
import com.pulian.mall.util.DataTablesPagination;
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
	public BaseResult saveApprovalDto( ApprovalManagerRequest approvalManagerRequest,Model model,HttpServletRequest request, HttpServletResponse response) {
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
	public AjaxDataTableObj<ApprovalDto> queryApprovalList( ApprovalManagerRequest approvalManagerRequest,HttpServletRequest request, HttpServletResponse response) {
		BaseResultT<ApprovalDto> baseResultT = null;
		try{
			UserInfoDto user = (UserInfoDto) ServletUtil.getSession(request, response, ConstantUtil.USER_SESSION_KEY);
			
			buildQueryApprovalListRequest(approvalManagerRequest,user);
			baseResultT  = approvalManagerService.queryApprovalList(approvalManagerRequest);
			//add new approvalDto
			
			if(user.getVipLevel()==VipLevelEnum.SILVER && baseResultT.getResults().size()==0 && StringUtils.isEmpty(baseResultT.getMessage())){
				ApprovalDto approvalDto =  new ApprovalDto();
				approvalDto.setApplicantName(user.getUserName());
				approvalDto.setApplicantPhone(user.getUserPhone());
				approvalDto.setApprovalType(ApprovalTypeEnum.SILVER_TO_GOLD);
				approvalDto.setBeforeThirtyAchievement(getBeforeThirtyAchievement());
				List<ApprovalDto> results = new ArrayList<ApprovalDto>();
				results.add(approvalDto);
				baseResultT.setResults(results);
				baseResultT.setPagination(new DataTablesPagination(0,1,1));
			}
			if(user.getVipLevel()==VipLevelEnum.GOLD && baseResultT.getResults().size()==0 && StringUtils.isEmpty(baseResultT.getMessage())){
				ApprovalDto approvalDto =  new ApprovalDto();
				approvalDto.setApplicantName(user.getUserName());
				approvalDto.setApplicantPhone(user.getUserPhone());
				approvalDto.setApprovalType(ApprovalTypeEnum.GOLD_TO_FAMILY);
				approvalDto.setBeforeThirtyAchievement(getBeforeThirtyAchievement());
				List<ApprovalDto> results = new ArrayList<ApprovalDto>();
				results.add(approvalDto);
				baseResultT.setResults(results);
				baseResultT.setPagination(new DataTablesPagination(0,1,1));
			}
		}catch(Exception e){
			log.error("ApprovalManagerControllerImpl.queryApprovalList",e);
			baseResultT.setSuccessStatus(YesOrNoEnum.NO);
		}
		
		return new AjaxDataTableObj<ApprovalDto>(1,baseResultT.getResults(),baseResultT.getPagination());
	}
	
	private void buildQueryApprovalListRequest(ApprovalManagerRequest approvalManagerRequest ,UserInfoDto user) {
		approvalManagerRequest.setApprovalType(ApprovalTypeEnum.SILVER_TO_GOLD);
		approvalManagerRequest.setUserInfo(user);
		
	}

	@RequestMapping(value="/updateApprovalStatus",method=RequestMethod.POST) 
	@ResponseBody
	public BaseResultT<UserInfoDto> updateApprovalStatus(@RequestBody ApprovalManagerRequest approvalManagerRequest,HttpServletRequest request, HttpServletResponse response) {
		BaseResultT<UserInfoDto> baseResultT = new BaseResultT<UserInfoDto>();
		try{
			ApprovalManagerRequest cleanRequest = buildUpdateApprovalStatusRequest(approvalManagerRequest, request,  response);
			baseResultT =  approvalManagerService.updateApprovalDtoByApprovalId(cleanRequest, request,  response);
		}catch(Exception e){
			log.error("ApprovalManagerControllerImpl.updateApprovalStatus",e);
			baseResultT.setSuccessStatus(YesOrNoEnum.NO);
		}
		
		return baseResultT;
	}
	
	private ApprovalManagerRequest buildUpdateApprovalStatusRequest( ApprovalManagerRequest userRequest, HttpServletRequest request, HttpServletResponse response) {
		ApprovalManagerRequest cleanRequest = new ApprovalManagerRequest();
		cleanRequest.setApprovalId(userRequest.getApprovalId());
		cleanRequest.setApprovalResult(userRequest.getApprovalResult());
		cleanRequest.setApprovalResultDesc(userRequest.getApprovalResultDesc());
		cleanRequest.setApplicantId(userRequest.getApplicantId());
		UserDefaultFieldUtil.setDefaultUpdateFields(cleanRequest,  request,  response);
		return cleanRequest;
	}

	@RequestMapping("/toSaveApprovalDto")
	public String toSaveApprovalDto(Model model,HttpServletRequest request, HttpServletResponse response) {
		
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
		approvalManagerRequest.setApprovalResult(YesOrNoEnum.DEFAULT);
	}

	private String getBeforeThirtyAchievement() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		
		
		
	}

}
