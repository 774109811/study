package com.jt.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.SysResult;
import com.jt.web.pojo.Cart;
import com.jt.web.pojo.Order;
import com.jt.web.service.CartService;
import com.jt.web.service.OrderService;
import com.jt.web.util.UserThreadLocal;

@RequestMapping("/order")
@Controller
public class OrderController {

	@Autowired
	private CartService cartService;
	
	
	
	//跳转订单页面展现  根据登录用户的id在查询出购物车里的订单展现出来
	@RequestMapping("/create")
	public String create(Model model) {
		Long userId = UserThreadLocal.get().getId();
		List<Cart> cartList = cartService.findCartByUserId(userId);
		model.addAttribute("carts", cartList);
		return "order-cart";
	}
	//http://www.jt.com/service/order/submit
	@RequestMapping("/submit")
	@ResponseBody
	public SysResult saveOrder(Order order) {
		Long userId = UserThreadLocal.get().getId();
		order.setUserId(userId);
		String orderId=orderService.saveOrder(order);
		if(!StringUtils.isEmpty(orderId)) {
			return SysResult.oK(orderId);
		}else {
			return SysResult.build(201,"订单提交失败");
		}
	}
	//http://www.jt.com/order/success.html?id=71553502027996
	@RequestMapping("/success")
	public String findOrderById(String id,Model model) {
		Order order= orderService.findOrderById(id);
		model.addAttribute("order",order);
		return "success";
	}


	//进入我的订单
	@Autowired
	private OrderService orderService;
	@RequestMapping("/{myOrder}")
	public String myOrder() {
		return "my-orders";
	}
}
