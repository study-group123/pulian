package com.pulian.mall.request;

import java.util.ArrayList;
import java.util.List;

import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.util.DataTablesPagination;

public class  BaseResultT<T> {

	private YesOrNoEnum successStatus = YesOrNoEnum.YES;
	
	private String message;
	
	private T result;
	
	private List<T> results = new ArrayList<T>();
	
	private int count;

	private DataTablesPagination pagination = new DataTablesPagination();

	public BaseResultT(DataTablesPagination pagination, List<T> results) {
		this.pagination = pagination;
		this.results = results;

	}
	public BaseResultT() {
	}
	
	public YesOrNoEnum getSuccessStatus() {
		return successStatus;
	}

	public void setSuccessStatus(YesOrNoEnum successStatus) {
		this.successStatus = successStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
	
	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	
	
	public DataTablesPagination getPagination() {
		return pagination;
	}
	public void setPagination(DataTablesPagination pagination) {
		this.pagination = pagination;
	}
	public Boolean isHasResults() {
		return getResults() != null ? true : false;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	
}
