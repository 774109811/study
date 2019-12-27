package com.jt.cart.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;
@Accessors(chain=true)
@TableName("tb_cart")
@Data
public class Cart {
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
}
