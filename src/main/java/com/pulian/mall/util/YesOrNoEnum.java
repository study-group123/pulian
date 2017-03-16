package com.pulian.mall.util;

public enum YesOrNoEnum {
   YES("是"),
   NP("否");
   
   private String cnName;
   
   private YesOrNoEnum(String cnName){
	   this.cnName = cnName;
   }

	public String getCnName() {
		return cnName;
	}

   
}
