package com.pulian.mall.persist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pulian.mall.dto.MenuDto;

public interface MenuMapper {
	

	 List<MenuDto> queryMenuList(@Param("condition")MenuDto menuDto);
	
     int saveMenuDto(@Param("condition")MenuDto menuDto);
    
     int updateMenuDtoByMenuId(@Param("condition")MenuDto menuDto);

	 int count(@Param("condition")MenuDto menuDto);


}
