package com.test.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.db.sys.dao.SysLogDao;
import com.test.TestBase;

public class ProxyDao extends TestBase {
	@Test
	public void testProxyDao() {
		SqlSessionFactory factory = 
				ctx.getBean("sqlSessionFactory",SqlSessionFactory.class);
		TestProxy testProxy = new TestProxy(factory);
		
		SysLogDao dao = testProxy.getProxy(SysLogDao.class);
		int rowCount = dao.getRowCount("admin");
		System.out.println(rowCount);
	}
}
