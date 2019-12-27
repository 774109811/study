package com.jt.manage.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jt.common.vo.PicUploadResult;
import com.jt.manage.service.FileService;

@Controller
public class FileController {
	@Autowired
	private FileService fileService;
	
	
	//实现文件上传的入门案例
	//实现文件上传后跳转到上传页面
	/**
	 * 
	 * @param  MultipartFile 文件上传的一个api
	 * @return filePic  客户端 name属性传过来的一个文件名
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("/file")
	public String file(MultipartFile filePic) throws IllegalStateException, IOException {
		//1.获取文件的名称
		String fileName=filePic.getOriginalFilename();
		//2.准备一个文件夹
		String dir= "E:/jt";
		//3.实现文件的上传
		File file=new File(dir);
		//3.1如果文件夹不存在就创建
		if(!file.exists()) {
			file.mkdirs();
		}
		//3.2 上传文件
		filePic.transferTo(new File(dir+"/"+fileName));
		
		return "redirect:/file.jsp";
	}
	
	/**
	   * 商品列表新增图片文件上传
	 * {"error":0,"url":"图片的保存路径","width":图片的宽度,"height":图片的高度} 参数说明：
	 * 0代表是一张图片，如果是0，前台才可以解析并显示。1代表不是图片， 不显示如果不设置宽度和高度，则默认用图片原来的大小，所以不用设置
	 */
	@RequestMapping("/pic/upload")
	@ResponseBody
	public PicUploadResult upLoadFile(MultipartFile uploadFile) throws IllegalStateException, IOException {
		//接收用户提交的数据,实现文件上传
		
		return fileService.upLoadFile(uploadFile);
	}
	
	
}
