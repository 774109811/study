package com.db.sys.service;
import java.util.List;
import java.util.Map;

import com.db.sys.common.vo.Node;
public interface SysMenuService {
	 List<Node> findZtreeMenuNodes();
	
	 List<Map<String,Object>> findObjects();
	 /**
	  * 基于菜单id删除菜单以及菜单与角色的关系数据
	  * @param id
	  * @return
	  */
	 int deleteObject(Integer id);
	 
	 
}
