package com.jt.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.factory.UserServiceForbackFactory;
import com.jt.pojo.User;
//Feign provider-user/findAll 客户端通过接口方式调用
//fallbackFactory 实现接口的断路器机制   服务器宕机调用UserServiceForbackFactory类里的方法
@FeignClient(value="provider-user",fallbackFactory=UserServiceForbackFactory.class)	//写入微服务名称
public interface UserService {
	@RequestMapping("/findAll")
	
	public List<User> findAll() ;
	/**
	 * 编辑提供者
	 * @ResponseBody 将对象转化为JSON
	 * @RequestBody User user  
	 * 将json动态转化为对象.
	 */
	@RequestMapping("/saveUser")
	public String saveUser(@RequestBody User user);
	
	@RequestMapping("/getMassge")
	public String getMassge() ;
}
