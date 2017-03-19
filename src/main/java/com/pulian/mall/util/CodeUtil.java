package com.pulian.mall.util;

import com.pulian.mall.dto.AreasEnum;

public class CodeUtil {

	//生成四位随机数
	public static int getRandomFourDigits(){
		
		return (int)(Math.random()*(9999-1000+1))+1000;
	}
	//六位递增的字符串
	public static String padedNumberToSixDigits(int num){
		
		String s = "00000"+num; 
		return s.substring(s.length()-6);
	}
	//根据地区生成code
    public static String getCode(AreasEnum areasEnum){
		
		return areasEnum.name()+getRandomFourDigits();
	}
	
	public static void main(String[] agrs){
		System.out.println(padedNumberToSixDigits(1));
		System.out.println(padedNumberToSixDigits(99));
		System.out.println(padedNumberToSixDigits(1000));
	}
}
