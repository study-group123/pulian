package com.pulian.mall.request;


import com.pulian.mall.dto.UserInfoDto;
import com.pulian.mall.util.AreasEnum;
import com.pulian.mall.util.CardTypeEnum;
import com.pulian.mall.util.VipLevelEnum;
import com.pulian.mall.util.YesOrNoEnum;

public class UserManagerRequest {

	
    private UserInfoDto userInfoDto = new UserInfoDto();
    
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

	public String getSettlementBank() {
		return this.userInfoDto.getSettlementBank();
	}

	public void setSettlementBank(String settlementBank) {
		this.userInfoDto.setSettlementBank(settlementBank);
	}

	public String getBankAddress() {
		return this.userInfoDto.getBankAddress();
	}

	public void setBankAddress(String bankAddress) {
		this.userInfoDto.setBankAddress(bankAddress);
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
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
