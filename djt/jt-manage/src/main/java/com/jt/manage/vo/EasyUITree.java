package com.jt.manage.vo;

import java.io.Serializable;
//封装新增商品分类的值对象,页面需要这个值对象接收
public class EasyUITree implements Serializable{
	
	private static final long serialVersionUID = -284551348430553389L;
	private Long id; //商品分类id
	private String text;//名字
	private String state;//展开还是关闭 状态值

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
