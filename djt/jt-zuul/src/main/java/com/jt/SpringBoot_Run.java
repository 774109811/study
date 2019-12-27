package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//添加注册服务中心配置
@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
@EnableZuulProxy//开启服务端注册服务中心
public class SpringBoot_Run {
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot_Run.class, args);
	}
}
