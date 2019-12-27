package com.jt.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jt.demo.mapper.UserMapper;
import com.jt.demo.pojo.User;

import redis.clients.jedis.JedisCluster;


@RunWith(SpringRunner.class)//启动时加载项
@SpringBootTest //测试的支持
public class DemoApplicationTests {
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void contextLoads() {
		List<User> findAll = userMapper.findAll();
		System.out.println(findAll);
		
	}
	@Test
	public void save() {
		User user = new User();
		user.setAge(11).setName("王").setSex("nan");
		userMapper.insert(user);
		
	}
	@Test
	public void update() {
		User user = new User();
		user.setAge(21);
		UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
		//updateWrapper.eq("name", "王");
		//年龄lt小于18的修改
		//gt是大于的意思
		//eq是相等的意思
		updateWrapper.lt("age", 18);
		userMapper.update(user, updateWrapper);	
		System.out.println("修改成功");
	}
	@Test
	public void del() {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("name", "王");
		userMapper.delete(queryWrapper);
		System.out.println("删除成功");
		userMapper.deleteById(46);
		ArrayList<User> arrayList = new ArrayList<>();
	
	}
	@Autowired
	private JedisCluster jedisCluster;
	@Test
	public void test() {
		jedisCluster.set("1811", "测试成功");
		String string = jedisCluster.get("1811");
		System.out.println(string);
	}
	
	
}
