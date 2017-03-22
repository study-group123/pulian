package com.pulian.mall.dto;

public class MenuDto extends BaseDto{

	private static final long serialVersionUID = -6162945417901236272L;
  
	private int menuId;
	
	private VipLevelEnum vipLevel;
	
	private String urlPath;
	
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
	
	
}
