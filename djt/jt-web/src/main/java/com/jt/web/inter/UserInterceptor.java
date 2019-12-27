package com.jt.web.inter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jt.common.util.ObjectMapperUtil;
import com.jt.web.pojo.User;
import com.jt.web.util.UserThreadLocal;

import redis.clients.jedis.JedisCluster;




public class UserInterceptor implements HandlerInterceptor {
	@Autowired
	private JedisCluster jedisCluster;
	//执行controller前
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception { 
		
		//http://www.jt.com/cart/show.html
		//1.判断用户是否登陆
		//2.如果登陆就放行
		//3.没有登陆就重定向登陆页面
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			String token=null;
			for (Cookie cookie : cookies) {
				if("JT_TICKET".equals(cookie.getName())) {
					token=cookie.getValue();
					break;
				}
			}
			if(!StringUtils.isEmpty(token)) {
				String userJson = jedisCluster.get(token);
				if(!StringUtils.isEmpty(userJson)) {
				User user = ObjectMapperUtil.toObject(userJson, User.class);
				request.setAttribute("JT_USER",user);
				//使用threadLocal封装数据
				UserThreadLocal.set(user);
				return true;
				}
			}
		}
		response.sendRedirect("/user/login.html");
		return false;
	}
	//执行controller之后
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}
	//viewreserver   关闭连接/关闭流(大文件的输出和输入)/删除某些不需要的对象防止内存泄漏
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 方法执行完成后删除对象
		UserThreadLocal.remove();

	}

}
