package com.tedu.rabbitmq;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.HashMap;

import org.junit.Test;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.AMQP.BasicProperties.Builder;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

//简单模式的消息提供者(消息发送者)
public class Test_2_work_provider {
	@Test
	public void provider()throws Exception{
		//向消息队列写数据与mysql写数据相似
		//1,获取连接
		ConnectionFactory factory=new ConnectionFactory();
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
		//2,得到通道channel
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		//3,定义一个队列名
		String queueName="order3";
		//false:队列不存到硬盘上  队列的持久化
		boolean durable=true;
		//false:允许别的访问队列
		boolean exclusive=false;
		//false:不删除队列
		boolean autoDelete=false;
		//配置信息
		HashMap<String, Object>arguments=null;
		channel.queueDeclare(queueName, durable, exclusive, autoDelete, arguments);
		//4,写数据
		//使用的是rabbitmq自带默认的交换机
		String exchange="";
		//根据routingKey把消息发给相应的队列
		String routingKey=queueName;
		//设置消息的持久化
		//properties的mode为2,消息会保存到硬盘上
		//建造者设计模式
		//需要BasicProperties对象,创建BasicProperties对象需要很多参数
		//创建新的类buider,负责创建basicProperties对象
		BasicProperties.Builder builder=new Builder();
		//将消息保存到硬盘上
		builder.deliveryMode(2);
		BasicProperties props=builder.build();
		//byte[] body="msg5".getBytes();
		//测试每秒能写多少个数据,测试服务器每秒能收多少个数据
		/*
		 * int count=0; long start = System.currentTimeMillis();
		 * while((System.currentTimeMillis()-start<10*1000)) { //写数据 count++; }
		 */
		for (int i = 0; i < 10; i++) {
			
			channel.basicPublish(
					exchange, routingKey, props, ("test msg"+i).getBytes());
		}
		//System.out.println("读了多少数据:"+count/10);
		//5,关闭资源
		connection.close();
	}
	
}
