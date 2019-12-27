package com.jt.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.cart.pojo.Cart;
import com.jt.cart.service.CartService;
import com.jt.cart.util.ObjectMapperUtil;
import com.jt.cart.vo.SysResult;

import redis.clients.jedis.JedisCluster;

@RestController
@RequestMapping("cart")
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired
	private JedisCluster jedisCluster;
	//实现购物车页面展现
	//http://cart.jt.com/cart/query/{userId}  
	@RequestMapping("/query/{userId}")
	public SysResult findCartByUserId(@PathVariable Long userId) {
		List<Cart> cartList=cartService.findCartByUserId(userId);
		return SysResult.oK(cartList);
	}
	//实现购物车新增http://cart.jt.com/cart/save
	@RequestMapping("/save")
	public SysResult saveCart(String cartJSON) {
		Cart cart = ObjectMapperUtil.toObject(cartJSON, Cart.class);
		cartService.saveCart(cart);
		return SysResult.oK();
	}
	//实现页面修改购物车数量
	//cart.jt.com/cart/update/num/{itemId}/{num}
	@RequestMapping("update/num/{userId}/{itemId}/{num}")
	public SysResult updateCartNum(Cart cart) {
		try {
			System.out.println(cart);
			cartService.updateCartNum(cart);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SysResult.build(201,"修改失败");
	}
	//http://cart.jt.com/cart/delete/{userId}/{itemId}
	//实现页面购物车删除
	@RequestMapping("/delete/{userId}/{itemId}")
	public SysResult delCart(Cart cart) {
		try {
			System.out.println(cart);
			cartService.deleteCartNum(cart);
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SysResult.build(201,"删除失败");
		
	}
}
