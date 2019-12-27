package com.jt.common.util;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
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

    
    /**
     * 将json数据转换成pojo对象list
     * <p>Title: jsonToList</p>
     * <p>Description: </p>
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
    	JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, beanType);
    	try {
    		List<T> list = mapper.readValue(jsonData, javaType);
    		return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return null;
    }
}
