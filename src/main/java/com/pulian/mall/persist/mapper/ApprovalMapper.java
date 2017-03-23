package com.pulian.mall.persist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pulian.mall.dto.ApprovalDto;
import com.pulian.mall.request.ApprovalManagerRequest;

public interface ApprovalMapper {
	

	 List<ApprovalDto> queryApprovalList(@Param("condition")ApprovalManagerRequest approvalManagerRequest);
	
     int saveApprovalDto(@Param("condition")ApprovalDto approvalDto);
    
     int updateApprovalDtoByApprovalId(@Param("condition")ApprovalDto approvalDto);

	 int count(@Param("condition")ApprovalDto approvalDto);


}
