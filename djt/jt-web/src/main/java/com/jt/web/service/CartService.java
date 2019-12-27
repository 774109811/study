package com.jt.web.service;

import java.util.List;

import com.jt.web.pojo.Cart;

public interface CartService {

	

	void saveCart(Cart cart);

	void updateCart(Cart cart);

	void deleteCart(Cart cart);
	 List<Cart> findCartByUserId(Long userId);
}
