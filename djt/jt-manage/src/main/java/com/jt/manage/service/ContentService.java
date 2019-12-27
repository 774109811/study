package com.jt.manage.service;

import java.util.List;

import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.Content;
import com.jt.manage.vo.EasyUITable;

public interface ContentService {

	EasyUITable findAllContent(Long categoryId, int page, int rows);

	SysResult saveContent(Content content);

	SysResult updateContent(Content content);

	SysResult deleteContent(Long []ids);

	List<Content> getContentList(Long contentCategoryId);

}
