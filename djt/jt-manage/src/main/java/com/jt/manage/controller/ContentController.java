package com.jt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.Content;
import com.jt.manage.service.ContentService;
import com.jt.manage.vo.EasyUITable;
@RequestMapping("/content")
@RestController
public class ContentController {
	@Autowired
	private ContentService contentService;
	//content/query/list?categoryId=0&page=1&rows=20
	@RequestMapping("/query/list")
	public EasyUITable findAllContent(Long categoryId,int page,int rows) {
		
		return contentService.findAllContent(categoryId,page,rows);
	}
	//content/save
	@RequestMapping("/save")
	public SysResult saveContent(Content content) {
		SysResult result=contentService.saveContent(content);
		return result;
	}
	//content/save
	@RequestMapping("/edit")
	public SysResult updateContent(Content content) {
		SysResult result=contentService.updateContent(content);
		return result;
	}
	//content/save
	@RequestMapping("/delete")
	public SysResult deleteContent(Long[] ids) {
		SysResult result=contentService.deleteContent(ids);
		return result;
	}
}
