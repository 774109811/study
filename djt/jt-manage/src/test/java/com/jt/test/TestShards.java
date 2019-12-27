package com.jt.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;

public class TestShards {
	@Test
	public  void tet01() {
		List<JedisShardInfo> shards=new ArrayList<>();
		JedisShardInfo info1 = new JedisShardInfo("192.168.50.134",6379);
		JedisShardInfo info2 = new JedisShardInfo("192.168.50.134",6380);
		JedisShardInfo info3 = new JedisShardInfo("192.168.50.134",6381);
		shards.add(info1);
		shards.add(info2);
		shards.add(info3);
		//获得jedis的总片
		//redis分片0
		//hash一致性
		//node和key
		//数据存储是通过hash一致性运算然后顺时针找到节点
		//如果没有均衡性,会导致数据负载不均,会导致数据丢失
		//引入虚拟节点动态平衡数据(单调性)均衡算法尽可能让节点均匀保存数据
		//节点只能增不能减少,如果少了,内存缺失,分片不能使用
		//是一个list集合
		ShardedJedis jedis = new ShardedJedis(shards);
		jedis.set("1811", "分片测试");
		System.out.println(jedis.get("1811"));
	}
}
