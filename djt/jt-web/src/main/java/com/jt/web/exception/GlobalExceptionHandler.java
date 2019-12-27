package com.jt.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.SysResult;

/**
 * @ControllerAdvice 此注解描述的类
 * 称之为全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {
		/**
	   * @ExceptionHandler 对象描述的方法为一个异常处理方法
	   * @ExceptionHandler 内部定义的异常处理类型为本方法
	   * 可以处理的异常
	   * @param e
	   * @return
	   */
	  @ExceptionHandler(Exception.class)
	  @ResponseBody
	  public SysResult doHandleException(
			  Exception e){
		  System.out.println("GlobalExceptionHandler.doHandleException");
		  e.printStackTrace();
		  //System.out.println(e instanceof ServiceException);
		  return SysResult.build(201, "系统正在维护,请稍后再试");//封装异常
	  }
	  @ExceptionHandler(Throwable.class)
	  @ResponseBody
	  public SysResult doHandleThrowable(
			  Throwable e){
		  e.printStackTrace();
		
		  //给运维人员发短信
		  return SysResult.build(201, "系统正在维护,请稍后再试");
	  }
	  
}
