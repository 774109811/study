package com.db.sys.dao;

import java.util.List;
import java.util.Map;

import com.db.sys.common.vo.Node;



public interface SysMenuDao {
	/**
	 * 查询zTree中要显示的menu节点信息
	 * @return
	 */
	List<Node> findZtreeMenuNodes();
	
	/**
	 * 统计菜单对应子菜单的数量
	 * @param id 菜单id
	 * @return
	 */
	int getChildCount(Integer id);
	
	/**
	 * 基于id删除菜单对象
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	
	/**
	 * 通过此方法查询所有菜单以及对应的上级菜单信息
	 * @return
	 * 1)一个Map对象用于封装表中的一行记录(key为字段名，值为字段value)
	 * 2)多条菜单记录会封装为多个map，多个map再存储到list集合
	 */
	List<Map<String,Object>> findObjects();
}







