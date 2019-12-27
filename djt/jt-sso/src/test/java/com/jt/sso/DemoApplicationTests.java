package com.jt.sso;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



import redis.clients.jedis.JedisCluster;


@RunWith(SpringRunner.class)//启动时加载项
@SpringBootTest //测试的支持
public class DemoApplicationTests {
	
	@Autowired
	private JedisCluster jedisCluster;
	@Test
	public void test() {
		jedisCluster.set("1809", "测试成功");
		String string = jedisCluster.get("1811");
		System.out.println(string);
	}
	
	
}
