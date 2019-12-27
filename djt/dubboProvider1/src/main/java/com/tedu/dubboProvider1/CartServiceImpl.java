package com.tedu.dubboProvider1;

import com.tedu.dubboInterface.CartService;

public class CartServiceImpl implements CartService {

	@Override
	public String findCartByUserId(Long userId) {
		return "第1个提供者 cart userId=" + userId;
	}
	
}
