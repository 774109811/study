package com.jt.manage.vo;

import java.io.Serializable;
//树
public class EasyUITreeNode implements Serializable{

	private static final long serialVersionUID = -7991761802591712628L;
	private Long id;
	private String text;//显示标题
	private String state;//状态是否关闭

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
