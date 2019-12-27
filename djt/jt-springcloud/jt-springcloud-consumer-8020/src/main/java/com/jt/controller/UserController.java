package com.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jt.pojo.User;
import com.jt.service.UserService;

@RequestMapping("/consumer")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	//
	@RequestMapping("/findAll")
	public List<User> findAll(){
		return userService.findAll();
	}
	@RequestMapping("/saveUser/{name}/{age}/{sex}")
	public String saveUser(User user) {
		return userService.saveUser(user);
	}
	@RequestMapping("/getMassge")
	public String getMassge() {
		return userService.getMassge();
	}
	
	/*
	 * @Autowired private RestTemplate restTemplate;
	 * 
	 * private static final String urls="http://provider-user/";
	 * 
	 * @SuppressWarnings("unchecked")
	 * 
	 * @RequestMapping("/findAll") public List<User> findAll(){ String url=urls +
	 * "findAll"; return restTemplate.getForObject(url, List.class); }
	 * 
	 * //Feign 通过接口的方式声明式调用 //Feign是一种声明式、模板化的HTTP客户端。
	 * //简化客户端编码,可以使用户直接通过接口的方式声明式的调用,内部集成了ribbon.内部实现负载均衡 //消费者 新增用户信息
	 *//**
		 * 参数说明: 1.url 访问服务端地址 2.request 传递的参数对象 3.responseType 响应的对象类型
		 * 
		 * @param user
		 * @return
		 *//*
			 * @RequestMapping("/saveUser/{name}/{age}/{sex}") public String saveUser(User
			 * user) { String url = urls+"saveUser"; //使用post提交用户数据 return
			 * restTemplate.postForObject(url, user,String.class); }
			 * 
			 * @RequestMapping("/getMassge") public String getMassge() { String
			 * url=urls+"getMassge"; return restTemplate.getForObject(url, String.class);
			 * 
			 * }
			 */
}
