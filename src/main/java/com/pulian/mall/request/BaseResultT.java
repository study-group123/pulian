package com.pulian.mall.request;

import java.util.ArrayList;
import java.util.List;

import com.pulian.mall.dto.YesOrNoEnum;
import com.pulian.mall.util.Pagination;

public class  BaseResultT<T> {

	private YesOrNoEnum successStatus = YesOrNoEnum.YES;
	
	private String message;
	
	private T result;
	
	private List<T> results = new ArrayList<T>();

	private Pagination pagination = new Pagination();

	public BaseResultT(Pagination pagination, List<T> results) {
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

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
	public int getPage() {
		return pagination.getPage();
	}
	
	public int getRows() {
		return pagination.getRows();
	}
	
	public int getRecords() {
		return pagination.getRecords();
	}
	
	public int getTotal() {
		return pagination.getTotal();
	}
	
	public String getSidx() {
		return pagination.getSidx();
	}
	
	public String getSord() {
		return pagination.getSord();
	}
	
	public Boolean isHasResults() {
		return getResults() != null ? true : false;
	}

	
}
