package com.pulian.mall.dto;

public enum SettlementBankEnum {
   
	BOC("中国银行"),
	CMB("招商银行"),
	ICBC("中国工商银行"),
	CCB("中国建设银行"),
	BCM("交通银行"),
	ABC("中国农业银行"),
	CMBC("中国民生银行"),
	CEB("中国光大银行");
   private String cnName;
   
   private SettlementBankEnum(String cnName){
	   this.cnName = cnName;
   }

	public String getCnName() {
		return cnName;
	}

   
}
