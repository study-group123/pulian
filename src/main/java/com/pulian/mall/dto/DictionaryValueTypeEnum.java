package com.pulian.mall.dto;

public enum DictionaryValueTypeEnum {
   USERCODE("用户code");
   private String cnName;
   
   private DictionaryValueTypeEnum(String cnName){
	   this.cnName = cnName;
   }

	public String getCnName() {
		return cnName;
	}

   
}
