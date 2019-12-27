package com.jt.manage.aspect;



import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.jt.common.cache.CacheKey;
import com.jt.common.service.RedisService;
import com.jt.common.util.ObjectMapperUtil;

import redis.clients.jedis.JedisCluster;

@Aspect
@Service
public class SysCacheAspect {
	@Autowired
	private JedisCluster jedisCluster;
	ConcurrentMap<CacheKey, Object> map=new ConcurrentHashMap<>();
	@SuppressWarnings("unchecked")
	@Around("@annotation(com.jt.manage.annotation.CacheAnnotation)")
	public Object aroundCache(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("切面执行了");
		// 创建工具类
		CacheKey cachekey = new CacheKey();
		// 获取目标类
		Class<?> targetCls = jp.getClass();
		cachekey.setTargetClass(targetCls.getClass());
		// 获取方法签名
		MethodSignature ms = (MethodSignature) jp.getSignature();
		// 获取方法
		cachekey.setTargetMethod(ms.getMethod());
		// 获取参数
		cachekey.setArgs(jp.getArgs());
		
		System.out.println("缓存");
		Object result = map.get(cachekey);
		//如果有值直接返回结果值
		if(result!=null)return result;
		//没有就执行下面的
		//反射调用目标方法(子项service层会访问数据库)
		 result = jp.proceed();
		
		//返回前先放入map中
		 map.put(cachekey, result);
		return result;



		/*
		 * String json = jedis.get(key); Object object=null; //如果为空就去数据库查询对象并保存缓存并返回
		 * if(StringUtils.isEmpty(json)) { //查到的对象 object = jp.proceed(); //把对象放到缓存中
		 * String json2 = ObjectMapperUtil.toJSON(object); jedis.set(key, json2);
		 * System.out.println("数据库对象!!!!");
		 * 
		 * }else { //如果有就把json对象转换为java对象并返回 object =
		 * ObjectMapperUtil.toObject(json,object.getClass());
		 * System.out.println("缓存对象!!!!"); } return object;
		 */
	}
}
