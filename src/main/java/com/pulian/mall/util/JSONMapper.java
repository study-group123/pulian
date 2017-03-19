package com.pulian.mall.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

public class JSONMapper {

	private static ObjectMapper mapper = new ObjectMapper();
	static{
		mapper.getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);  
		mapper.getDeserializationConfig()
		.set(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);
	}
	public static ObjectMapper getInstance(){
		return mapper;
	}
}
