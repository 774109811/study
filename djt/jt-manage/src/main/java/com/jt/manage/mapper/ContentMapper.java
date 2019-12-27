package com.jt.manage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jt.common.mapper.SysMapper;
import com.jt.manage.pojo.Content;

public interface ContentMapper extends SysMapper<Content> {
	List<Content> findAllLimit(@Param("start") Integer start,@Param("rows")int rows);
}
