package com.pd.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SendController {

	//给rabbitmq服务器发数据
	//amqpTemplate是amqp框架创建的，并且放到了spring容器中
	@Autowired
	AmqpTemplate amqpTemplate;
	
	@RequestMapping("/send")
	@ResponseBody
	public String send()
	{
		//routingKey是队列名，用的是简单模式
		//访问/send,进入rabbitmq后台，找到orderQueue
		//getMesssage
		String routingKey="orderQueue";
		//发到默认交换机
		amqpTemplate.convertAndSend(routingKey,
				"pd");
		return "ok";
	}
	
}



