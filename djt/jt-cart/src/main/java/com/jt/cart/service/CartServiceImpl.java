package com.jt.cart.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jt.cart.mapper.CartMapper;
import com.jt.cart.pojo.Cart;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartMapper cartMapper;
	//查询购物车列表
	@Override
	public List<Cart> findCartByUserId(Long userId) {
		QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("user_id", userId);		
		return cartMapper.selectList(queryWrapper)	;
	}
	/**
	 * 1.先查寻购物车又没有商品
	 * 2.如果有商品只增加数量
	 * 3.如果没有新增
	 * 4.如果
	 */
	@Transactional
	@Override
	public void saveCart(Cart cart) {
		QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("user_id", cart.getUserId());
		queryWrapper.eq("item_id", cart.getItemId());
		Cart cartDB = cartMapper.selectOne(queryWrapper);
		if(cartDB==null) {
			cart.setCreated(new Date()).setUpdated(cart.getUpdated());
			cartMapper.insert(cart);
		}else {
			int num=cartDB.getNum()+cart.getNum();
			cartDB.setNum(num).setUpdated(new Date());
			cartMapper.updateById(cartDB);
		}
		
	}
	@Transactional
	@Override
	public void updateCartNum(Cart cart) {
		Cart cartDB = new Cart();
		//设置修改的时间
		cartDB.setUpdated(new Date());
		//修改它的数量
		cartDB.setNum(cart.getNum());
		cartDB.setItemId(cart.getItemId());
		UpdateWrapper<Cart> updateWrapper = new UpdateWrapper<>();
		updateWrapper.eq("user_id", cart.getUserId())
		.eq("item_id", cart.getItemId());
		try {
			int update = cartMapper.update(cartDB, updateWrapper);
			if(update==0) {
				throw new NullPointerException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Transactional
	@Override
	public void deleteCartNum(Cart cart) {
		
		QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
		//QueryWrapper  根据where条件 不为空的条件删除
		queryWrapper.eq("user_id", cart.getUserId()).eq("item_id",cart.getItemId());
		try {
			int delete = cartMapper.delete(queryWrapper);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
