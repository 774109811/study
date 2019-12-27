package com.jt.web.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jt.common.service.HttpClientService;
import com.jt.common.util.ObjectMapperUtil;
import com.jt.common.vo.SysResult;
import com.jt.web.pojo.Order;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private HttpClientService httpClient;
	//订单商品提交
	//提交的参数时多个用对象接收
	//返回值是orderId
	@Override
	public String saveOrder(Order order) {
		//提交的url
		String url="http://order.jt.com/order/create";
		//提交的参数
		String orderJSON = ObjectMapperUtil.toJSON(order);
		HashMap<String, String> params = new HashMap<>();
		params.put("orderJSON", orderJSON);
		String result = httpClient.doPost(url, params);
		SysResult sysResult = ObjectMapperUtil.toObject(result, SysResult.class);
		String orderId=null;
		if(sysResult.getStatus()==200) {
			orderId = (String) sysResult.getData();
			return orderId;
		}
		return orderId;
	}
	@Override
	public Order findOrderById(String id) {
		String url="http://order.jt.com/order/query/"+id;
		String orderJSON = httpClient.doGet(url);
		Order order=null;
		if(!StringUtils.isEmpty(orderJSON)) {
		 order = ObjectMapperUtil.toObject(orderJSON, Order.class);
		}
		return order;
	}
	
	
	
}
