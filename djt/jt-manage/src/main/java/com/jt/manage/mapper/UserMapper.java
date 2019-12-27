package com.jt.manage.mapper;

import java.util.List;

import com.jt.common.mapper.SysMapper;

import com.jt.manage.pojo.User;

public interface UserMapper extends  SysMapper<User>{
	List<User> findList();

	User findUserByUserName(String username);
}
