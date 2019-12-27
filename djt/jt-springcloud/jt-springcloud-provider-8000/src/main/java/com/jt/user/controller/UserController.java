package com.jt.user.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.User;
import com.jt.user.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@RestController
@RequestMapping()
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/findAll")
	//拦截用户请求出错调用hystrix_findAll方法
	@HystrixCommand(fallbackMethod="hystrix_findAll")//出错后回调方法
	public List<User> findAll() {
	List<User> userList=userService.findAll();
		return userList;
	}                                           
	//断路器回调
	public List<User> hystrix_findAll(){
		ArrayList<User> userList = new ArrayList<>();
		User user = new User();
		user.setId(0).setName("").setAge(0).setSex("");
		userList.add(user);
		return userList;
	}
	/**
	 * 编辑提供者
	 * @ResponseBody 将对象转化为JSON
	 * @RequestBody User user  将json动态转化为对象.
	 */
	@RequestMapping("/saveUser")
	public String saveUser(@RequestBody User user) {
		
		userService.saveUser(user);
		return "新增用户成功:"+user.getName();
	}
	
	@RequestMapping("/getMassge")
	public String getMassge() {
		
		return "我是8000";
	}
}
