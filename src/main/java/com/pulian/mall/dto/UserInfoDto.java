package com.pulian.mall.dto;

import java.util.List;


public class UserInfoDto extends BaseDto{

	 /**
	 * 
	 */
	private static final long serialVersionUID = -4521312738131068246L;

	private int userId;//主键
	 
	 private String userName;//真实姓名
	 
	 private String userPhone;//电话
	 
	 private String userCode;//code
	 
	 private String userAccount;//账号
	 
	 private String passWord;//密码
	 
	 private AreasEnum userArea;//所属大区
	 
	 private String userAddress;//详细地址
	 
	 private CardTypeEnum cardType;//证件类型
	 
	 private String cardNo;//证件号
	 
	 private String weChatNo;//微信号
	 
	 private String settlementBank;//结算银行,别忘了trim
	 
	 private String bankAddress;//银行详细名称
	 
	 private String bankNo;//银行卡号
	 
	 private String bankSerialNo;//联行号
	 
	 private VipLevelEnum vipLevel;//会员等级
	 
	 private YesOrNoEnum frozenStatus;//是否冻结
	 
	 private YesOrNoEnum activeStatus;//是否激活
	 
	 private YesOrNoEnum userDisable;//是否销户
	 
	 private int parentId;//父id
	 ///////////////////////////上面是数据库属性///////////////////////////////////////
	 
	 private int remainingCardsNum;//剩余开卡数
	 
	 private int activeChildren;//已激活人数
	 
	 private int inActiveChildren;//未激活人数
	 
	 private int frozenChildren;//已冻结人数
	 
	 private UserInfoDto parent;//父对象
	 
	 private List<UserInfoDto> sons;//直属子

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public AreasEnum getUserArea() {
		return userArea;
	}

	public void setUserArea(AreasEnum userArea) {
		this.userArea = userArea;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public CardTypeEnum getCardType() {
		return cardType;
	}

	public void setCardType(CardTypeEnum cardType) {
		this.cardType = cardType;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getWeChatNo() {
		return weChatNo;
	}

	public void setWeChatNo(String weChatNo) {
		this.weChatNo = weChatNo;
	}

	public String getSettlementBank() {
		return settlementBank;
	}

	public void setSettlementBank(String settlementBank) {
		this.settlementBank = settlementBank;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getBankSerialNo() {
		return bankSerialNo;
	}

	public void setBankSerialNo(String bankSerialNo) {
		this.bankSerialNo = bankSerialNo;
	}

	public VipLevelEnum getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(VipLevelEnum vipLevel) {
		this.vipLevel = vipLevel;
	}

	public YesOrNoEnum getFrozenStatus() {
		return frozenStatus;
	}

	public void setFrozenStatus(YesOrNoEnum frozenStatus) {
		this.frozenStatus = frozenStatus;
	}

	public YesOrNoEnum getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(YesOrNoEnum activeStatus) {
		this.activeStatus = activeStatus;
	}

	public YesOrNoEnum getUserDisable() {
		return userDisable;
	}

	public void setUserDisable(YesOrNoEnum userDisable) {
		this.userDisable = userDisable;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public UserInfoDto getParent() {
		return parent;
	}

	public void setParent(UserInfoDto parent) {
		this.parent = parent;
	}

	public List<UserInfoDto> getSons() {
		return sons;
	}

	public void setSons(List<UserInfoDto> sons) {
		this.sons = sons;
	}

	 
	 
	 
	 
}
