package com.jt.cart.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//定义redis缓存需要的类
//json转为对象,和对象转化为json
public class ObjectMapperUtil {
	private static ObjectMapper mapper =new ObjectMapper();
	//对象转化为json串
	public static String  toJSON(Object object) {
		String json=null;
		try {
			json = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return json;
	}
	//json转化为对象
	@SuppressWarnings("unchecked")
	public static <T> T  toObject(String json,Class<?> targetClass) {
		T t=null;//泛型对象
		try {
			t=(T)mapper.readValue(json, targetClass);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return t;
	}
	
}
