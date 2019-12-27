package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
//监控Dashboard的配置类
@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
@EnableHystrixDashboard	//启动仪表盘监控程序
public class SpringCloud_Run {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloud_Run.class, args);
	}
}
