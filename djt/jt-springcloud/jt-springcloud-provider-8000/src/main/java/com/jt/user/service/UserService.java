package com.jt.user.service;

import java.util.List;

import com.jt.pojo.User;


public interface UserService {

	List<User> findAll();

	void saveUser(User user);



}
