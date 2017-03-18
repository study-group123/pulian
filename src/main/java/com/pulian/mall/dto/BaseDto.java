package com.pulian.mall.dto;

import java.io.Serializable;
import java.util.Date;

public class BaseDto implements Serializable{
	

	private static final long serialVersionUID = 4454480313380701807L;

	 
	 private Date createTime;
	 
	 private Date updateTime;
	 
	 private Long createrId;
	 
	 private Long updaterId;
}
