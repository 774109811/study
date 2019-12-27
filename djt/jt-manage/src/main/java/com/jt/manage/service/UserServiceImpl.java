package com.jt.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.manage.mapper.UserMapper;
import com.jt.manage.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	//查询所有用户信息
	@Override
	public List<User> findList() {
		// TODO Auto-generated method stub
		return userMapper.findList();
	}

}
