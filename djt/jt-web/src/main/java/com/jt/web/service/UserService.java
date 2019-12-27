package com.jt.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.service.HttpClientService;
import com.jt.web.pojo.User;

public interface UserService {
	

	User findAll(String userName, Integer id);

	void saveUser(User user);

	String findUserByUP(User user);

}
