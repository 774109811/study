package com.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
public class TestExcel {
	public static void main(String[] args) {
		List<?> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd", DateUtil.date(), 3.22676575765);
		List<?> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1", DateUtil.date(), 250.7676);
		List<?> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2", DateUtil.date(), 0.111);
		List<?> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3", DateUtil.date(), 35);
		List<?> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4", DateUtil.date(), 28.00);

		List<List<?>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);

		BigExcelWriter writer= ExcelUtil.getBigWriter("c:/111.xlsx");
		// 一次性写出内容，使用默认样式
		writer.write(rows);
		// 关闭writer，释放内存
		writer.close();
		
	}
	
	@Test
	public void push( HttpServletResponse response) throws IOException {
		Map<String, Object> row1 = new LinkedHashMap<String, Object>();
		row1.put("姓名", "张三");
		row1.put("年龄", 23);
		row1.put("成绩", 88.32);
		row1.put("是否合格", true);
		row1.put("考试日期", DateUtil.date());

		Map<String, Object> row2 = new LinkedHashMap<String, Object>();
		row2.put("姓名", "李四");
		row2.put("年龄", 33);
		row2.put("成绩", 59.50);
		row2.put("是否合格", false);
		row2.put("考试日期", DateUtil.date());

		ArrayList<Map<String, Object>> rows = CollUtil.newArrayList(row1, row2);
		
		// 通过工具类创建writer，默认创建xls格式
		ExcelWriter writer = ExcelUtil.getWriter();
		// 一次性写出内容，使用默认样式，强制输出标题
		writer.write(rows, true);
		//out为OutputStream，需要写出到的目标流

		//response为HttpServletResponse对象
		response.sendRedirect("www.baidu.com");
		response.setContentType("application/vnd.ms-excel;charset=utf-8"); 
		//test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
		response.setHeader("Content-Disposition","attachment;filename="+"a"+"xls"); 
		ServletOutputStream out=response.getOutputStream(); 

		writer.flush(out, true);
		
		// 关闭writer，释放内存
		writer.close();
		//此处记得关闭输出Servlet流
		IoUtil.close(out);
		/*
		 * // 通过工具类创建writer ExcelWriter writer = ExcelUtil.getWriter("c:/成绩.xlsx"); //
		 * 合并单元格后的标题行，使用默认标题样式 writer.merge(row1.size() - 1, "一班成绩单"); //
		 * 一次性写出内容，使用默认样式，强制输出标题 writer.write(rows, true); // 关闭writer，释放内存
		 * writer.close();
		 */
	}
	
}
