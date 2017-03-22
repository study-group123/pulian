package com.pulian.mall.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pulian.mall.dto.MenuDto;
import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.service.impl.MenuManagerServiceImpl;
import com.pulian.mall.util.ConstantUtil;
import com.pulian.mall.util.ServletUtil;

@Component
public class PermissionInterceptor4SpringMVC implements HandlerInterceptor {

	private static final Log log = LogFactory.getLog(PermissionInterceptor4SpringMVC.class);
	
	@Autowired
	private MenuManagerServiceImpl menuManagerService;
	
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		
		String requestUrl = request.getRequestURI();
		
		if(requestUrl.contains("toUserLogin") || requestUrl.contains("login") )
			return true;
		
		UserInfoDto user = (UserInfoDto) ServletUtil.getSession(request, response, ConstantUtil.USER_SESSION_KEY);
		if(user != null){
			MenuDto menuRequest = new MenuDto();
			menuRequest.setDisabled(YesOrNoEnum.NO);
			menuRequest.setVipLevel(user.getVipLevel());
			List<MenuDto> userMenuList= menuManagerService.queryMenuList(menuRequest);
			
			for(MenuDto menu : userMenuList){
				if(menu.getUrlPath().equalsIgnoreCase(requestUrl)){
					return true;
				}
			}
		}else{
			response.sendRedirect("http://www.pulian.com/login/toUserLogin"); 
		}
		 
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		}

	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, 
			Object handler, Exception ex)throws Exception {
		
	}



	
}
