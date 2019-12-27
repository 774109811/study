package com.jt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.ItemDesc;
import com.jt.manage.pojo.ItemParam;
import com.jt.manage.pojo.TbItemParamItem;
import com.jt.manage.service.ItemParamService;
import com.jt.manage.vo.EasyUITable;

@RestController
@RequestMapping("/item/param")
public class ItemParamController {
	@Autowired
	private ItemParamService itemParamService;
	@RequestMapping("/list")
	public EasyUITable findAllLimit(@RequestParam(defaultValue = "1")int page,int rows) {
		
		return itemParamService.findAllLimit(page,rows);
	}
	//item/param/query/itemcatid/
	//item/param/query/itemcatid/item_cat_id 
	@RequestMapping("/query/itemcatid/{itemCatId}")
	public SysResult findItemParam(@PathVariable Long itemCatId) {
		//根据分类id查询列表
		SysResult result = itemParamService.findItemParamByItemPCId(itemCatId);
		return result;
	}
	@RequestMapping("/save/{cid}")
	//从前端页面串来的参数{cid}/paramData
	public SysResult saveItemParam(@PathVariable Long cid, String paramData) throws Exception {
		ItemParam itemParam = new ItemParam();
		//把前端页面传来的数据放入对象中进行添加
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		SysResult result = itemParamService.saveItemParam(itemParam);
		return result;
	}
	
	//content/save
		@RequestMapping("/delete")
		public SysResult deleteContent(Long[] ids) {
			SysResult result=itemParamService.deleteContent(ids);
			return result;
		}
	
}
