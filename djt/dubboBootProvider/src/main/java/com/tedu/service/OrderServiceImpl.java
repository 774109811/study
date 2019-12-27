package com.tedu.service;

import com.alibaba.dubbo.config.annotation.Service;

@Service(version="1.0.0",timeout=100000)
public class OrderServiceImpl implements OrderService {

	@Override
	public String findOrderById(Long userId) {
		// TODO Auto-generated method stub
		return "版本1 provider userId= "+userId;
	}

}
