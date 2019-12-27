package com.jt.order.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.order.pojo.Order;
import com.jt.order.service.OrderService;
import com.jt.order.vo.SysResult;
import com.jt.ordert.util.ObjectMapperUtil;

import redis.clients.jedis.JedisCluster;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	//实现订单提交,同事入库三张表
	//http://order.jt.com/order/create
	@RequestMapping("/create")
	public SysResult saveOrder(String orderJSON) {
		Order order = ObjectMapperUtil.toObject(orderJSON, Order.class);
		String orderId=orderService.saveOrder(order);
		if(!StringUtils.isEmpty(orderId)) {
			return SysResult.oK(orderId);
		}else {
			
		return SysResult.build(201, "新增失败");
		}
	}
	//实现提交订单页面后展现出来的页面
	//http://order.jt.com/order/query/81425700649826
	@RequestMapping("/query/{orderId}")
	public Order findOrderById(@PathVariable String orderId) {
		
		return orderService.findOrderById(orderId);
	}
	
}
