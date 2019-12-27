package com.jt.manage.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jt.common.po.BasePojo;

@Table(name="tb_item")//关系映射

public class Item extends BasePojo {
	@Id //主键
	@GeneratedValue(strategy=GenerationType.IDENTITY)//主键自增identity
	private Long id; //'商品ID，也是商品编号',
	private String title; //商品标题         
	private String sellPoint; //商品买点信息         
	private Long  price;  //商品价格      1.10 js处理除以100     '单位为：分',
	private Integer  num; //数量                 
	private String  barcode; //条形码            
	private String  image;//图片信息   1.jpg,2.jpg....            varchar(500) '最多5张图片',
	private Long  cid;//商品分类信息               
	private Integer  status;//商品状态    '默认值为1，可选值：1正常，2下架，3删除',
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
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

}
