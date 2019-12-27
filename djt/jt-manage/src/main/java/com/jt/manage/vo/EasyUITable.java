package com.jt.manage.vo;

import java.io.Serializable;
import java.util.List;

import com.jt.manage.pojo.Item;

//封装商品页面需要这两个参数接收展现的信息 分页查询
public class EasyUITable<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4494024510976571099L;
	private Integer total;//记录总数 给分页的数
	private List<T> rows;//对象信息
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
