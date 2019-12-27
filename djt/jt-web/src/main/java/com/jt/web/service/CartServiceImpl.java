package com.jt.web.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jt.common.service.HttpClientService;
import com.jt.common.util.ObjectMapperUtil;
import com.jt.common.vo.SysResult;
import com.jt.web.pojo.Cart;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private HttpClientService httpClient;
	@SuppressWarnings("unchecked")
	@Override
	public List<Cart> findCartByUserId(Long userId) {
		String url="http://cart.jt.com/cart/query/"+userId;
		//提交查看购物车页面
		String json= httpClient.doGet(url);
		//把json转化成对象并返回给页面jsp
		SysResult object = ObjectMapperUtil.toObject(json, SysResult.class);
		//把data数据返回给页面jsp
		return (List<Cart>) object.getData();
	}
	@Transactional
	@Override
	public void saveCart(Cart cart) {
		String url="http://cart.jt.com/cart/save";
		String cartJSON = ObjectMapperUtil.toJSON(cart);
		HashMap<String, String> map = new HashMap<>();
		map.put("cartJSON", cartJSON);
		httpClient.doPost(url,map);
		
	}
	//www.jt.com/service/cart/update/num/562379/6
	@Transactional
	@Override
	public void updateCart(Cart cart) {
		String url="http://cart.jt.com/cart/update/num/"+cart.getUserId()+"/"+cart.getItemId()+"/"+cart.getNum();

		String doget = httpClient.doGet(url);
		System.out.println(doget);
	}
	@Override
	public void deleteCart(Cart cart) {
		String url="http://cart.jt.com/cart/delete/"+cart.getUserId()+"/"+cart.getItemId();
		httpClient.doGet(url);
	}

}
