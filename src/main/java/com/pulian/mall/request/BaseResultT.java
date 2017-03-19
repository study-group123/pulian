package com.pulian.mall.request;

import com.pulian.mall.dto.YesOrNoEnum;

public class  BaseResultT<T> {

	private YesOrNoEnum successStatus = YesOrNoEnum.YES;
	
	private String message;
	
	private T result;

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
	
	
}
