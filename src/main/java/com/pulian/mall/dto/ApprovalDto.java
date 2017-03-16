package com.pulian.mall.dto;

import com.pulian.mall.util.YesOrNoEnum;

public class ApprovalDto extends BaseDto{
	
       private Long applicantId;//申请人
       
       private String reason;//理由
       
       private String beforeThirtyAchievement;//前三十天业绩，申请之前的30天
       
       private Long approverId;//审批人id
       
       private YesOrNoEnum result;//审批结果
       
}
