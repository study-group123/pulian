package com.pulian.mall.util;

public enum AreasEnum {
   HD1("华东大区1"),
   HD2("华东大区2"),
   HB("华北大区"),
   HN("华南大区"),
   XB("西北大区"),
   XN("西南大区"),
   HZ1("华中大区1"),
   HZ2("华中大区2"),
   DB("东北大区"),
   SD("山东大区");
   private String cnName;
   
   private AreasEnum(String cnName){
	   this.cnName = cnName;
   }

	public String getCnName() {
		return cnName;
	}

   
}
