package com.jt.web.pojo;

import java.io.Serializable;
import java.util.Date;



public class Cart implements Serializable{
	
	private static final long serialVersionUID = 6785593148688654891L;
	private Long id  ;      
	//同过userId itemId确定用户行为
	private Long userId ;//用户id           
	private Long  itemId ;//商品id                 
	private String  itemTitle;//商品标题                 
	private String  itemImage ; //商品主图                 
	private Long itemPrice ;//价格
	private Integer num  ;  //数量            
	private Date created ; //创建时间
	private Date updated ; //修改
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public Long getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Long itemPrice) {
		this.itemPrice = itemPrice;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", userId=" + userId + ", itemId=" + itemId + ", itemTitle=" + itemTitle
				+ ", itemImage=" + itemImage + ", itemPrice=" + itemPrice + ", num=" + num + ", created=" + created
				+ ", updated=" + updated + "]";
	}
	
	
}
