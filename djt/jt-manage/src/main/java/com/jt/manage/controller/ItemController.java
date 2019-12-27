package com.jt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.Item;
import com.jt.manage.pojo.ItemDesc;
import com.jt.manage.pojo.ItemParam;
import com.jt.manage.pojo.TbItemParamItem;
import com.jt.manage.service.ItemService;
import com.jt.manage.vo.EasyUITable;
@RequestMapping("/item/")
@Controller
//用户的请求是什么,返回值是什么
public class ItemController {
	@Autowired
	private ItemService itemService;

	/**
	 * 
	 * @param page  客户端传来的数据 当前页
	 * @param rows  当前页记录行数
	 * @return
	 */
	@RequestMapping("query")
	@ResponseBody //返回数据转化为Json
	public EasyUITable findItemList(int page,int rows){
		return  itemService.findItemListByPage(page,rows);
	}
	/**
	 * 1.Object对象类型:返回值编辑就是UTF-8 MVC支持
	 * 2.如果返回值类型为String类型,
	 * 则MVC采用ISO-8859-1格式转码.
	 * @param itemCatId
	 * @return
	 * class AbstractJackson2HttpMessageConverter extends AbstractHttpMessageConverter<Object>
		public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
		public class StringHttpMessageConverter extends AbstractHttpMessageConverter<String> {
		public static final Charset DEFAULT_CHARSET = Charset.forName("ISO-8859-1");
	 */
	//根据商品分类Id查询名称
	//根据商品的id查询商品分类id并显示分类名称
	//查询商品分类的名字同步显示到页面上 
	@RequestMapping(value="cat/queryItemCatNameById",produces="text/html;charset=utf-8")
	@ResponseBody
	public String findItemCatNameById(Long itemCatId) {//页面需要的id
		return itemService.findItemCatNameById(itemCatId);
	}
	//实现商品新增
	@RequestMapping("save")
	@ResponseBody
	public SysResult saveItem(Item item,String desc,String itemParams) {
		try {
			itemService.saveItem(item,desc,itemParams);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return SysResult.build(201,"商品新增失败,联系维护人员");
	}
	//实现商品删除,也删除商品详情信息
	@RequestMapping("delete")
	@ResponseBody
	public SysResult deleteItem(Long[] ids,String desc) {
		try {
			itemService.deleteItem(ids,desc);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return SysResult.build(201,"商品删除失败,联系维护人员");
	}
	
	//根据主键id查询商品详情描述信息
	//回显商品详情信息	{itemId}动态的获取传过来的id
	@RequestMapping("/query/item/desc/{itemId}")
	@ResponseBody
	public SysResult findItemDescById(@PathVariable Long itemId) {
		try {
			ItemDesc itemDesc=itemService.findItemDescById(itemId);
			return SysResult.oK(itemDesc);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return SysResult.build(201,"商品详情信息,联系维护人员");
	}

	///item/param/item/query/
	///param/item/query/
	///item
	@RequestMapping("/param/item/query/{itemCatId}")
	@ResponseBody
	public SysResult findItemParamById(@PathVariable Long itemCatId) {
		try {
			ItemParam itemDesc=itemService.findItemParamById(itemCatId);
			return SysResult.oK(itemDesc);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return SysResult.build(201,"商品详情信息,联系维护人员");
	}
	//编辑商品修改页面和修改商品详情表信息
	@RequestMapping("update")
	@ResponseBody
	public SysResult updateItem(Item item,String desc) {
		try {
			itemService.updateItemById(item,desc);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return SysResult.build(201,"商品修改失败,联系维护人员");
	}
	
	
	
	
	
	//实现商品上架和下架
	@RequestMapping("instock")
	@ResponseBody
	public SysResult instock(Long[] ids) {
		try {
			//商品下架
			int status=2;
			itemService.updateStatus(ids,status);
			//成功返回状态值
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  SysResult.build(201,"下架失败");
	}
	//实现商品上架和下架
	@RequestMapping("reshelf")
	@ResponseBody
	public SysResult reshelf(Long[] ids) {
		try {
			//商品下架
			int status=1;
			itemService.updateStatus(ids,status);
			//成功返回状态值
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  SysResult.build(201,"上架失败");
	}
	
}
