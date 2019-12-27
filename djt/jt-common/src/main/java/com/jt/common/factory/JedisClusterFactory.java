package com.jt.common.factory;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
//spring工厂配置 集群的工厂  实现工厂的接口FactoryBean<JedisCluster> 通过工厂的getObject方法获取对象
public class JedisClusterFactory implements FactoryBean<JedisCluster>{
	//注入propertis
	@Value("${redis.nodes}")//相当于xmlbean标签value值一样
	private String redisNodes;
	@Override
	public JedisCluster getObject() throws Exception {
		//jedis集群需要 host(虚拟机ip) port(redis端口号)
		//设置节点信息,并获取
		Set<HostAndPort> nodes =getNodes();
		//返回集群对象(需要节点)
		return new JedisCluster(nodes);
	}
	//获取set的节点信息方法 IP:端口,IP:端口
	public Set<HostAndPort> getNodes(){
		Set<HostAndPort> nodes=new HashSet<>();
		//{192.168.50.134:7000,192.168.50.134:7001,192.168.50.134:7002,192.168.50.134:7003,192.168.50.134:7004,192.168.50.134:7005,192.168.50.134:7006,192.168.50.134:7007,192.168.50.134:7008}
		String[] hostPort = redisNodes.split(",");
		//遍历这个数组
		for (String node : hostPort) {
			//a[0]=192.168.50.134:7000
			String[] args = node.split(":");
			//获取节点信息
			String host=args[0];
			int port = Integer.parseInt(args[1]) ;
			//把节点信息放入HostAndPort
			HostAndPort hostAndPort = new HostAndPort(host, port);
			nodes.add(hostAndPort);
		}
		//返回节点信息
		return nodes;
	}
	
	
	//获取对象的类型
	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return JedisCluster.class;
	}
	//是否是单例
	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

}
