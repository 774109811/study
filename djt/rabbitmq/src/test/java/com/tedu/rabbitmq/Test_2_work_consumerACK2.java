package com.tedu.rabbitmq;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.HashMap;

import org.junit.Test;

import com.rabbitmq.client.AMQP.Queue.DeclareOk;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;

//简单模式的消息提供者(消息发送者)
public class Test_2_work_consumerACK2 {
	@Test
	public void consumer()throws Exception{
		//1,获取连接
		ConnectionFactory factory = new ConnectionFactory();
		//1.1设置服务器ip和端口号
		factory.setHost("192.168.50.136");
		//设置端口号
		//15672 返回的是后台管理网页
		//5672端口号是用来发消息,收消息
		factory.setPort(5672);
		//1.2设置虚拟主机
		factory.setVirtualHost("/pd");
		//1.3设置用户名
		factory.setUsername("pdadmin");
		//1.4设置密码
		factory.setPassword("pdadmin");
		//2,获取通道
		Connection connection=factory.newConnection();
		Channel channel = connection.createChannel();
		//3,定义队列
		//消息队列已经存在,就不创建
		//如果队列名相同,
		//queue, durable, exclusive, autoDelete, arguments值需要一样
		String queue="order3";
		//是否持久化
		boolean durable=true;
		boolean exclusive=false;
		boolean autoDelete=false;
		HashMap<String, Object>arguments=null;
		channel.queueDeclare(queue, durable, exclusive, autoDelete, arguments);
		//4,遍历消费者队列
		QueueingConsumer consumer=new QueueingConsumer(channel);
		//自动确认autoAck,收到消息后自动给服务器发送确认消息
		//服务器收到确认信息后,删除队列中的消息
		//false表示手动
		boolean autoAck=false;
		//读消息到消费者中
		channel.basicConsume(queue, autoAck, consumer);
		boolean isRunning=true;
		System.out.println("消费者2启动了");
		while(isRunning) {
			Delivery delivery=consumer.nextDelivery();
			byte[] body = delivery.getBody();
			String msg = new String(body);
			System.out.println("consumer 2收到了:"+msg);
			//确认订单
			//处理成功,手动确认,并发送到sql执行,失败不发送
			//得到消息
			long tag = delivery.getEnvelope().getDeliveryTag();
			channel.basicAck(tag, true);
			//将数据保存到数据库
		}
		//5,关闭
		connection.close();
	}

}
