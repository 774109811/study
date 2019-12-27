package com.jt.manage.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.vo.SysResult;
import com.jt.manage.mapper.ContentMapper;
import com.jt.manage.pojo.Content;
import com.jt.manage.vo.EasyUITable;
@Service
public class ContentServiceImpl implements ContentService{
	@Autowired
	private ContentMapper contentMapper;
	@Override
	public EasyUITable<Content> findAllContent(Long categoryId, int page, int rows) {
		Content content = new Content();
		content.setCategoryId(categoryId);
		int total = contentMapper.selectCount(null);
		int start=(page-1)*rows;
		
		List<Content> findlimit = contentMapper.findAllLimit(start, rows);
		EasyUITable<Content> node = new EasyUITable<Content>();
		node.setRows(findlimit);
		node.setTotal(total);
		// total;//记录总数 给分页的数
		// rows;
		
		return node;
	}
	@Override
	public SysResult saveContent(Content content) {
		Date date = new Date();
		content.setCreated(date);
		content.setUpdated(content.getCreated());
		 contentMapper.insert(content);
		return SysResult.oK();
	}
	@Override
	public SysResult updateContent(Content content) {
		
		content.setUpdated(new Date());
		contentMapper.updateByPrimaryKey(content);

		return  SysResult.oK();
	}
	@Override
	public SysResult deleteContent(Long[] ids) {
		contentMapper.deleteByIDS(ids);		
		return SysResult.oK();
	}
	
	
	//前台页面展现数据库查询出来的数据广告
	@Override
	public List<Content> getContentList(Long contentCategoryId) {
		Content content = new Content();
		content.setCategoryId(contentCategoryId);
		List<Content> contentlist = contentMapper.select(content);
		return contentlist;
	}

}
