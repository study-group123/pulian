package com.pulian.mall.dto;

public enum YesOrNoEnum {
	DEFAULT(""),
	YES("是"),
   NO("否");
   
   private String cnName;
   
   private YesOrNoEnum(String cnName){
	   this.cnName = cnName;
   }

	public String getCnName() {
		return cnName;
	}

   
}
