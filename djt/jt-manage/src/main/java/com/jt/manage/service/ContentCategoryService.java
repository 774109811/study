package com.jt.manage.service;

import java.util.List;

import com.jt.common.vo.SysResult;
import com.jt.manage.vo.EasyUITreeNode;

public interface ContentCategoryService {

	List<EasyUITreeNode> findContentCategory(Long parentId);

	SysResult saveContent(Long parentId, String name);

	SysResult deleteNode(Long parentId, Long id);

}
