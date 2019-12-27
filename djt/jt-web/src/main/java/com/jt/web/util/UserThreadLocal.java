package com.jt.web.util;

import com.jt.web.pojo.User;

public class UserThreadLocal {
	private static ThreadLocal<User> userThreadLocal =new ThreadLocal<>();
	public static void set(User user) {
		userThreadLocal.set(user);
	}
	public static User get() {
		return userThreadLocal.get();
	}
	//删除使用的对象
	public static void remove() {
		userThreadLocal.remove();
	}
}
