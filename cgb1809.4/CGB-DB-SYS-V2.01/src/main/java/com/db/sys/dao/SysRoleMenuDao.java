package com.db.sys.dao;

public interface SysRoleMenuDao {
	
	/**
	 * 基于菜单id删除角色菜单关系表中的数据
	 * @param menuId
	 * @return
	 */
	int deleteObjectsByMenuId(Integer menuId);
	
	
}
