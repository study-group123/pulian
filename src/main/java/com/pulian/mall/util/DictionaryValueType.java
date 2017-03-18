package com.pulian.mall.util;

public enum DictionaryValueType {
   USERCODE("用户code");
   private String cnName;
   
   private DictionaryValueType(String cnName){
	   this.cnName = cnName;
   }

	public String getCnName() {
		return cnName;
	}

   
}
