package com.pulian.mall.dto;

public class ApprovalDto extends BaseDto{
	
	   /**
	 * 
	 */
	private static final long serialVersionUID = 526256216445885459L;

	private int approvalId;//审批表主键
	   
    private int  applicantId;//申请人
   
    private String approvalReason;//理由
   
    private String beforeThirtyAchievement;//前三十天业绩，申请之前的30天
   
    private int approverId;//审批人id
   
    private YesOrNoEnum approvalResult;//审批结果
    
    private String approvalResultDesc;//审批结果描述

	public int getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(int approvalId) {
		this.approvalId = approvalId;
	}

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}


	public String getApprovalReason() {
		return approvalReason;
	}

	public void setApprovalReason(String approvalReason) {
		this.approvalReason = approvalReason;
	}

	public String getBeforeThirtyAchievement() {
		return beforeThirtyAchievement;
	}

	public void setBeforeThirtyAchievement(String beforeThirtyAchievement) {
		this.beforeThirtyAchievement = beforeThirtyAchievement;
	}

	public int getApproverId() {
		return approverId;
	}

	public void setApproverId(int approverId) {
		this.approverId = approverId;
	}

	public YesOrNoEnum getApprovalResult() {
		return approvalResult;
	}

	public void setApprovalResult(YesOrNoEnum approvalResult) {
		this.approvalResult = approvalResult;
	}

	public String getApprovalResultDesc() {
		return approvalResultDesc;
	}

	public void setApprovalResultDesc(String approvalResultDesc) {
		this.approvalResultDesc = approvalResultDesc;
	}

	
}
