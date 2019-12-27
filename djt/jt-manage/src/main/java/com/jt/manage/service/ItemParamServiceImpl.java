package com.jt.manage.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.vo.SysResult;
import com.jt.manage.mapper.ItemParamMapper;
import com.jt.manage.pojo.ItemParam;
import com.jt.manage.pojo.TbItemParamItem;
import com.jt.manage.vo.EasyUITable;
@Service
public class ItemParamServiceImpl implements ItemParamService {
	@Autowired
	private ItemParamMapper itemParamMapper;
	@Override
	public EasyUITable<ItemParam> findAllLimit(int page, int rows) {
		int total = itemParamMapper.selectCount(null);
		int start=(page-1)*rows;
		List<ItemParam> findAllLimit = itemParamMapper.findAllLimit(start, rows);
		
		EasyUITable<ItemParam> node = new EasyUITable<>();
		
		node.setRows(findAllLimit);
		node.setTotal(total);
		
		return node;
	}
	//实现根据商品类目id 展现商品规格信息
	@Override
	public SysResult findItemParamByItemPCId(Long cid) {
		//根据cid查询数据库
			ItemParam itemParam = new ItemParam();
			itemParam.setItemCatId(cid);
			List<ItemParam> list = (List<ItemParam>) itemParamMapper.selectByPrimaryKey(itemParam);
			//如果查询中有结果返回查询结果
			if (list != null && list.size()>0) {
				return SysResult.oK(list.get(0));
			}
			//查询成功但是没有查到数据
			return SysResult.oK();
	
	}
	@Override
	public SysResult saveItemParam(Long cid, String paramData) {
		//创建TbItemParam对象
		ItemParam param = new ItemParam();
		
		param.setCreated(new Date());
		param.setUpdated(new Date());
		//向数据库添加数据
		itemParamMapper.insert(param);
		
		return SysResult.oK();
	}
	@Override
	public SysResult deleteContent(Long[] ids) {
		itemParamMapper.deleteByIDS(ids);		
		return SysResult.oK();
	}
	@Override
	public SysResult saveItemParam(ItemParam itemParam) {
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		itemParamMapper.insert(itemParam);
		return SysResult.oK();
	}
	




}
