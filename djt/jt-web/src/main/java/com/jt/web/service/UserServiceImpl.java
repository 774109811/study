package com.jt.web.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.jt.common.service.HttpClientService;
import com.jt.common.util.ObjectMapperUtil;
import com.jt.common.vo.SysResult;
import com.jt.web.pojo.User;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private HttpClientService httpClient;
	/**
	 * 该方法表示jt-web从jt-sso中注册数据,
	 * 
	 */
	@Override
	public void saveUser(User user) {
	String url="http://sso.jt.com/user/register";
	//注册页面传来的参数
	HashMap<String, String> params = new HashMap<>();
	//注册用户名
	params.put("username", user.getUsername());
	//设置密码为用户密码加密
	String md5DigestAsHex = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
	params.put("password", md5DigestAsHex);
	//注册电话
	params.put("phone", user.getPhone());
	//注册email
	params.put("email", user.getEmail());
	//提交数据
	httpClient.doPost(url,params);
	}
	/**
	 * 该方法表示jt-web从jt-sso中获取token数据,
	 * 同时判断用户信息是否正确
	 * 该方法实现页面登录
	 */
	@Override
	public String findUserByUP(User user) {
		//定义返回的token
		String token=null;
		//通过httpclient跨平台提交数据
		//1.获取url
		String url="http://sso.jt.com/user/login";
		//2从页面获取参数
		HashMap<String, String> params = new HashMap<>();
		//从页面获取的用户名
		params.put("username", user.getUsername());
	
		String md5DigestAsHex = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		//从页面获取的password 传递给后台
		params.put("password", md5DigestAsHex);
		//3.提交登录信息 
		String json = httpClient.doPost(url, params);
		//4.把数据,转化为对象
		SysResult sysResult = ObjectMapperUtil.toObject(json, SysResult.class);
		//如果数据正确,对象中获取从sso中得到得token数据,
		if(sysResult.getStatus()==200) {
			 token = (String) sysResult.getData();
		}
		//把token返回给页面用户
		return token;
	}
	
	
	
	
	
	
	
	
	
	@Override
	public User findAll(String userName, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}












}
