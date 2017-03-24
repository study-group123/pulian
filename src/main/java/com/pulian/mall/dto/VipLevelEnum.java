package com.pulian.mall.dto;


public enum VipLevelEnum {
   SYSTEM("系统管理员",VipLevelEnum.SYSTEM_VALUE),
   FAMILY("家族",VipLevelEnum.FAMILY_VALUE),
   GOLD_A("金卡A",VipLevelEnum.GOLD_A_VALUE),
   GOLD_B("金卡B",VipLevelEnum.GOLD_B_VALUE),
   GOLD_C("金卡C",VipLevelEnum.GOLD_C_VALUE),
   GOLD_D("金卡D",VipLevelEnum.GOLD_D_VALUE),
   GOLD_E("金卡E",VipLevelEnum.GOLD_E_VALUE),
   SILVER("银卡",VipLevelEnum.SILVER_VALUE);
  
   public static final int SYSTEM_VALUE = 1000;
   
   public static final int FAMILY_VALUE = 500;
  
   public static final int GOLD_A_VALUE = 100;
   
   public static final int GOLD_B_VALUE = 99;
  
   public static final int GOLD_C_VALUE = 98;
  
   public static final int GOLD_D_VALUE = 97;
  
   public static final int GOLD_E_VALUE = 96;
  
   public static final int SILVER_VALUE = 50;
   
   private String cnName;
   
   private int value;
   
   private VipLevelEnum(String cnName,int value){
	   this.cnName = cnName;
   }

	public String getCnName() {
		return cnName;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

   
}
