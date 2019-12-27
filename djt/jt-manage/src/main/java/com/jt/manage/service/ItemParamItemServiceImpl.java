package com.jt.manage.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.util.ObjectMapperUtil;
import com.jt.common.vo.SysResult;
import com.jt.manage.mapper.ItemParamMapper;
import com.jt.manage.mapper.TBItemParamItemMapper;
import com.jt.manage.pojo.ItemParam;
import com.jt.manage.pojo.TbItemParamItem;


@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {
	
	@Autowired
	private ItemParamMapper itemParamMapper;

	@Override
	public String geParamItemByItemId(Long itemCatId) {
		ItemParam example = new ItemParam();
		
		example.setItemCatId(itemCatId);
		List<ItemParam> list = itemParamMapper.select(example);
		if (null == list || list.isEmpty()) {
			return "";
		}
		//取出参数信息
		ItemParam itemParam= list.get(0);
		String paramData = itemParam.getParamData();
		//把json数据转换成java对象
		List<Map> paramList = ObjectMapperUtil.jsonToList(paramData, Map.class);
		//将参数信息转换成html
		StringBuffer sb = new StringBuffer(); 
		//sb.append("<div>");
		sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"1\" class=\"Ptable\">\n");
		sb.append("    <tbody>\n");
		for (Map map : paramList) {
			sb.append("        <tr>\n");
			sb.append("            <th class=\"tdTitle\" colspan=\"2\">"+map.get("group")+"</th>\n");
			sb.append("        </tr>\n");
			List<Map> params = (List<Map>) map.get("params");
			for (Map map2 : params) {
				sb.append("        <tr>\n");
				sb.append("            <td class=\"tdTitle\">"+map2.get("k")+"</td>\n");
				sb.append("            <td>"+map2.get("v")+"</td>\n");
				sb.append("        </tr>\n");
			}
		}
		sb.append("    </tbody>\n");
		sb.append("</table>");
		//sb.append("</div>");
		return sb.toString();
		
		
	}
	}
	
	
	
	

	
	


