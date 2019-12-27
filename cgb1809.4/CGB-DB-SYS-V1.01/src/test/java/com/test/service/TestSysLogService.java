package com.test.service;

import org.junit.Assert;
import org.junit.Test;

import com.db.common.vo.PageObject;
import com.db.sys.entity.SysLog;
import com.db.sys.service.SysLogService;
import com.test.TestBase;



public class TestSysLogService extends TestBase{
	@Test
	public void testFind() {
		SysLogService bean = ctx.getBean("sysLogServiceImpl", SysLogService.class);
		PageObject<SysLog> po = bean.findPageObjects("admin", 1);
		System.out.println(po.getPageSize());
		System.out.println(po.getRowCount());
	}
	@Test
	public void testdelete() {
		SysLogService bean = ctx.getBean("sysLogServiceImpl", SysLogService.class);
		int rows = bean.deleteObjects(0);
		//Assert.assertEquals(1, rows);
		System.out.println(rows);
		
	}
	@Test
	public void testDeleteObjects() {
		SysLogService bean = ctx.getBean("sysLogServiceImpl", SysLogService.class);
		int rows = bean.deleteObjects(null);
		//Assert.assertEquals(1, rows);
		System.out.println(rows);
		
	}
	
	
}
