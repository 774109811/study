package com.jt.web.controller;

import java.io.IOException;
import java.util.concurrent.Semaphore;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.jt.common.vo.SysResult;
import com.jt.web.pojo.User;
import com.jt.web.service.UserService;

import redis.clients.jedis.JedisCluster;
@RequestMapping("/user")
@Controller
public class UserController {
	//http://www.jt.com/user/register.html 注册网页
	//http://www.jt.com/user/login.html 登录页面
	@Autowired
	private JedisCluster jedisCluster;
	@Autowired
	private UserService userService;
	@RequestMapping("/{moduleName}")
	public String index(@PathVariable String moduleName) {
		return moduleName;
	}
	//service伪静态
	//http://www.jt.com/service/user/doRegister
	//实现前台的用户新增
	@RequestMapping("/doRegister")
	@ResponseBody //返回json串   /service/**
	public SysResult saveUser(User user) {
		userService.saveUser(user);
		return SysResult.oK();
	}
	//http://www.jt.com/service/user/doLogin
	//实现前台登录跳转后台单点登录
	/**
	 * cookie.setMaxAge(值);
	 * 值>0  	表示存活时间 单位秒
	 * 值=0  	立即删除cookie
	 * 值=-1  会话结束时删除cookie
	 * cookie.setPath("/"); 
	 *  /表示cookie的权限问题  表示根
	 *  /user/aa/bb  只有位于/user/aa/bb下的页面才能获取cookie信息
	 *  
	 * @param user
	 * @param response
	 * @return
	 */
	private Semaphore smphore=new Semaphore(1,true);
	@RequestMapping("/doLogin")
	@ResponseBody//返回json  /service/**
	public SysResult doLogin(User user, HttpServletResponse response) {
		try {
			smphore.acquire();
			//1.将业务层获取到的token
		String token=userService.findUserByUP(user);
			//2.验证token数据	
		if(!StringUtils.isEmpty(token)) {
				//如果token有数据,则保存到cookie中
				Cookie cookie = new Cookie("JT_TICKET", token);
				cookie.setMaxAge(7*24*3600);
				cookie.setPath("/");
				response.addCookie(cookie);
				return SysResult.oK();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SysResult.build(201,"登录失败");
	}
	//先获取cookie
	//实现用户退出操作 1.删除cookie 2.删除redis,3重定向到首页
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		//获取cookies
		Cookie[] cookies = request.getCookies();
		//遍历tooken
		String token = null;
		for (Cookie cookie : cookies) {
			if("JT_TICKET".equals(cookie.getName())){
				//获取cookie的值
				token = cookie.getValue();
				break;
			}
		}
		//删除redis
		jedisCluster.del(token);
		//删除cookie   设置cookie
		Cookie cookie = new Cookie("JT_TICKET","");
		//立即删除
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		smphore.release();
		//执行完成后,将页面跳转到系统首页
		return "redirect:/index.html";
	}	


	

}
