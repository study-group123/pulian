package com.pulian.mall.controller.impl;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.request.BaseResultT;
import com.pulian.mall.request.UserManagerRequest;
import com.pulian.mall.service.impl.UserManagerServiceImpl;
import com.pulian.mall.util.MD5util;

@Controller
@RequestMapping("/login")
public class LoginControllerImpl {

	@Autowired
	private UserManagerServiceImpl userManagerService;
	
	private static final Log log = LogFactory.getLog(LoginControllerImpl.class);
	/**
	 * 进入主页
	 */
	@RequestMapping("/toUserLogin")
	public String toUserLogin(Model model,HttpServletRequest request, HttpServletResponse response) {
		
		
		return "user_login";
	}
	
	@RequestMapping("/userLogin")
	@ResponseBody
	public BaseResultT<UserInfoDto> userLogin(Model model,UserManagerRequest userManagerRequest,HttpServletRequest request,HttpServletResponse response) {
		
		BaseResultT<UserInfoDto> baseResultT = new BaseResultT<UserInfoDto>();
		String code = userManagerRequest.getUserInfoDto().getUserCode();
		//String account = userManagerRequest.getUserInfoDto().getUserAccount();
		String pwd = userManagerRequest.getUserInfoDto().getPassWord();
		if(StringUtils.isEmpty(code) || StringUtils.isEmpty(pwd)){
			baseResultT.setSuccessStatus(YesOrNoEnum.NO);
			log.error("请填写用户名和密码");
			return baseResultT;
		}
		buildQueryUserRequest(userManagerRequest);
		List<UserInfoDto> result = userManagerService.queryUserInfo(userManagerRequest);
		if(!CollectionUtils.isEmpty(result)){
			baseResultT.setResult(result.get(0));
		}else{
			baseResultT.setSuccessStatus(YesOrNoEnum.NO);
			baseResultT.setMessage("用户名或者密码错误");
		}
		return baseResultT;
	}
	
	
  private void buildQueryUserRequest(UserManagerRequest request) {
	  request.setPassWord(MD5util.encoderPwdByMd5(request.getPassWord()));
		
   }

  @RequestMapping(value="/testIndex",method=RequestMethod.GET)     
  public String getFirstPage(Model model) {    
      model.addAttribute("name", "王大锤");
	  return "index";
  }  
	
}

