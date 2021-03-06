package com.pulian.mall.request;


import java.util.Date;

import com.pulian.mall.dto.AreasEnum;
import com.pulian.mall.dto.CardTypeEnum;
import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.dto.VipLevelEnum;
import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.util.DataTablesPagination;

public class UserManagerRequest {

    private UserInfoDto userInfoDto = new UserInfoDto();
    
    private DataTablesPagination pagination = new DataTablesPagination();
    
    private String parentCode;
    
    
	public UserInfoDto getUserInfoDto() {
		return userInfoDto;
	}
	
	public void setUserInfoDto(UserInfoDto userInfoDto) {
		this.userInfoDto = userInfoDto;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	
	public int getUserId() {
		return this.userInfoDto.getUserId();
	}

	public void setUserId(int userId) {
		this.userInfoDto.setUserId(userId);
	}

	public String getUserName() {
		return this.userInfoDto.getUserName();
	}

	public void setUserName(String userName) {
		this.userInfoDto.setUserName(userName);
	}

	public String getUserPhone() {
		return this.userInfoDto.getUserPhone();
	}

	public void setUserPhone(String userPhone) {
		this.userInfoDto.setUserPhone(userPhone);
	}

	public String getUserCode() {
		return this.userInfoDto.getUserCode();
	}

	public void setUserCode(String userCode) {
		this.userInfoDto.setUserCode(userCode);;
	}

	public String getUserAccount() {
		return this.userInfoDto.getUserAccount();
	}

	public void setUserAccount(String userAccount) {
		this.userInfoDto.setUserAccount(userAccount);
	}

	public String getPassWord() {
		return this.userInfoDto.getPassWord();
	}

	public void setPassWord(String passWord) {
		this.userInfoDto.setPassWord(passWord);
	}

	public AreasEnum getUserArea() {
		return this.userInfoDto.getUserArea();
	}

	public void setUserArea(AreasEnum userArea) {
		this.userInfoDto.setUserArea(userArea);
	}

	public String getUserAddress() {
		return this.userInfoDto.getUserAddress();
	}

	public void setUserAddress(String userAddress) {
		this.userInfoDto.setUserAddress(userAddress);
	}

	public CardTypeEnum getCardType() {
		return this.userInfoDto.getCardType();
	}

	public void setCardType(CardTypeEnum cardType) {
		this.userInfoDto.setCardType(cardType);
	}

	public String getCardNo() {
		return this.userInfoDto.getCardNo();
	}

	public void setCardNo(String cardNo) {
		this.userInfoDto.setCardNo(cardNo);
	}

	public String getWeChatNo() {
		return this.userInfoDto.getWeChatNo();
	}

	public void setWeChatNo(String weChatNo) {
		this.userInfoDto.setWeChatNo(weChatNo);
	}
	
	public String getUserEmail() {
		return this.userInfoDto.getUserEmail();
	}

	public void setUserEmail(String userEmail) {
		this.userInfoDto.setUserEmail(userEmail);
	}

	public String getSettlementBank() {
		return this.userInfoDto.getSettlementBank();
	}

	public void setSettlementBank(String settlementBank) {
		this.userInfoDto.setSettlementBank(settlementBank);
	}

	public String getBankBranchName() {
		return this.userInfoDto.getBankBranchName();
	}

	public void setBankBranchName(String bankBranchName) {
		this.userInfoDto.setBankBranchName(bankBranchName);
	}

	public String getBankNo() {
		return this.userInfoDto.getBankNo();
	}

	public void setBankNo(String bankNo) {
		this.userInfoDto.setBankNo(bankNo);
	}

	public String getBankSerialNo() {
		return this.userInfoDto.getBankSerialNo();
	}

	public void setBankSerialNo(String bankSerialNo) {
		this.userInfoDto.setBankSerialNo(bankSerialNo);
	}

	public VipLevelEnum getVipLevel() {
		return this.userInfoDto.getVipLevel();
	}

	public void setVipLevel(VipLevelEnum vipLevel) {
		this.userInfoDto.setVipLevel(vipLevel);
	}

	public YesOrNoEnum getFrozenStatus() {
		return this.userInfoDto.getFrozenStatus();
	}

	public void setFrozenStatus(YesOrNoEnum frozenStatus) {
		this.userInfoDto.setFrozenStatus(frozenStatus);
	}

	public YesOrNoEnum getActiveStatus() {
		return this.userInfoDto.getActiveStatus();
	}

	public void setActiveStatus(YesOrNoEnum activeStatus) {
		this.userInfoDto.setActiveStatus(activeStatus);
	}

	public YesOrNoEnum getUserDisable() {
		return this.userInfoDto.getUserDisable();
	}

	public void setUserDisable(YesOrNoEnum userDisable) {
		this.userInfoDto.setUserDisable(userDisable);
	}

	public int getParentId() {
		return this.userInfoDto.getParentId();
	}

	public void setParentId(int parentId) {
		this.userInfoDto.setParentId(parentId);
	}
	 
	public Date getCreateTime() {
		return this.userInfoDto.getCreateTime();
	}

	public void setCreateTime(Date createTime) {
		this.userInfoDto.setCreateTime(createTime);
	}

	public Date getUpdateTime() {
		return this.userInfoDto.getUpdateTime();
	}

	public void setUpdateTime(Date updateTime) {
		this.userInfoDto.setUpdateTime(updateTime);
	}

	public int getCreaterId() {
		return this.userInfoDto.getCreaterId();
	}

	public void setCreaterId(int createrId) {
		this.userInfoDto.setCreaterId(createrId);
	}

	public int getUpdaterId() {
		return this.userInfoDto.getUpdaterId();
	}

	public void setUpdaterId(int updaterId) {
		this.userInfoDto.setUpdaterId(updaterId);
	}
	
	
	
	public DataTablesPagination getPagination() {
		return pagination;
	}


	public void setPagination(DataTablesPagination pagination) {
		this.pagination = pagination;
	}

	public int getStart() {
		return this.pagination.getStart();
	}

	public void setStart(int start) {
		this.pagination.setStart(start);
	}

	public int getLength() {
		return this.pagination.getLength();
	}

	public void setLength(int length) {
		this.pagination.setLength(length);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
