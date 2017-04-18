package com.pulian.mall.dto;
/**
 * 审批类型
 * */
public enum ApprovalTypeEnum {
   SILVER_TO_GOLD("银升金"),
   GOLD_TO_FAMILY("金升家族");
   
   private String cnName;
   
   private ApprovalTypeEnum(String cnName){
	   this.cnName = cnName;
   }

	public String getCnName() {
		return cnName;
	}

   
}
