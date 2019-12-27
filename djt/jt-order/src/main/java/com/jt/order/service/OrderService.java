package com.jt.order.service;

import java.util.List;

import com.jt.order.pojo.Order;

public interface OrderService {

	String saveOrder(Order order);

	Order findOrderById(String orderId);

	void updateOrderStatus();



}
