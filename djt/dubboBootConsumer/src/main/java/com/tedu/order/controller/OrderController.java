package com.tedu.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tedu.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	/**
	 * @Reference 作用是为orderService
	 * 实现动态代理对象
	 * 调用提供者实现类
	 */
	@Reference(version="1.0.0",timeout=100000,check=false)
	OrderService orderService;
	@RequestMapping("/find")
	public String find() {
		//orderService.findOrderById 产生动态代理对象
		//重写invoke方法{socket,接口吗,方法名,参数类型}并返回
		String result=orderService.findOrderById(18L);
		return result;
	}
}
