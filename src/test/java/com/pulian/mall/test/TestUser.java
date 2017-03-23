package com.pulian.mall.test;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.annotations.Test;

import com.pulian.mall.controller.impl.LoginControllerImpl;
import com.pulian.mall.controller.impl.UserManagerControllerImpl;
import com.pulian.mall.dto.AreasEnum;
import com.pulian.mall.dto.CardTypeEnum;
import com.pulian.mall.dto.VipLevelEnum;
import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.request.UserManagerRequest;
import com.pulian.mall.util.JSONMapper;
import com.pulian.mall.util.MD5util;
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)  
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-servlet.xml","classpath:spring-mybatis.xml"})
public class TestUser extends AbstractTestNGSpringContextTests{

	 private static final Log log = LogFactory.getLog(TestUser.class);
	 
	 @Autowired  
	 private UserManagerControllerImpl userManagerControllerImpl;  
	 @Autowired
	 private LoginControllerImpl   loginControllerImpl;
	 
	 
	 @Rollback(false)
	 @Test  
	 public void testSaveUser(){  
		 UserManagerRequest request = getTestUserManagerRequest();
		
		userManagerControllerImpl.saveUser(request,null,null,null);
	 }  
	 
	 public UserManagerRequest getTestUserManagerRequest(){
		 
		UserManagerRequest request = new UserManagerRequest();
		request.setActiveStatus(YesOrNoEnum.YES);
		request.setBankAddress("银行地址");
		request.setUserName("用户名");
		//request.setUserCode(CodeUtil.getCode(request.getUserArea()));
		request.setBankNo("bankno");
		request.setBankSerialNo("banksno");
		request.setSettlementBank("settlementBank");
		//request.setUserAccount("账号");
		//request.setPassWord(MD5util.encoderPwdByMd5("666666"));
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
		 
		return request;
	 }
	 
	 @Test
	 public void printUserManagerRequestJson(){
		 
		 try {
			System.out.println(JSONMapper.getInstance().writeValueAsString(getTestUserManagerRequest()));
		} catch (Exception e) {
			log.error("", e);
		} 
	 }
	 
	 @Rollback(false)
	 @Test  
	 public void testUserLogin(){  
		UserManagerRequest request = new UserManagerRequest();
		
		request.setUserCode("HB4506000001");
		request.setUserAccount("账号");
		request.setPassWord(MD5util.encoderPwdByMd5("666666"));
		
		loginControllerImpl.userLogin(null, request, null, null);
	 }  
}
