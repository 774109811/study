package com.jt.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.SysResult;
import com.jt.web.pojo.Cart;
import com.jt.web.pojo.User;
import com.jt.web.service.CartService;
import com.jt.web.util.UserThreadLocal;
@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/show.html")
	public String findCartByUserId(Model model,HttpServletRequest request) {
		Long userId=UserThreadLocal.get().getId();
		/*
		 * User user = (User) request.getAttribute("JT_USER"); Long userId=user.getId();
		 */
		List<Cart> cartList=cartService.findCartByUserId(userId);
		model.addAttribute("cartList", cartList);
		return "cart";
	}
	//前台购物车添加商品重定向跳转购物车新增
	//http://www.jt.com/cart/add/562379.html
	@RequestMapping("/add/{itemId}")
	public String saveCart(@PathVariable Long itemId,Cart cart) {
		/*
		 * User user = (User) request.getAttribute("JT_USER");
		 * 
		 * Long userId=user.getId();
		 */
		//用threadlocal就不需要 rqueset对象来获取userId
		Long userId=UserThreadLocal.get().getId();
		cart.setUserId(userId);
		cartService.saveCart(cart);
		return "redirect:/cart/show.html";
	}
	//修改商品购物车数量
	//www.jt.com/service/cart/update/num/562379/6
	@RequestMapping("/update/num/{itemId}/{num}")
	@ResponseBody //   /service/**
	public SysResult  updateCartNum(Cart cart,HttpServletRequest request) {
		User user = (User) request.getAttribute("JT_USER");
		Long userId = user.getId();
		cart.setUserId(userId);
		System.out.println(cart);
		try {
			cartService.updateCart(cart);
			
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201,"商品数量修改失败");
	}
	//根据userId itemId删除购物车的商品
	@RequestMapping("/delete/{itemId}")
	public String deleteCart(Cart cart ,HttpServletRequest request) {
		User user = (User) request.getAttribute("JT_USER");
		Long userId = user.getId();
		cart.setUserId(userId);
		System.out.println(cart);
		try {
			cartService.deleteCart(cart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/cart/show.html";
	}
}
