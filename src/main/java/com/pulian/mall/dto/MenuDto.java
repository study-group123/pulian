package com.pulian.mall.dto;

import java.util.ArrayList;
import java.util.List;

public class MenuDto extends BaseDto{

	private static final long serialVersionUID = -6162945417901236272L;
  
	private int menuId;
	
	private String menuCode;
	
	private VipLevelEnum vipLevel;
	
	private String menuPath;
	
	private String menuName;
	
	private MenuLevelEnum menuLevel;
	
	private String parentCode;
	
	private YesOrNoEnum menuDisabled;
	
	////////////////////////////// 上面是数据库属性////////////////////////////////////////////
	
	private MenuDto parentMenu;
	
	private List<MenuDto> sonMenu  = new ArrayList<MenuDto>();

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public VipLevelEnum getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(VipLevelEnum vipLevel) {
		this.vipLevel = vipLevel;
	}

	public MenuLevelEnum getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(MenuLevelEnum menuLevel) {
		this.menuLevel = menuLevel;
	}


	public MenuDto getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(MenuDto parentMenu) {
		this.parentMenu = parentMenu;
	}

	public List<MenuDto> getSonMenu() {
		return sonMenu;
	}

	public void setSonMenu(List<MenuDto> sonMenu) {
		this.sonMenu = sonMenu;
	}
	
	public void addSonMenu(MenuDto sonMenu) {
		this.sonMenu.add(sonMenu);
	}

	public String getMenuPath() {
		return menuPath;
	}

	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public YesOrNoEnum getMenuDisabled() {
		return menuDisabled;
	}

	public void setMenuDisabled(YesOrNoEnum menuDisabled) {
		this.menuDisabled = menuDisabled;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	
	
}
