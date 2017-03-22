package com.pulian.mall.dto;

import java.util.List;

public class MenuDto extends BaseDto{

	private static final long serialVersionUID = -6162945417901236272L;
  
	private int menuId;
	
	private VipLevelEnum vipLevel;
	
	private String urlPath;
	
	private MenuLevelEnum menuLevel;
	
	private int parentId;
	
	private YesOrNoEnum disabled;
	
	////////////////////////////// 上面是数据库属性////////////////////////////////////////////
	
	private MenuDto parentMenu;
	
	private List<MenuDto> sonMenu;

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

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

	public YesOrNoEnum getDisabled() {
		return disabled;
	}

	public void setDisabled(YesOrNoEnum disabled) {
		this.disabled = disabled;
	}

	public MenuLevelEnum getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(MenuLevelEnum menuLevel) {
		this.menuLevel = menuLevel;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
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

	
	
}
