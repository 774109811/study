package com.test.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class TestProxy implements InvocationHandler {
	private SqlSessionFactory factory;
	
	
	public TestProxy(SqlSessionFactory factory) {
		super();
		this.factory = factory;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		SqlSession session = factory.openSession();
		Object dao 
		= session.getMapper(proxy.getClass().getInterfaces()[0]);
		Object result = method.invoke(dao, args);
		session.close();
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public <T>T getProxy(Class<?> targetCls){
		return (T) Proxy.newProxyInstance(targetCls.getClassLoader(),
				new Class[] {targetCls}, this);
		
	
	}	
}


