package com.db.sys.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.sys.common.exception.ServiceException;
import com.db.sys.common.vo.Node;
import com.db.sys.dao.SysMenuDao;
import com.db.sys.dao.SysRoleMenuDao;
import com.db.sys.service.SysMenuService;

@Service
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	
	
	@Override
	public List<Node> findZtreeMenuNodes() {
		List<Node> list=sysMenuDao.findZtreeMenuNodes();
		if(list==null||list.size()==0)
		throw new ServiceException("记录不存在");
		return list;
	}
	
	@Override
	public int deleteObject(Integer id) {
		//1.验证参数有效性
		if(id==null||id<1)
		throw new IllegalArgumentException("参数id无效");
		//2.统计菜单是否有子菜单，并进行验证
		int rowCount=sysMenuDao.getChildCount(id);
		if(rowCount>0)
		throw new ServiceException("请先删除子菜单");
		//3.删除当前菜单信息
		int rows=sysMenuDao.deleteObject(id);
		if(rows==0)
		throw new ServiceException("记录可能已经不存在");
		//4.删除菜单角色的关系数据
		sysRoleMenuDao.deleteObjectsByMenuId(id);
		return rows;
	}
	
	@Override
	public List<Map<String, Object>> findObjects() {
		List<Map<String, Object>> list=sysMenuDao.findObjects();
		if(list==null||list.size()==0)
		throw new ServiceException("没有对应数据");
		return list;
	}

}
