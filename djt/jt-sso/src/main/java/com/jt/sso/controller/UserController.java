package com.jt.sso.controller;



import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jt.sso.mapper.UserMapper;
import com.jt.sso.pojo.User;
import com.jt.sso.service.UserService;
import com.jt.sso.vo.SysResult;

import redis.clients.jedis.JedisCluster;

@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	private JedisCluster jedisCluster;
	@Autowired
	private UserService  userService;
	//http://sso.jt.com/findAll
	@RequestMapping("/findAll")
	public List<User> findAll() {
		return userService.findAll();
	}
	//注册时 实现跨域查询有没有相同的数据
	
	///http://sso.jt.com/user/check/21312sdqwd/1? 异步请求
	@RequestMapping("/check/{param}/{type}")
	public JSONPObject findAll(@PathVariable String param,@PathVariable Integer type,String callback) {
		boolean flag =userService.findCheckUser(param,type);
		//查询出来的返回值
		SysResult result=SysResult.oK(flag);
		return new JSONPObject(callback, result);
	}
	//实现注册并入库
	//http://www.jt.com/user/register
	@RequestMapping("/register")
	public SysResult saveUser(User user) {
		userService.saveUser(user);
		return SysResult.oK();
	}

	//实现登录业务
	@RequestMapping("/login")
	public SysResult doLogin(User user) {
		try {
			String token=userService.findUserByUP(user);
			if(!StringUtils.isEmpty(token)) {
				return SysResult.oK(token);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SysResult.build(201, "登录失败");
	}


	//通过跨域,用户登录后在页面回显用户名信息的获取
	@RequestMapping("/query/{token}")
	public JSONPObject findUserByToken(String callback,
			@PathVariable String token) {
		//从缓存中获取token jedis有lru算法判断是否存在
		//userJSON是json串交给jsp解析成对象 然后获取username
		String userJSON = jedisCluster.get(token);
		//把获取得json串封装成sysResult
		SysResult sysResult=null;
		if(!StringUtils.isEmpty(userJSON)) {
			//把数据封装成sysResult 返回
			sysResult = SysResult.oK(userJSON);
		}
		return new JSONPObject(callback, sysResult);
	}
	

}
