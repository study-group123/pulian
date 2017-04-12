package com.pulian.mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pulian.mall.dto.DictionaryDto;
import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.persist.mapper.DictionaryMapper;
import com.pulian.mall.request.BaseResult;
import com.pulian.mall.request.BaseResultT;
/**
 *字典相关服务
 * 
 * @author wangxiaoqiang
 * @date 2017-3-21
 */
@Service
public class DictionaryManagerServiceImpl {

	@Autowired
	private DictionaryMapper dictionaryMapper;
	
	private static final Log log = LogFactory.getLog(DictionaryManagerServiceImpl.class);
	
	public BaseResultT<DictionaryDto> queryDictionaryList(DictionaryDto dictionaryDto){
		BaseResultT<DictionaryDto> result = new BaseResultT<DictionaryDto>();
		try{
			List<DictionaryDto> approvalList = dictionaryMapper.queryDictionaryList(dictionaryDto);
			result.setResults(approvalList);
		}catch(Exception e){
			log.error("DictionaryManagerServiceImpl.queryDictionaryList",e);
			result.setSuccessStatus(YesOrNoEnum.NO);
		}
		
		return result;
	}
	
    public BaseResult saveDictionaryDto(DictionaryDto dictionaryDto){
    	BaseResult baseResult = new BaseResult();
    	try{
    		dictionaryMapper.saveDictionaryDto(dictionaryDto);
		}catch(Exception e){
			log.error("DictionaryManagerServiceImpl.saveDictionaryDto",e);
			baseResult.setSuccessStatus(YesOrNoEnum.NO);
		}
    	
		return baseResult;
	}
    
    public BaseResult updateDictionaryDtoByDictionaryId(DictionaryDto dictionaryDto){
    	BaseResult baseResult= new BaseResult();
    	try{
    		
    		dictionaryMapper.updateDictionaryDtoByDictionaryId(dictionaryDto);
    		
		}catch(Exception e){
			log.error("DictionaryManagerServiceImpl.updateDictionaryDtoByDictionaryId",e);
			baseResult.setSuccessStatus(YesOrNoEnum.NO);
		}
    	
		return baseResult;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
