package com.jt.manage.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.manage.mapper.ItemDescMapper;
import com.jt.manage.mapper.ItemMapper;
import com.jt.manage.mapper.ItemParamMapper;
import com.jt.manage.mapper.TBItemParamItemMapper;
import com.jt.manage.pojo.Item;
import com.jt.manage.pojo.ItemDesc;
import com.jt.manage.pojo.ItemParam;
import com.jt.manage.pojo.TbItemParamItem;
import com.jt.manage.vo.EasyUITable;


@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ItemDescMapper  itemDescMapper;
	@Autowired
	private TBItemParamItemMapper tBItemParamItemMapper;
	@Autowired
	private ItemParamMapper itemParamMapper;
	/**
	 * @rows    根据当前页和要查询当前页的总记录数
	 * @page 
	 * @total   总记录数   
	 * @EasyUITable   根据分页limit查询商品信息并展现出来封装成值对象 
	 * @return  返回封装的对象
	 */
	@Override
	public EasyUITable findItemListByPage(int page, int rows) {
		//查询总记录数
		//int total = itemMapper.findItemCount();

		//通用mapper查询时没有where条件则写空
		int total = itemMapper.selectCount(null);//通用接口文件查询总记录数
		//起始位置          
		int start = (page-1)*rows;
		//分页以后的记录   根据起始位值和要查询的总行数的对象
		List<Item> itemList=itemMapper.findItemListByPage(start,rows);

		//封装值对象
		EasyUITable table =new EasyUITable();
		table.setTotal(total);//总记录数
		table.setRows(itemList);//分页信息封装到list集合
		return table;
	}
	/**
	 * 查询商品分类的名字同步显示到页面上
	 */
	@Override
	public String findItemCatNameById(Long itemCatId) {
		// TODO Auto-generated method stub
		return itemMapper.findItemCatNameById(itemCatId);
	}

	//添加商品信息
	@Override
	public void saveItem(Item item,String desc,String itemParams) {
		//修改它的状态值
		item.setStatus(1);//1表示正常
		//修改创建时间
		item.setCreated(new Date());
		//设置修改时间
		item.setUpdated(item.getCreated());		
		//添加商品自身信息
		//先入库在把id主键交给商品详情id入库
		//mybatis入库之后就会查询一次id
		// SELECT LAST_INSERT_ID()
		itemMapper.insert(item);



		//入库商品详情信息
		//动态获取新增的id
		ItemDesc itemDesc = new ItemDesc();
		itemDesc.setItemId(item.getId());
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(itemDesc.getCreated());
		//添加商品详情信息
		itemDescMapper.insert(itemDesc);

		//添加商品规格信息
		//添加商品规格
		TbItemParamItem itemParamItem = new TbItemParamItem();
		itemParamItem.setItemId(item.getId());
		itemParamItem.setParamData(itemParams);
		itemParamItem.setCreated(new Date());
		itemParamItem.setUpdated(itemParamItem.getCreated());

		tBItemParamItemMapper.insert(itemParamItem);



	}
	//批量修改状态值
	@Override
	public void updateStatus(Long[] ids, int status) {

		itemMapper.updateStatus(ids,status);
	}
	//编辑修改商品信息和商品详情信息
	@Override
	public void updateItemById(Item item,String desc) {
		//设置它的修改时间
		item.setUpdated(new Date());
		//修改商品自身信息
		itemMapper.updateByPrimaryKeySelective(item);
		//获取商品详情对象
		ItemDesc itemDesc = new ItemDesc();
		//设置它的id
		itemDesc.setItemId(item.getId());
		//设置商品详情的商品描述从页面上获取
		itemDesc.setItemDesc(desc);
		//设置商品详情的修改时间
		itemDesc.setUpdated(new Date());
		//修改商品详情对象
		itemDescMapper.updateByPrimaryKeySelective(itemDesc);

	}
	//批量删除商品信息,删除商品详情表信息
	@Override
	public void deleteItem(Long[] ids,String desc) {
		//先删除外键商品详情信息
		itemDescMapper.deleteByIDS(ids);
		//删除商品信息
		itemMapper.deleteByIDS(ids);
	}
	//根据主键id查询商品详情描述信息
	@Override
	public ItemDesc findItemDescById(Long itemId) {

		return itemDescMapper.selectByPrimaryKey(itemId);
	}

	//根据itemId 查询商品具体信息
	@Override
	public Item finItemById(Long itemId) {

		return itemMapper.selectByPrimaryKey(itemId);
	}
	@Override
	public ItemParam findItemParamById(Long itemCatId) {
	
		ItemParam selectByPrimaryKey = itemParamMapper.sslect(itemCatId);
		System.out.println(selectByPrimaryKey);
		return selectByPrimaryKey;
	}




}
