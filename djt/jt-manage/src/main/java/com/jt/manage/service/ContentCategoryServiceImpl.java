package com.jt.manage.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.vo.SysResult;
import com.jt.manage.mapper.ContentCategoryMapper;
import com.jt.manage.pojo.ContentCategory;
import com.jt.manage.vo.EasyUITreeNode;
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	@Autowired
	private ContentCategoryMapper contentCategoryMapper;
	@Override
	public List<EasyUITreeNode> findContentCategory(Long parentId) {
			ContentCategory content = new ContentCategory();
			content.setParentId(parentId);
			//根据父类id查询所有集合
			List<ContentCategory> list = contentCategoryMapper.select(content);
			//把这个集合信息封装到EasyUITreeNode
			
			List<EasyUITreeNode> arrayList = new ArrayList<>();
			for (ContentCategory content1 : list) {
				EasyUITreeNode node = new EasyUITreeNode();
				node.setId(content1.getId());
				node.setText(content1.getName());
				//1是closed,0是open
				String state=content1.getIsParent()?"closed":"open";
				
				node.setState(state);
				arrayList.add(node);
			}
			return arrayList;
	}
	/* (non-Javadoc)
	 * @see com.jt.manage.service.ContentCategoryService#saveContent(java.lang.Long, java.lang.String)
	 */
	@Override
	public SysResult saveContent(Long parentId, String name) {
		ContentCategory node = new ContentCategory();
		Date date = new Date();
		node.setCreated(date);
		node.setUpdated(node.getCreated());
		node.setParentId(parentId);
		node.setName(name);
		node.setStatus(1);
		node.setIsParent(false);
		node.setSortOrder(1);
		contentCategoryMapper.insert(node);
		ContentCategory parentnode = contentCategoryMapper.selectByPrimaryKey(parentId);
		System.out.println(parentnode);
		//如果不是父节点
		if(!parentnode.getIsParent()) {
			//把它修改为父节点
			parentnode.setIsParent(true);
			contentCategoryMapper.updateByPrimaryKey(parentnode);
			
		}
		return SysResult.oK(node);
	}
	@Override
	public SysResult deleteNode(Long parentId, Long id) {
		ContentCategory node = new ContentCategory();
		node.setId(id);
		node.setParentId(parentId);
	
	
			contentCategoryMapper.delete(node);
		
		
		return SysResult.oK(node);
	}

}
