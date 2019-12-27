package com.pd;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pd.pojo.PdOrder;
import com.pd.service.OrderService;

@Component
public class OrderConsumerListener {
	//消费者启动后，自动脸上消息队列服务器
	//从orderQueue中取数据，去到字符串
	//对字符串反序列化成对象
	//amqp调用process(pdorder)
	//@RabbitListener 定义队列 从队列中取对象
	@Autowired
	OrderService OrderService;
	@RabbitListener(queues="orderQueue")
	public void process(PdOrder pdOrder) {
		System.out.println("收到订单对象");
		System.out.println(pdOrder.toString());
		try {
			OrderService.saveOrder(pdOrder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
