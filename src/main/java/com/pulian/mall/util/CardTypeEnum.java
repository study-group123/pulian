package com.pulian.mall.util;

public enum CardTypeEnum {
   PASSPORT("护照"),
   ID("身份证");
   private String cnName;
   
   private CardTypeEnum(String cnName){
	   this.cnName = cnName;
   }

	public String getCnName() {
		return cnName;
	}

   
}
