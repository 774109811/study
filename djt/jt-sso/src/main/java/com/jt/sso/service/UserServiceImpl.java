package com.jt.sso.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.sso.mapper.UserMapper;
import com.jt.sso.pojo.User;
import com.jt.sso.util.ObjectMapperUtil;

import redis.clients.jedis.JedisCluster;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private JedisCluster jedisCluster;
	@Override
	public List<User> findAll() {
		
		return   userMapper.selectList(null);
	}
	//ajax,实现查询用户名和电话是否有相同的
	@Override
	public boolean findCheckUser(String param, Integer type) {
		String column=null;
		switch (type) {
		case 1:
			column="username";
			break;
		case 2:
			column="phone";
			break;
		case 3:
			column="email";
			break;
		}
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq(column, param);
		int count = userMapper.selectCount(queryWrapper);
		return count==0?false:true;
	}
	//注册用户实现
	@Transactional	
	@Override
	public void saveUser(User user) {
		user.setCreated(new Date()).setUpdated(user.getCreated()).setEmail(user.getPhone());
		userMapper.insert(user);	
	}
	@Override
	public String findUserByUP(User user) {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		//用数据库的和用户输入的进行比对
		queryWrapper.eq("username", user.getUsername()).eq("password", user.getPassword());
		//token为唯一秘钥
		String token=null;
		//查询数据库的数据
		User userDb = userMapper.selectOne(queryWrapper);
		if(userDb!=null) {
			//生成唯一的token
			String tokenS="JT_TICKET_" + System.currentTimeMillis()+user.getUsername();
			token = DigestUtils.md5DigestAsHex(tokenS.getBytes());
			//在保存数据到redis前为了保证数据安全,把密码设置为空
			userDb.setPassword("");
			String json = ObjectMapperUtil.toJSON(userDb);
			//将用户信息保存到redis中
			jedisCluster.set(token, json);
		}
		return token;
	}

}
