package com.test;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class TestMybatis extends TestBase {
	@Test
	public void testSqlSessionFactory() {
		SqlSessionFactory bean = ctx.getBean("sqlSessionFactory",SqlSessionFactory.class);
		
		System.out.println(bean);
	}
}
