package com.jt.manage.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.User;
import com.jt.manage.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	/** 
	 * page域      只对当前jsp生效 
	 * request 对一次请求生效
	 * session 对当前会话生效
	 * context 服务器作用域
	 * ("/findAll")查询所有用户信息
	 */
	@RequestMapping("/login")
	public String doLogin() {
		return "login";
	}
	 
	@RequestMapping("/findAll")
	public String findList(Model model) {
		 List<User> userList=userService.findList(); 
	
		/* * user.setAge(11); user.setId(1); user.setName("wo"); user.setSex("nan");
		 * userList.add(user); //将数据保存到request域中 
		 */ 
		 model.addAttribute("userList",userList);
		return "userList";
	}
}
