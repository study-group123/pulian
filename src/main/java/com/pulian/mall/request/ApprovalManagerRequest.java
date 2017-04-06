package com.pulian.mall.request;

import com.pulian.mall.dto.ApprovalDto;
import com.pulian.mall.dto.ApprovalTypeEnum;
import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.dto.VipLevelEnum;
import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.util.Pagination;
public class ApprovalManagerRequest {

	
    private ApprovalDto approvalDto = new ApprovalDto();
    
    private Pagination pagination = new Pagination();
    
    private UserInfoDto userInfo = new UserInfoDto();
    

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
	
	public ApprovalTypeEnum getApprovalType() {
		return this.approvalDto.getApprovalType();
	}

	public void setApprovalType(ApprovalTypeEnum approvaltype) {
		this.approvalDto.setApprovalType(approvaltype);
	}
	
	public String getApplicantName() {
		return this.approvalDto.getApplicantName();
	}
	
	public void setApplicantName(String applicantName) {
		this.approvalDto.setApplicantName(applicantName);
	}

	public String getApplicantPhone() {
		return this.approvalDto.getApplicantPhone();
	}

	public void setApplicantPhone(String applicantPhone) {
		this.approvalDto.setApplicantPhone(applicantPhone);;
	}

	public String getApproverName() {
		return this.approvalDto.getApproverName();
	}

	public void setApproverName(String approverName) {
		this.approvalDto.setApproverName(approverName);
	}

	public String getApproverPhone() {
		return this.approvalDto.getApproverPhone();
	}

	public void setApproverPhone(String approverPhone) {
		this.approvalDto.setApproverPhone(approverPhone);
	}
	
	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
	
	public void countRecords(int records) {
		pagination.countRecords(records);
	}

	public int getEndRow() {
		return pagination.getEndRow();
	}

	public int getPage() {
		return pagination.getPage();
	}

	public int getRecords() {
		return pagination.getRecords();
	}

	public int getRows() {
		return pagination.getRows();
	}

	public String getSidx() {
		return pagination.getSidx();
	}

	public String getSord() {
		return pagination.getSord();
	}

	public int getStartRow() {
		return pagination.getStartRow();
	}

	public int getTotal() {
		return pagination.getTotal();
	}

	public boolean isSearch() {
		return pagination.isSearch();
	}

	public void setPage(int page) {
		pagination.setPage(page);
	}

	public void setRecords(int records) {
		pagination.setRecords(records);
	}

	public void setRows(int rows) {
		pagination.setRows(rows);
	}

	public void setRowsByCustom(int customRows) {
		pagination.setRowsByCustom(customRows);
	}

	public void setSearch(boolean search) {
		pagination.setSearch(search);
	}

	public void setSidx(String sidx) {
		pagination.setSidx(sidx);
	}

	public void setSord(String sord) {
		pagination.setSord(sord);
	}

	public void setTotal(int total) {
		pagination.setTotal(total);
	}

	public UserInfoDto getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfoDto userInfo) {
		this.userInfo = userInfo;
	}
	
	public int getUserId() {
		return this.userInfo.getUserId();
	}

	public void setUserId(int userId) {
		this.userInfo.setUserId(userId);
	}
	
	public VipLevelEnum getVipLevel() {
		return this.userInfo.getVipLevel();
	}

	public void setVipLevel(VipLevelEnum vipLevel) {
		this.userInfo.setVipLevel(vipLevel);
	}
}
