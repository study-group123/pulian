package com.pulian.mall.persist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pulian.mall.dto.DictionaryDto;

public interface DictionaryMapper {
	

	 List<DictionaryDto> queryDictionaryList(@Param("condition")DictionaryDto dictionaryDto);
	
     int saveDictionaryDto(@Param("condition")DictionaryDto dictionaryDto);
    
     int updateDictionaryDtoByDictionaryId(@Param("condition")DictionaryDto dictionaryDto);

	 int count(@Param("condition")DictionaryDto dictionaryDto);


}
