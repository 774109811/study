package com.jt.manage.controller.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.manage.pojo.Item;
import com.jt.manage.pojo.ItemDesc;
import com.jt.manage.pojo.ItemParam;
import com.jt.manage.pojo.TbItemParamItem;
import com.jt.manage.service.ItemService;
//定义类名时,考虑spring容器中是否有key,如果没有可以创建
@RestController
@RequestMapping("/web/item")
public class WebItemController {
	@Autowired
	private ItemService itemService;
	//http://manage.jt.com/web/item/findItemById/562379
	//查询商品信息
	@RequestMapping("/findItemById/{itemId}")
	public Item findItemById(@PathVariable Long itemId) {
	
		
		return itemService.finItemById(itemId);
	}
	//根据itemId 查询商品详情信息
	@RequestMapping("/findItemDescById/{itemId}")
	public ItemDesc findItemDescById(@PathVariable Long itemId) {
		
		
		return itemService.findItemDescById(itemId);
	}
	@RequestMapping("/findItemParamById/{itemId}")
	public ItemParam findItemParamById(@PathVariable Long itemId) {
		
		
		return itemService.findItemParamById(itemId);
	}
}
