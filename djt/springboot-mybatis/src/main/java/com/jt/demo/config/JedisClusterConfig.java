package com.jt.demo.config;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

@Configuration
@PropertySource(value="classpath:/properties/redis.properties")
public class JedisClusterConfig {
	@Value("${redis.nodes}")
	private String redisNodes;
	@Bean//实例化jedis
	public JedisCluster getJedisCluster() {
		HashSet<HostAndPort> hashSet = new HashSet<>();
		String[] rNodes = redisNodes.split(",");
		for (String node : rNodes) {
			String[] args = node.split(":");
			String ip =args[0];
			int port = Integer.parseInt(args[1]);
			HostAndPort hostAndPort = new HostAndPort(ip, port);
			hashSet.add(hostAndPort);
		}
		return new JedisCluster(hashSet);
	}
}
