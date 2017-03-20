package com.pulian.mall.request;

import com.pulian.mall.dto.ApprovalDto;
import com.pulian.mall.dto.YesOrNoEnum;
public class ApprovalManagerRequest {

	
    private ApprovalDto approvalDto = new ApprovalDto();

	public ApprovalDto getApprovalDto() {
		return approvalDto;
	}

	public void setApprovalDto(ApprovalDto approvalDto) {
		this.approvalDto = approvalDto;
	}
    
	public int getApprovalId() {
		return this.approvalDto.getApplicantId();
	}

	public void setApprovalId(int approvalId) {
		this.approvalDto.setApprovalId(approvalId);
	}

	public int getApplicantId() {
		return this.approvalDto.getApplicantId();
	}

	public void setApplicantId(int applicantId) {
		this.approvalDto.setApplicantId(applicantId);
	}

	public String getApprovalReason() {
		return this.approvalDto.getApprovalReason();
	}

	public void setApprovalReason(String approvalReason) {
		this.approvalDto.setApprovalReason(approvalReason);
	}

	public String getBeforeThirtyAchievement() {
		return this.approvalDto.getBeforeThirtyAchievement();
	}

	public void setBeforeThirtyAchievement(String beforeThirtyAchievement) {
		this.approvalDto.setBeforeThirtyAchievement(beforeThirtyAchievement);
	}

	public int getApproverId() {
		return this.approvalDto.getApproverId();
	}

	public void setApproverId(int approverId) {
		this.approvalDto.setApproverId(approverId);
	}

	public YesOrNoEnum getApprovalResult() {
		return this.approvalDto.getApprovalResult();
	}

	public void setApprovalResult(YesOrNoEnum approvalResult) {
		this.approvalDto.getApprovalResult();
	}

	public String getApprovalResultDesc() {
		return this.approvalDto.getApprovalResultDesc();
	}

	public void setApprovalResultDesc(String approvalResultDesc) {
		this.approvalDto.setApprovalResultDesc(approvalResultDesc);
	}
}
