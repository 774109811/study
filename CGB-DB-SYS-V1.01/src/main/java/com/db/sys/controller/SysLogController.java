package com.db.sys.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.db.common.vo.JsonResult;
import com.db.common.vo.PageObject;
import com.db.sys.entity.SysLog;
import com.db.sys.service.SysLogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 日志管理的控制层对象
 * @Controller注解
 * 用于描述这个对象要交给spring管理，
 * 可以认为是spring中的一个bean对象。
 * @RequestMapping 用于定义此controller对象
 * 的一个根路径映射，当访问某个方法时，方法映射
 * 路径的前面都会加上这个根路径
 */
@Controller
@RequestMapping("/log/")
public class SysLogController {
	  
	  @Autowired
	  private SysLogService sysLogService;
	  /**
	   * 通过此方法返回日志列表页面
	   * 方法映射：建议和方法名相同
	   * 思考：如下方法如何被调用？反射技术
	   */
	  @RequestMapping("doLogListUI")
	  public String doLogListUI(){
		  //此值会交给视图解析器进行解析
		  return "sys/log_list";
		  //WEB-INF/pages/sys/log_list.html
	  }
	  //../log/doFindPageObjects.do?pageCurrent=1
	  @RequestMapping("doFindPageObjects")
	  @ResponseBody
	  public JsonResult doFindPageObjects(   
			  String username,
			  Integer pageCurrent){
		  PageObject<SysLog> pageObject=
		  sysLogService.findPageObjects(username,
				  pageCurrent);
		  return new JsonResult(pageObject);
	  }
	/*@RequestMapping("doFindPageObjects")
	  @ResponseBody
	  public String doFindPageObjects(   
			  String username,
			  Integer pageCurrent)throws JsonProcessingException{
		  PageObject<SysLog> pageObject=
				  sysLogService.findPageObjects(username,
						  pageCurrent);
		  JsonResult r=new JsonResult(pageObject);
		  //return "{\"id\":10,\"name\":\"dawei\"}";
		  //将r对象转换为json格式的字符串
		 return new ObjectMapper() //jackson 中的api
				 .writeValueAsString(r);
	  }*/
	  
	  
	  
	  
	  //将方法返回值转换为json格式的字符串返回
	  //在将对象转换为json格式字符串时会调用对象的get方法获取值
	  
	  @ExceptionHandler(IllegalArgumentException.class)
	  @ResponseBody
	  public JsonResult doHandleException(
			  IllegalArgumentException e){
		  System.out.println("SysLogController.doHandleException");
		  e.printStackTrace();
		  return new JsonResult(e);
	  }
 
}
