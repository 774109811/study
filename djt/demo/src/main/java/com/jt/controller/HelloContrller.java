package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.pojo.Dog;
import com.jt.pojo.User;

@RestController
public class HelloContrller {
	@RequestMapping("/hello")
	public String hello() {
		return "hello,springboot";
	}
	@Autowired
	private User user;
	@RequestMapping("/getUser")
	public User getUser() {
		return user;
	}
	@Autowired
	private Dog dog;
	@RequestMapping("/getDog")
	public Dog getDog() {
		return dog;
	}
}
