package com.pulian.mall.util;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;


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
