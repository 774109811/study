package com.jt.manage.service;

import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.ItemDesc;
import com.jt.manage.pojo.ItemParam;
import com.jt.manage.pojo.TbItemParamItem;
import com.jt.manage.vo.EasyUITable;

public interface ItemParamService {

	EasyUITable findAllLimit(int page, int rows);

	

	SysResult findItemParamByItemPCId(Long cid);



	SysResult saveItemParam(Long cid, String paramData);



	SysResult deleteContent(Long[] ids);



	SysResult saveItemParam(ItemParam itemParam);



}
