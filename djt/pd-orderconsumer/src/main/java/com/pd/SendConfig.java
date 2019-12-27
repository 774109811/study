package com.pd;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//消息提供者，用的是简单模式，配置队列名称
//配置提供者信息，在项目启动时，为SendConfig创建对象
//注册一个队列对象到spring框架
@Configuration
public class SendConfig {
	//连接rabbitmq的服务器的amqp框架，需要Queue对象
	//提供对象给amqp框架有两种方式
	//1,application-context.xml中增加<bean>
	//2,@bean注解
	//queue是amqp.core包中的
	@Bean
	public Queue queue()
	{
		//orderQueue在rabbitmq服务器上不存在
		//存在，属性不一致，就会出异常 默认是持久化到硬盘
		Queue queue=new Queue("orderQueue");
		return queue;
	}
}
