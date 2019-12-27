package com.jt.test;

import java.util.Calendar;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {
	@Test
	public void testFactory() {
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("/spring/factory.xml");
		Calendar bean = (Calendar) applicationContext.getBean("calendar2");
		System.out.println("当前时间"+bean.getTime());
	}
}
