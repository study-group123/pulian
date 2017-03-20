package com.pulian.mall.controller.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pulian.mall.dto.ApprovalDto;
import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.request.BaseResult;
import com.pulian.mall.request.BaseResultT;
import com.pulian.mall.request.ApprovalManagerRequest;
import com.pulian.mall.service.impl.ApprovalManagerServiceImpl;

@Controller
@RequestMapping("/approval")
public class ApprovalManagerControllerImpl {

	private static final Log log = LogFactory.getLog(ApprovalManagerControllerImpl.class);
   
	@Autowired
	private ApprovalManagerServiceImpl approvalManagerService;
	
	
	@RequestMapping("/saveApprovalDto")
	@ResponseBody
	public BaseResult saveApprovalDto(ApprovalManagerRequest ApprovalManagerRequest,Model model,HttpServletRequest request, HttpServletResponse response) {
		BaseResult baseResult = new BaseResult();
		try{
			buildSaveApprovalRequest(ApprovalManagerRequest);
			baseResult = approvalManagerService.saveApprovalDto(ApprovalManagerRequest);
		}catch(Exception e){
			log.error("ApprovalManagerControllerImpl.saveApprovalDto",e);
			baseResult.setSuccessStatus(YesOrNoEnum.NO);
		}
		
		return baseResult;
	}
	
	@RequestMapping("/queryApprovalList")
	@ResponseBody
	public BaseResultT<List<ApprovalDto>> queryApprovalList(ApprovalManagerRequest ApprovalManagerRequest,HttpServletRequest request, HttpServletResponse response) {
		BaseResultT<List<ApprovalDto>> baseResultT = new BaseResultT<List<ApprovalDto>>();
		try{
			List<ApprovalDto> approvalList = approvalManagerService.queryApprovalList(ApprovalManagerRequest);
			baseResultT.setResult(approvalList);
		}catch(Exception e){
			log.error("ApprovalManagerControllerImpl.queryApprovalList",e);
			baseResultT.setSuccessStatus(YesOrNoEnum.NO);
		}
		
		return baseResultT;
	}
	
	@RequestMapping("/toSaveApprovalDto")
	public String toSaveApprovalDto(ApprovalManagerRequest ApprovalManagerRequest,Model model,HttpServletRequest request, HttpServletResponse response) {
		
		
		
		return "";
	}
	
	private void buildSaveApprovalRequest(ApprovalManagerRequest request) {
	
		
	}

	public static void main(String[] args) {
		
		
		
	}

}
