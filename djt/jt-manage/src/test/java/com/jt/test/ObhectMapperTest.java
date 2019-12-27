package com.jt.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.jt.manage.pojo.User;

public class ObhectMapperTest {
	@Test
	public  void objectTojson() throws IOException {
		User user = new User();
		//user.setAge(11);
		//user.setId(1);
		//user.setName("wangxin");
		//user.setSex("男");
		ObjectMapper objectMapper = new ObjectMapper();
		//把对象转化为json串
		String writeValueAsString = objectMapper.writeValueAsString(user);
		ObjectReader reader = objectMapper.reader();
		
		System.out.println(writeValueAsString);
		//将json串转对象
		User user2 = objectMapper.readValue(writeValueAsString, User.class);
		//先调用get方法获取json属性值,set方法为属性赋值
		System.out.println(user2);
		
	}
	@SuppressWarnings("unchecked")
	@Test
	public void lisToJson() throws IOException {
		
		List<User> userList=new ArrayList<>();
		User user = new User();
		//user.setAge(1);
		//user.setId(100);
		//user.setSex("nan");
		userList.add(user);
		ObjectMapper objectMapper = new ObjectMapper();
		String writeValueAsString = objectMapper.writeValueAsString(userList);
		System.out.println(writeValueAsString);
		
		//将json转化list对象
		List<User> ulist = objectMapper.readValue(writeValueAsString,userList.getClass());
		System.out.println(ulist);
	}	
	
	
	
}
