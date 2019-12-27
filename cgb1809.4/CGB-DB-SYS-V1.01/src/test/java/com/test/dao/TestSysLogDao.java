package com.test.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;

import com.db.sys.dao.SysLogDao;
import com.db.sys.dao.impl.SysLogDaoImpl;
import com.db.sys.entity.SysLog;
import com.test.TestBase;
public class TestSysLogDao extends TestBase{
	  @Test
	  public void testGetRowCount(){
		 //1.获取SysLogDao对象
		 SysLogDao dao=
		 ctx.getBean("sysLogDao",SysLogDao.class);
		 //2.调用dao对象的getRowCount方法
		 int rowCount=dao.getRowCount("admin");
		 //3.输出查询结果
		 System.out.println(rowCount);
	  }
	  @Test
	  public void testFindPageObjects(){
		  //1.获取SysLogDao对象
		  SysLogDao dao=
		  ctx.getBean("sysLogDao",SysLogDao.class);
		  //2.调用dao对象的findPageObjects方法
		  List<SysLog> list=
		  dao.findPageObjects("admin",
				  0, 3);
		  //3.输出查询结果
		  System.out.println(list.size());
	  }
	  @Test
	  public void testGetRowCount1(){
		 //1.获取SysLogDao对象
		 SysLogDao dao=
		 ctx.getBean("sysLogDaoImpl",SysLogDaoImpl.class);
		 //2.调用dao对象的getRowCount方法
		 int rowCount=dao.getRowCount("admin");
		 //3.输出查询结果
		 System.out.println(rowCount);
	  }
	  @Test
	  public void testDeleteObjects(){
		  //1.获取SysLogDao对象
		  SysLogDao dao=
				  ctx.getBean("sysLogDao",SysLogDao.class);
		  //2.调用dao对象的getRowCount方法
		int ids = dao.deleteObjects(78,79);
		  //3.输出查询结果
		  System.out.println(ids);
	  }
	  
	  
}







