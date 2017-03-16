package com.pulian.mall.dto;

import java.util.List;

import com.pulian.mall.util.AreasEnum;
import com.pulian.mall.util.CardTypeEnum;
import com.pulian.mall.util.VipLevelEnum;
import com.pulian.mall.util.YesOrNoEnum;


public class UserInfoDto extends BaseDto{

	 
	 private String name;//真实姓名
	 
	 private String phone;//电话
	 
	 private String code;//电话
	 
	 private String account;//账号
	 
	 private String passWord;//密码
	 
	 private AreasEnum area;//所属大区
	 
	 private String address;//详细地址
	 
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
	 
	 private YesOrNoEnum disable;//是否销户
	 
	 private Long parentId;//父id
	 
	 private UserInfoDto parent;//父对象
	 
	 private List<UserInfoDto> sons;//直属子

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	
	

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public AreasEnum getArea() {
		return area;
	}

	public void setArea(AreasEnum area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public YesOrNoEnum getDisable() {
		return disable;
	}

	public void setDisable(YesOrNoEnum disable) {
		this.disable = disable;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
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
