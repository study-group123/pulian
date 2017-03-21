package com.pulian.mall.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtils {
    public static final String YYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    
    
    private static final Log log = LogFactory.getLog(DateUtils.class);
    
	public static Date getDateByFormat(String pattern){
		Date result = new Date();
		try{
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			String dateStr= formatter.format(new Date());
			result = formatter.parse(dateStr);
		}catch(Exception e){
			log.error("DateUtils.getDateByFormat", e);
		}
		
		return result;
	}
}
