package com.pulian.mall.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtil {
    public static final String YYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    
    public static final String YYMMDD = "yyyy-MM-dd";
    
    private static final Log log = LogFactory.getLog(DateUtil.class);
    
	public static Date getCurrentDateByFormat(String pattern){
		Date result = new Date();
		try{
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			String dateStr= formatter.format(new Date());
			result = formatter.parse(dateStr);
		}catch(Exception e){
			log.error("DateUtils.getCurrentDateByFormat", e);
		}
		
		return result;
	}
}
