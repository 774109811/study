package com.jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@MapperScan("com.jt.user.mapper")//启动时扫面,为mapper接口产生代理对象
@EnableEurekaClient
@EnableHystrix//开启断路器
public class SpringBoot_Run {
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot_Run.class);
	}
}
