package com.jt.user.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jt.pojo.User;
import com.jt.user.mapper.UserMapper;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	//查询购物车列表

	@Override
	public List<User> findAll() {
		
		return userMapper.selectList(null);
	}
	@Transactional
	@Override
	public void saveUser(User user) {
		userMapper.insert(user);
		
	}
	
}
