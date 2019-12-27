package com.db.common.cache;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/***
 * 假设此类是一个缓存对象：
 * 此对象如何设计？基于LRU算法
 * 何为LRU算法？最近最少使用算法
 */
@Lazy//延迟加载(懒加载，按需加载)
@Component//等效于@Controller,@Service
//@Component注解用于修饰的是一般组件对象
//这样的注解仅仅是一个标识性作用，它的含义
//类似<bean id="lruCache" class="com.db.common.cache.LruCache">
public class LruCache {
	public LruCache() {
		System.out.println("LruCache()");
	}
	//.....
}
//1.spring 中描述bean方式有两种：
//1)xml
//2)annotation