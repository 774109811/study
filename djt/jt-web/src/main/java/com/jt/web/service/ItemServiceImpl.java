package com.jt.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jt.common.service.HttpClientService;
import com.jt.common.util.ObjectMapperUtil;
import com.jt.common.vo.SysResult;
import com.jt.web.pojo.Item;
import com.jt.web.pojo.ItemDesc;
import com.jt.web.pojo.TbItemParamItem;
@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private HttpClientService httpClient;
	//实现前后端的连接
	//在前段点击商品后,通过httpclient连接后端服务器查询商品信息
	@Override
	public Item findItemById(Long itemId) {
		String url="http://manage.jt.com/web/item/findItemById/"+itemId;
		String doGet = httpClient.doGet(url);
		
		System.out.println(doGet);
		Item object = ObjectMapperUtil.toObject(doGet,Item.class);
		return object;
	}
	@Override
	public ItemDesc findItemDescById(Long itemId) {
		String url="http://manage.jt.com/web/item/findItemDescById/"+itemId;
		String doGet = httpClient.doGet(url);
		
		System.out.println(doGet);
		ItemDesc object = ObjectMapperUtil.toObject(doGet,ItemDesc.class);
		return object;
	}
	
	
	
	

}
