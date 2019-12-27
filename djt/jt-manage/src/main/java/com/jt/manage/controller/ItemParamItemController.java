package com.jt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.TbItemParamItem;
import com.jt.manage.service.ItemParamItemService;

@Controller
public class ItemParamItemController {
	@Autowired
	private ItemParamItemService itemParamItemService;
	//@RequestMapping("/item/param/query/itemcatid/{itemCatId}")
	//@ResponseBody
	public String getItemParamById(@PathVariable Long itemCatId, Model model) {
		String itemParamItem = itemParamItemService.geParamItemByItemId(itemCatId);
		model.addAttribute("itemParams", itemParamItem);
		return "item-param-show";
	}

}
