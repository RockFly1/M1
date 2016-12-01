package com.chinvaventure.m.emnus;
/**
 * 删除标记
 * 
 **/

public enum DelFlag {
	
	
	noDelete(1,"未删除"),
	delete(2,"已删除");
	
	private Integer value;
	private String note;
	
	DelFlag(Integer value,String note){
		this.value = value;
		this.note = note;
	}
	
	public Integer getValue() {
		return value;
	}

	public String getNote() {
		return note;
	}
}
