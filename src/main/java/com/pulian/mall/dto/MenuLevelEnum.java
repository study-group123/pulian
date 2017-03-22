package com.pulian.mall.dto;

public enum MenuLevelEnum {
   ONE(1),
   TWO(2),
   THREE(3);
   private int value;
   
   private MenuLevelEnum(int value){
	   this.value = value;
   }

	public int getValue() {
		return value;
	}

   
}
