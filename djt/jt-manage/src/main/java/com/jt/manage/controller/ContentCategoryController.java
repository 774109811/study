package com.jt.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jt.common.vo.SysResult;
import com.jt.manage.service.ContentCategoryService;
import com.jt.manage.vo.EasyUITreeNode;
@RequestMapping("/content/category")
@RestController
public class ContentCategoryController {
	@Autowired
	private ContentCategoryService contentCategoryService;
	//根据父类id查询子类id
	@RequestMapping("/list")

	public List<EasyUITreeNode> findContentCategory(@RequestParam(value="id",defaultValue="0")Long parentId ) {
		return contentCategoryService.findContentCategory(parentId);
	}
	//content/category/create
	@RequestMapping("/create")

	public SysResult saveContent(Long parentId,String name) {
		
		SysResult result = contentCategoryService.saveContent(parentId,name);
		return result;
	}
	//content/category/delete/
	@RequestMapping("/delete")
	public SysResult deleteNode(Long parentId,Long id) {
		SysResult result = contentCategoryService.deleteNode(parentId,id);
		return result;
	}
	
	
}
