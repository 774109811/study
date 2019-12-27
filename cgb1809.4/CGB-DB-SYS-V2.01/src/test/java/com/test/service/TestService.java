package com.test.service;

import org.junit.Test;

import com.db.sys.common.vo.PageObject;
import com.db.sys.entity.SysLog;
import com.db.sys.service.SysLogService;
import com.db.sys.service.Impl.SysLogServiceImpl;
import com.test.TestBase;

public class TestService extends TestBase {
	@Test
	public void testService() {
		SysLogService bean = ctx.getBean("sysLogServiceImpl", SysLogServiceImpl.class);
		PageObject<SysLog> po = bean.findPageObjects("", 1);
		System.out.println(po.getPageSize());
		System.out.println(po.getPageCurrent());
		System.out.println(po.getRowCount());
	}
}
