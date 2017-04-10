package com.pulian.mall.util;

import java.io.Serializable;

/**
 *分页基本信息
 * 
 * @author wangxiaoqiang
 * @date 2017-4-7
 */
public class DataTablesPagination implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int start = 0;
	
	private int length = 10;
	
	private int totalCount;

	public DataTablesPagination() {
    }
	
	public DataTablesPagination(int start, int length,int totalCount) {
		this.setStart(start);
		this.setLength(length);
		this.setTotalCount(totalCount);
    }

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
  
	
}
