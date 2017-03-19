package com.pulian.mall.request;

import com.pulian.mall.util.YesOrNoEnum;

public class  BaseResult{

	private YesOrNoEnum successStatus = YesOrNoEnum.YES;
	
	private String message;

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
	
	
}
