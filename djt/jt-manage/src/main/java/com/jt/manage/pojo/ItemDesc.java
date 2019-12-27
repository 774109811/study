package com.jt.manage.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

import com.jt.common.po.BasePojo;
//商品详情
@Table(name="tb_item_desc")
public class ItemDesc extends BasePojo {
	@Id  //主键和商品主键一致不用自增
	private Long  itemId ;  //          

	private String  itemDesc ;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}    


}
