package com.jt.factory;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jt.pojo.User;
import com.jt.service.UserService;

import feign.hystrix.FallbackFactory;
//熔断机制
@Component
public class UserServiceForbackFactory implements FallbackFactory<UserService>{

	@Override
	public UserService create(Throwable cause) {
		return new UserService() {
			
			@Override
			public String saveUser(User user) {
				// TODO Auto-generated method stub
				return "后台服务异常调用接口方法";
			}
			
			@Override
			public String getMassge() {
				// TODO Auto-generated method stub
				return "后台异常";
			}
			
			@Override
			public List<User> findAll() {
				System.out.println("这里执行了");
				return new ArrayList<User>();
			}
		};
	
		
	}
		
}