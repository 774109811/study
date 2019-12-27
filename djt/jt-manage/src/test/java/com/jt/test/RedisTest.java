package com.jt.test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.Transaction;

public class RedisTest {
	/**
	 * 1.通过ip和端口连接redis
	 * 2.操作的方法就是命令
	 * @throws InterruptedException 
	 */
	@Test
	public void stringTest() throws InterruptedException {
		Jedis jedis = new Jedis("192.168.50.134",6379);
		String result = jedis.set("1811","今天天气不错");
		//超时时间
		jedis.expire("1811", 20);
		Thread.sleep(3000);//后期维护时去掉
		Long time = jedis.ttl("1811");
		//撤销失效时间
		jedis.persist("1811");
		System.out.println("还能存活"+time+"秒");
		System.out.println("保存后的值"+result);
		System.out.println("获取数据"+jedis.get("1811"));
	
	}
	
	//操作hash
	@Test
	public void testHash() {
		Jedis jedis = new Jedis("192.168.50.134",6379);
		jedis.hset("dog","name","erha");
		jedis.hset("dog","age","7");
		Map<String, String> hgetAll = jedis.hgetAll("dog");
		System.out.println(hgetAll);
	}
	//list集合类型
	//该数据类型,不能长期保存数据,数据最终会被消费
	@Test
	public  void testList() {
		Jedis jedis = new Jedis("192.168.50.134",6379);
		 jedis.rpush("list", "1","2","3");
		 String a = jedis.rpop("list");
		 System.out.println(a);
	}
	//事务控制
	@Test
	public  void testTx() {
		Jedis jedis = new Jedis("192.168.50.134",6379);
		Transaction tx = jedis.multi();
		try {
			tx.set("key", "key");
			tx.set("ww", "ww");
			int a =1/0;
			tx.exec();
		} catch (Exception e) {
			tx.discard();
		}
		
	}
	/**
	 * @masterName 主机变量名称
	 * @sentinels 哨兵的信息
	 * String =IP:端口192.168.50.134:26379
	 */
	@Test
	public void testSentinel() {
		Set<String> sentinels=new HashSet<>();
		sentinels.add("192.168.50.134:26379");
		
		JedisSentinelPool pool =new JedisSentinelPool("mymaster", sentinels);
		Jedis jedis = pool.getResource();
		jedis.set("aa", "dd");
		System.out.println("获取redis数据"+jedis.get("aa"));
		jedis.close();
	}
	@Test
	public void testCluster() {
		String host="192.168.50.134";
		HashSet<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort(host, 7000));
		nodes.add(new HostAndPort(host, 7001));
		nodes.add(new HostAndPort(host, 7002));
		nodes.add(new HostAndPort(host, 7003));
		nodes.add(new HostAndPort(host, 7004));
		nodes.add(new HostAndPort(host, 7005));
		nodes.add(new HostAndPort(host, 7006));
		nodes.add(new HostAndPort(host, 7007));
		nodes.add(new HostAndPort(host, 7008));
		JedisCluster jedisCluster = new JedisCluster(nodes);
		jedisCluster.set("1811", "11 12 13");
		
		System.out.println(jedisCluster.get("1811"));
	}
	
	
}
