package com.pulian.mall.util;

import java.security.MessageDigest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Encoder;

public class MD5util {
	private static final Log log = LogFactory.getLog(MD5util.class);
  
    public static  String encoderPwdByMd5(String str) {  
    	
    	String newstr = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();  
	         newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));  
		} catch (Exception e) {
			log.error("加密失败",e);
		}  
        
        return newstr;  
    }  
    
    public static void main(String[] args) {   
        try {  
            System.out.println("64位：result: " + encoderPwdByMd5("12345678") + "**");  
        }catch (Exception e) {  
        	log.error("加密失败",e);
        }  
        
    }
    
    
} 
