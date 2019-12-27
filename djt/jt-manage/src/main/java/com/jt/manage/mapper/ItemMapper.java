package com.jt.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jt.common.mapper.SysMapper;
import com.jt.manage.pojo.Item;
//扩展接口方法,继承通用mapper  SysMapper<Item>查询的就是商品对象
public interface ItemMapper extends SysMapper<Item> {
	/**
	 * 如果单表查询可以通过注解的形式进行编辑
	 * @return
	 * ctrl+shift+y大写+x小写
	 */
	@Select("select count(*) from tb_item")
	int findItemCount();
	/**
	 * Mybatis中传值要求
	 * 	规定:mybatis中不允许多值传参
	 *  如果需要多值传参,则将多值转化单值
	 *  1.使用对象进行封装  insert update
	 *  2.使用集合封装   list array Map<k,v> 
	 * @param start
	 * @param rows
	 * @return 根据分页limit查询商品信息并展现出来
	 */
	
	List<Item> findItemListByPage(@Param("start") Integer start,@Param("rows")  int rows);
	
	/** 
	 * @param itemCatId 根据外检id查询商品分类的名字并展现出来
	 * @return
	 */
	@Select("select name from tb_item_cat where id=#{itemCatId}")
	String findItemCatNameById(Long itemCatId);
	//基于ids批量修改状态值
	void updateStatus(@Param("ids") Long[] ids,@Param("status") int status);
	
	
	
}
