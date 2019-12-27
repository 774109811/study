package com.jt.manage.service;

import com.jt.manage.pojo.Item;
import com.jt.manage.pojo.ItemDesc;
import com.jt.manage.pojo.ItemParam;
import com.jt.manage.pojo.TbItemParamItem;
import com.jt.manage.vo.EasyUITable;

public interface ItemService {
	//查询分页信息
	EasyUITable findItemListByPage(int page, int rows);
	//查询商品分类的名字根据商品id
	String findItemCatNameById(Long itemCatId);
	//添加商品
	void saveItem(Item item, String desc,String itemParams);
	//修改上架下架信息
	void updateStatus(Long[] ids, int status);
	//编辑商品修改页面
	void updateItemById(Item item, String desc);
	//批量删除商品信息
	void deleteItem(Long[] ids, String desc);
	//根据主键id查询商品详情描述信息
	ItemDesc findItemDescById(Long itemId);
	Item finItemById(Long itemId);
	ItemParam findItemParamById(Long itemId);

	

}
