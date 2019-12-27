package com.pd.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SendController {
	//发送数据给rabbitmq
	//amqpTemplate是amqp创建的在spring容器中
	@Autowired
	private AmqpTemplate amqpTemplate;
	@RequestMapping("/send")
	@ResponseBody
	public String send() {
		String routingKeyString="orderQueue";
		amqpTemplate.convertAndSend(routingKeyString,"pd");
		return "ok";
	}
}
