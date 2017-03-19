package com.pulian.mall.dto;

import java.io.Serializable;
import java.util.Date;

public class BaseDto implements Serializable{
	

	private static final long serialVersionUID = 4454480313380701807L;

	 
	 private Date createTime;
	 
	 private Date updateTime;
	 
	 private int createrId;
	 
	 private int updaterId;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getCreaterId() {
		return createrId;
	}

	public void setCreaterId(int createrId) {
		this.createrId = createrId;
	}

	public int getUpdaterId() {
		return updaterId;
	}

	public void setUpdaterId(int updaterId) {
		this.updaterId = updaterId;
	}
	 
	 
}
