package com.pulian.mall.persist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pulian.mall.dto.ApprovalDto;

public interface ApprovalMapper {
	

	 List<ApprovalDto> queryApprovalList(@Param("condition")ApprovalDto approvalDto);
	
     int saveApprovalDto(@Param("condition")ApprovalDto approvalDto);
    
     int updateApprovalDtoByApprovalId(@Param("condition")ApprovalDto approvalDto);

	 int count(@Param("condition")ApprovalDto approvalDto);


}
