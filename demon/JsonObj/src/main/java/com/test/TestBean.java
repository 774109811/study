package com.test;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

public class TestBean {
	@Test
	public void testB() {
		School school = new School();
		school.setId(""+11);
		school.setName("小米");
		school.setDate("22222222");
		User user = new User();
	
		BeanUtils.copyProperties(school, user);
		System.out.println(user);
	}
}
