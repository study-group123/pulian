package com.pulian.mall.dto;

public enum MenuLevelEnum {
   ZERO(0),
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
