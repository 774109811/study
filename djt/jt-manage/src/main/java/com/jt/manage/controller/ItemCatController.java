package com.jt.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jt.manage.service.ItemCatService;
import com.jt.manage.service.ItemService;
import com.jt.manage.vo.EasyUITable;
import com.jt.manage.vo.EasyUITree;
@RequestMapping("/item/cat/")
@RestController//
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	
	
	/**
	 * @RestController 
	 * 实现新增商品分类的查询
	 * 如果不需要跳转页面 只是返回json串
	 * @RequestParam(value="接收参数的名称",defaultValue="默认值",required="true必须传值,false可以不传")
	 * 问题:	
	 * 	1.参数Id 其实代表parentId 定义不精确
	 *  2.当没有点击节点时,参数id并不会传值. 需要设定默认值0
	 *  @RequestParam(value="url参数名称",
	 *  		defaultValue="当参数没有传递时,添加默认值",
	 *  		required=true/false 改参数是否为必传  默认为false
	 * @param id
	 * @return
	 */
	@RequestMapping("list")
	public List<EasyUITree> findItemCatList(@RequestParam(value="id",defaultValue="0") Long parentId){
		//先查询一级的商品信息
		//SELECT * FROM tb_item_cat WHERE parent_id=0
		//查询商品分类目录封装EasyUITree(id,name,state(树是展开还是关闭))并返回页面
		return itemCatService.findItemCatList(parentId);
	}
}
