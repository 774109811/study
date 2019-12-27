package com.pd.pojo;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;

//实体类，数据库对应solr中的数据
//<field title,id,sellPoing,image
public class Item implements Serializable{
	private static final long serialVersionUID = 6080652155237055951L;
	//来之solr中的商品id field
	@Field("id")
	private Long id;
	//商品标题
	@Field("title")
	private String title;
	//商品内容
	@Field("sellPoint")
	private String sellPoint;
	//商品价格
	@Field("price")
	private Long price;
	//商品图片
	@Field("image")
	private String image;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSellPoint() {
		return sellPoint;
	}
	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
