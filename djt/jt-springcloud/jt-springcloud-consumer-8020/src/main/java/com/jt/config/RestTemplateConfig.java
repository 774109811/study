package com.jt.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;

@Configuration
public class RestTemplateConfig {
	//客户端实现了负载均衡
	//效率高 Ribbon
	@Bean
	@LoadBalanced//实现负载均衡 默认轮询
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	//切换负载均衡策略
	@Bean
	public IRule getIRule() {
		return new RoundRobinRule();
				
				
			/*	new IRule() {
			
			@Override
			public void setLoadBalancer(ILoadBalancer lb) {
	   			// TODO Auto-generated method stub
				
			}
			
			@Override
			public ILoadBalancer getLoadBalancer() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Server choose(Object key) {
				// TODO Auto-generated method stub
				return null;
			}
		};*/
	}
}
