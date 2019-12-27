package com.jt.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.demo.mapper.UserMapper;
import com.jt.demo.pojo.User;
@Controller
public class UserController {
	@Autowired
	private UserMapper userMapper;
	@RequestMapping("/findAll")
	public String getuser(Model model) {
	
		List<User> selectList = userMapper.selectList(null);
		model.addAttribute("userList", selectList );
		return "userList";
	}
}
