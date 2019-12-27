package com.jt.manage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.jt.common.service.RedisService;
import com.jt.common.util.ObjectMapperUtil;
import com.jt.common.vo.ItemCatData;
import com.jt.common.vo.ItemCatResult;
import com.jt.manage.anno.CacheAnno;
import com.jt.manage.anno.CacheAnno.CACHE_TYPE;
import com.jt.manage.annotation.CacheAnnotation;
import com.jt.manage.mapper.ItemCatMapper;
import com.jt.manage.pojo.ItemCat;
import com.jt.manage.vo.EasyUITree;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.ShardedJedis;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private JedisCluster jedisCluster;
	//private RedisService redisService;
	//private ShardedJedis jedis;
	@Autowired
	private ItemCatMapper itemCatMapper;
		//商品列表信息 一级信息
	
	public List<ItemCat> findItemCatByParentId(long parentId){
		ItemCat itemCat=new ItemCat();
		//设置它的父类parentId
		itemCat.setParentId(parentId);
		List<ItemCat> select = itemCatMapper.select(itemCat);
		//根据对象查询商品列表信息所有信息
		return  select;
	}
	//商品分类数据 封装成Vo
	//@CacheAnnotation
	@CacheAnno(cacheType=CACHE_TYPE.FIND,index=0,key="ITEM_CART_",targetClass=ArrayList.class)
	@Override
	public List<EasyUITree> findItemCatList(long parentId) {
		System.out.println("数据库");
		/**
		 * 1.先创建一个VoList集合对象,
		 * 2.在把商品类对象放入这个list对象中
		 */
		//1.1 创建voList对象
		List<EasyUITree> treeList=new ArrayList<EasyUITree>();
		//1.2 获取商品类信息集合
		List<ItemCat> itemCatList=findItemCatByParentId(parentId);
		//1.3 遍历这个商品信息把它放入Vo对象里
		for (ItemCat itemCat : itemCatList) {
			//创建Vo对象
			EasyUITree uiTree = new EasyUITree();
			uiTree.setId(itemCat.getId());
			uiTree.setText(itemCat.getName());
			//一二级开三级关闭      1是关闭 0是关闭
			String state=itemCat.getIsParent()?"closed":"open";
			uiTree.setState(state);
			treeList.add(uiTree);
		}
		
		return treeList;
	}
	@SuppressWarnings("null")
	@Override
	public List<EasyUITree> findCahceItemCatList(Long parentId) {
		String key="ITEM_CART_"+parentId;
		//获取json值
		String json = jedisCluster.get(key);
		List<EasyUITree> treeList=new ArrayList<>();
		//如果为空就去数据库查询对象并保存缓存并返回
		if(StringUtils.isEmpty(json)) {
			//查到的对象
			treeList = findItemCatList(parentId);
			//把对象放到缓存中
			String json2 = ObjectMapperUtil.toJSON(treeList);
			jedisCluster.set(key, json2);
			System.out.println("数据库对象!!!!");
			
		}else {
			//如果有就把json对象转换为java对象并返回
			treeList = ObjectMapperUtil.toObject(json,treeList.getClass());
			System.out.println("缓存对象!!!!");
		}	
		return treeList;	
	}
	
	
	
	
	
	
	}
	

