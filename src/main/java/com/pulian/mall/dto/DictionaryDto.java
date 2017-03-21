package com.pulian.mall.dto;

public class DictionaryDto extends BaseDto{

	private static final long serialVersionUID = -2650868367809389413L;

	private int dicId;//字典主键
	
	private DictionaryValueTypeEnum valueType;//值类型
	
	private String value;//值

	public DictionaryValueTypeEnum getValueType() {
		return valueType;
	}

	public void setValueType(DictionaryValueTypeEnum valueType) {
		this.valueType = valueType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getDicId() {
		return dicId;
	}

	public void setDicId(int dicId) {
		this.dicId = dicId;
	}
	
	
}
