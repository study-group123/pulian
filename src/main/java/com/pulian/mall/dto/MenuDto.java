package com.pulian.mall.dto;

public class MenuDto extends BaseDto{

	private static final long serialVersionUID = -6162945417901236272L;
  
	private int menuId;
	
	private VipLevelEnum vipLevel;
	
	private String urlPath;
	
	private int menuLevel;
	
	private int parentId;
	
	private YesOrNoEnum disabled;

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

	public int getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(int menuLevel) {
		this.menuLevel = menuLevel;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	
}
