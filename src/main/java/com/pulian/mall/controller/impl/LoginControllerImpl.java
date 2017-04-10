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
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pulian.mall.dto.MenuDto;
import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.dto.VipLevelEnum;
import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.request.BaseResult;
import com.pulian.mall.request.BaseResultT;
import com.pulian.mall.request.UserManagerRequest;
import com.pulian.mall.service.impl.MenuManagerServiceImpl;
import com.pulian.mall.service.impl.UserManagerServiceImpl;
import com.pulian.mall.util.ConstantUtil;
import com.pulian.mall.util.MD5util;
import com.pulian.mall.util.ServletUtil;
/**
 * 
 * @author wangxiaoqiang
 * @date 2017-3-21
 */
@Controller
@RequestMapping("")
public class LoginControllerImpl {

	private static final Log log = LogFactory.getLog(LoginControllerImpl.class);
	
	@Autowired
	private UserManagerServiceImpl userManagerService;
	
	@Autowired
	private MenuManagerServiceImpl menuManagerService;
	
	@RequestMapping(value="/login/toUserLogin",method=RequestMethod.GET)   
	public String toUserLogin(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "/login/login";
	}
	
	@RequestMapping(value="/login/userLogin",method=RequestMethod.POST)  
	@ResponseBody
	public BaseResultT<UserInfoDto> userLogin(Model model,@RequestBody UserManagerRequest userManagerRequest,HttpServletRequest request,HttpServletResponse response) {
		
		BaseResultT<UserInfoDto> baseResultT = new BaseResultT<UserInfoDto>();
		String code = userManagerRequest.getUserInfoDto().getUserCode();
		//String account = userManagerRequest.getUserInfoDto().getUserAccount();
		String pwd = userManagerRequest.getUserInfoDto().getPassWord();
		if(StringUtils.isEmpty(code) || StringUtils.isEmpty(pwd)){
			baseResultT.setSuccessStatus(YesOrNoEnum.NO);
			baseResultT.setMessage(ConstantUtil.EMPTY_PWD_OR_NAME);
			return baseResultT;
		}
		buildQueryUserRequest(userManagerRequest);
		BaseResultT<UserInfoDto> resultT = userManagerService.queryUserInfo(userManagerRequest);
		List<UserInfoDto> userList= resultT.getResults();
		if(!CollectionUtils.isEmpty(userList)){
			baseResultT.setResult(userList.get(0));
			ServletUtil.putSession(request, response, ConstantUtil.USER_SESSION_KEY, userList.get(0));
		}else{
			baseResultT.setSuccessStatus(YesOrNoEnum.NO);
			baseResultT.setMessage(ConstantUtil.ERROR_PWD_OR_NAME);
		}
		
		return baseResultT;
	}
	
	@RequestMapping(value="/login/loginOut",method=RequestMethod.GET)  
	public String loginOut(Model model,HttpServletRequest request,HttpServletResponse response) {
		
		ServletUtil.removeSession(request, response, ConstantUtil.USER_SESSION_KEY);
		
		return "redirect:/login/toUserLogin";
	}

	@RequestMapping("/updatePassWord")
	@ResponseBody
	public BaseResult updatePassWord(@RequestBody UserManagerRequest userManagerRequest,Model model,HttpServletRequest request, HttpServletResponse response) {
		BaseResult baseResult = new BaseResult();
		try{
			//clean user request
			UserManagerRequest searchRequest = buildUpdatePassWordSearchRequest(userManagerRequest);
			
			BaseResultT<UserInfoDto> resultT = userManagerService.queryUserInfo(searchRequest);
			List<UserInfoDto> userList= resultT.getResults();
			if(!CollectionUtils.isEmpty(userList) && userList.size() == 1){
				
				UserManagerRequest commitRequest = buildUpdatePassWordCommitRequest(userList.get(0),userManagerRequest);
				baseResult = userManagerService.updateUserByUserId(commitRequest);
			}else{
				baseResult.setMessage(ConstantUtil.USER_NOT_FOUND);
				baseResult.setSuccessStatus(YesOrNoEnum.NO);
			}
		}catch(Exception e){
			log.error("UserManagerControllerImpl.updatePassWord",e);
			baseResult.setSuccessStatus(YesOrNoEnum.NO);
		}
		
		return baseResult;
	}
	private UserManagerRequest buildUpdatePassWordSearchRequest(UserManagerRequest request) {
		
		UserManagerRequest searchRequest = new UserManagerRequest();
		searchRequest.setBankNo(request.getBankNo());	
		searchRequest.setCardType(request.getCardType());
		searchRequest.setCardNo(request.getCardNo());
		
		return searchRequest;
	}
	
	private UserManagerRequest buildUpdatePassWordCommitRequest(UserInfoDto currentUser,UserManagerRequest userManagerRequest) {
		
		UserManagerRequest commitRequest = new UserManagerRequest();
		commitRequest.setUserId(currentUser.getUserId());
		String newPwd = MD5util.encoderPwdByMd5(userManagerRequest.getPassWord());
		commitRequest.setPassWord(newPwd);
		
		return commitRequest;
	}
	  
	
	  @RequestMapping(value="/index",method={RequestMethod.POST,RequestMethod.GET})     
	  public String toIndex(Model model,HttpServletRequest request,HttpServletResponse response) { 
		  
		  UserInfoDto user = (UserInfoDto) ServletUtil.getSession(request, response, ConstantUtil.USER_SESSION_KEY);
		  List<MenuDto> menuList = new ArrayList<MenuDto>();
		  if(user != null){
				MenuDto menuRequest = new MenuDto();
				menuRequest.setMenuDisabled(YesOrNoEnum.NO);
				menuRequest.setVipLevel(VipLevelEnum.valueOf(user.getVipLevel().getParent()));
				menuList= menuManagerService.getMenuTree(menuRequest);
				
		  }
	      model.addAttribute("menuList", menuList);
		  return "index";
	  }  
	
	
     private void buildQueryUserRequest(UserManagerRequest request) {
	    request.setPassWord(MD5util.encoderPwdByMd5(request.getPassWord()));
		
     }

     //测试方法
     @RequestMapping(value="/testIndex",method=RequestMethod.GET)     
     public String getFirstPage(Model model) {    
         model.addAttribute("name", "王大锤");
	     return "index";
     }  
	
}

