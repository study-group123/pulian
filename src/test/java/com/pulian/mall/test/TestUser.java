package com.pulian.mall.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.pulian.mall.controller.impl.UserManagerControllerImpl;
import com.pulian.mall.request.UserManagerRequest;
import com.pulian.mall.util.AreasEnum;
import com.pulian.mall.util.CardTypeEnum;
import com.pulian.mall.util.MD5util;
import com.pulian.mall.util.VipLevelEnum;
import com.pulian.mall.util.YesOrNoEnum;

@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-servlet.xml","classpath:spring-mybatis.xml"})
public class TestUser extends AbstractTestNGSpringContextTests{

	 @Autowired  
	 private UserManagerControllerImpl userManagerControllerImpl;  
	   
	 @Test  
	 public void testSaveUser(){  
		UserManagerRequest request = new UserManagerRequest();
		request.setActiveStatus(YesOrNoEnum.YES);
		request.setBankAddress("银行地址");
		request.setUserName("用户名");
		//request.setUserCode(CodeUtil.getCode(request.getUserArea()));
		request.setBankNo("bankno");
		request.setBankSerialNo("banksno");
		request.setSettlementBank("settlementBank");
		//request.setUserAccount("账号");
		request.setPassWord(MD5util.EncoderPwdByMd5("666666"));
		request.setCardType(CardTypeEnum.ID);
		request.setCardNo("cardno");
		request.setUserPhone("phone");
		request.setParentId(999);
		request.setParentCode("HB4506");
		request.setFrozenStatus(YesOrNoEnum.NO);
		request.setUserDisable(YesOrNoEnum.NO);
		request.setVipLevel(VipLevelEnum.SILVER);
		request.setUserArea(AreasEnum.HB);
		request.setUserAddress("用户地址");
		request.setWeChatNo("wechatno");
		request.setCreateTime(new Date());
		request.setUpdateTime(new Date());
		request.setUpdaterId(10);
		request.setCreaterId(10);
		userManagerControllerImpl.saveUser(request,null,null,null);
	 }  
}
