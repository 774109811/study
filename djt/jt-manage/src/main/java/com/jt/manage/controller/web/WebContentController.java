package com.jt.manage.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.Content;
import com.jt.manage.service.ContentService;

@RestController
@RequestMapping("/content")
public class WebContentController {
	@Autowired
	private ContentService contentService;
	@RequestMapping("/list/{contentCategoryId}")
	public SysResult getContentList(@PathVariable Long contentCategoryId) {
		try {
			List<Content> list = contentService.getContentList(contentCategoryId);
			return SysResult.oK(list);
		} catch (Exception e) {
			e.printStackTrace();
			return SysResult.build(201, "查询失败");
		}
	}
}
