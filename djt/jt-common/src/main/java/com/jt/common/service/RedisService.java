package com.jt.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;


@Service
public class RedisService {
	//这个类配合哨兵使用
	//有的工程需要，有的工程不需要。设置required=false，有就注入，没有就不注入。
    @Autowired(required=false)
    private JedisSentinelPool pool;
    public void set(String key,String value) {
    	Jedis jedis = pool.getResource();
    	jedis.set(key, value);
    	jedis.expire(key, 7*24*3600);
    	jedis.close();
    }
    
    public String get(String key) {
    	Jedis jedis = pool.getResource();
    	String result = jedis.get(key);
    	jedis.close();
    	return result;
    }
    
    public void del(String key) {
    	Jedis jedis = pool.getResource();
    	jedis.del(key);
    	jedis.close();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 

}
