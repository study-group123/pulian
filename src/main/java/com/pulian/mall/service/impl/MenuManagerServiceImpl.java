package com.pulian.mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pulian.mall.dto.MenuDto;
import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.persist.mapper.MenuMapper;
import com.pulian.mall.request.BaseResult;
/**
 * 
 * @author wangxiaoqiang
 * @date 2017-3-22
 */
@Service
public class MenuManagerServiceImpl {

	@Autowired
	private MenuMapper menuMapper;
	
	private static final Log log = LogFactory.getLog(MenuManagerServiceImpl.class);
	
	public List<MenuDto> queryDictionaryList(MenuDto menuDto){
		List<MenuDto> menuList = new ArrayList<MenuDto>();
		try{
			menuList = menuMapper.queryMenuList(menuDto);
		}catch(Exception e){
			log.error("MenuManagerServiceImpl.queryDictionaryList",e);
		}
		
		return menuList;
	}
	
    public BaseResult saveMenuDto(MenuDto menuDto){
    	BaseResult baseResult = new BaseResult();
    	try{
    		menuMapper.saveMenuDto(menuDto);
		}catch(Exception e){
			log.error("MenuManagerServiceImpl.saveMenuDto",e);
			baseResult.setSuccessStatus(YesOrNoEnum.NO);
		}
    	
		return baseResult;
	}
    
    public BaseResult updateMenuDtoByMenuId(MenuDto menuDto){
    	BaseResult baseResult= new BaseResult();
    	try{
    		
    		menuMapper.updateMenuDtoByMenuId(menuDto);
    		
		}catch(Exception e){
			log.error("MenuManagerServiceImpl.updateMenuDtoByMenuId",e);
			baseResult.setSuccessStatus(YesOrNoEnum.NO);
		}
    	
		return baseResult;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
