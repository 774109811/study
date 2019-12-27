package com.jt.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.web.pojo.Item;
import com.jt.web.pojo.ItemDesc;
import com.jt.web.pojo.TbItemParamItem;

import com.jt.web.service.ItemService;

@Controller
@RequestMapping()
public class ItemControoler {
	@Autowired
	private ItemService itemService;
	
	//www.jt.com/items/562379.html
	//接收用户请求跳转商品列表页面
	@RequestMapping("/items/{itemId}")
	public String findItemById(@PathVariable Long itemId ,Model model) {
		Item item=itemService.findItemById(itemId);
		ItemDesc itemDesc=itemService.findItemDescById(itemId);
	
		model.addAttribute("item", item);
		model.addAttribute("itemDesc", itemDesc);
		
		return "item";
	}
	
}