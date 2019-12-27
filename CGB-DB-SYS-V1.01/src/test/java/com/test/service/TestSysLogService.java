package com.test.service;
import org.junit.Test;

import com.db.common.vo.PageObject;
import com.db.sys.entity.SysLog;
import com.db.sys.service.SysLogService;
import com.test.TestBase;
public class TestSysLogService extends TestBase {
	@Test
	public void testFindPageObjects(){
		//1.获取SysLogService对象
		SysLogService sysLogService=
		ctx.getBean("sysLogServiceImpl",
				SysLogService.class);
		//2.执行分页查询操作
		PageObject<SysLog> po=
		sysLogService.findPageObjects(
				"admin",1);
		System.out.println(po.getRowCount());
		System.out.println(po.getPageCount());
	}
}
