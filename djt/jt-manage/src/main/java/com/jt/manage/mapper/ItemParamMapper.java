package com.jt.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jt.common.mapper.SysMapper;

import com.jt.manage.pojo.ItemParam;


public interface ItemParamMapper extends SysMapper<ItemParam> {
	List<ItemParam> findAllLimit(@Param("start") Integer start,@Param("rows")int rows);
	@Select("select * from tb_item_param where itemCatId=#{itemCatId}")
	ItemParam sslect(Long itemCatId);

}
