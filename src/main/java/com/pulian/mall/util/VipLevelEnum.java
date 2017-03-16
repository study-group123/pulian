package com.pulian.mall.util;

public enum VipLevelEnum {
   SYSTEM("系统管理员"),
   FAMILY("家族"),
   GOLD("金卡"),
   SILVER("银卡");
   private String cnName;
   
   private VipLevelEnum(String cnName){
	   this.cnName = cnName;
   }

	public String getCnName() {
		return cnName;
	}

   
}
