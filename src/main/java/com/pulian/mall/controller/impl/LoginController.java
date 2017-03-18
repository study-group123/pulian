package com.pulian.mall.controller.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.ModelAndView;

import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.request.UserManagerRequest;
import com.pulian.mall.service.impl.UserManagerServiceImpl;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserManagerServiceImpl userManagerService;
	
	private static final Log log = LogFactory.getLog(LoginController.class);
	/**
	 * 进入主页
	 */
	@RequestMapping("/toUserLogin")
	public String toUserLogin(Model model,HttpServletRequest request, HttpServletResponse response) {
		
		
		return "user_login";
	}
	
	@RequestMapping("/userLogin")
	@ResponseBody
	public Map<String,Object> searchUserLogin(Model model,UserManagerRequest userManagerRequest,HttpServletRequest request,HttpServletResponse response) {
		
		Map<String,Object> resultMap = new HashMap<String ,Object>();
		
		String account = userManagerRequest.getUserInfoDto().getUserAccount();
		String pwd = userManagerRequest.getUserInfoDto().getPassWord();
		if(StringUtils.isEmpty(account) || StringUtils.isEmpty(pwd)){
			resultMap.put("", "请填写用户名和密码");
			log.error("请填写用户名和密码");
			return resultMap;
		}
		
		List<UserInfoDto> result = userManagerService.queryUserInfo(userManagerRequest);
		if(!CollectionUtils.isEmpty(result)){
			resultMap.put("userInfo", result.get(0));
		}else{
			resultMap.put("message", "用户名或者密码错误");
		}
		return resultMap;
	}
	
	
  @RequestMapping(value="/index8888",method=RequestMethod.GET)     
  public String getFirstPage(Model model) {    
      model.addAttribute("name", "王大锤");
	  return "index";
  }  
	
}

