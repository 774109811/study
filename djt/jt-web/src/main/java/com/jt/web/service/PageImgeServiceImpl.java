package com.jt.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.common.service.HttpClientService;
import com.jt.common.util.ObjectMapperUtil;
import com.jt.common.vo.SysResult;
import com.jt.web.pojo.ADitem;
import com.jt.web.pojo.Content;
@Service
public class PageImgeServiceImpl implements PageImgeService{
	@Autowired
	private HttpClientService httpClient;

	@Override
	public String getAdItemList() {
		//调用服务层的服务查询打广告位的数据
		String url="http://manage.jt.com/content/list/9";
				String result = httpClient.doGet(url);
				//把json数据转换成对象
				SysResult sysResut = SysResult.formatToList(result, Content.class);
				
				List<ADitem> itemList = new ArrayList<>();
				if (sysResut.getStatus() == 200 ) {
					//List<Content> contentList = (List<Content>) SysResult.getData();
					
					@SuppressWarnings("unchecked")
					List<Content> contentList = (List<Content>) sysResut.getData();
					for (Content tbContent : contentList) {
						ADitem item = new ADitem();
						item.setHeight(240);
						item.setWidth(670);
						item.setSrc(tbContent.getPic());
						item.setHeightB(240);
						item.setWidth(670);
						item.setSrcB(tbContent.getPic2());
						item.setAlt(tbContent.getTitleDesc());
						item.setHref(tbContent.getUrl());
						itemList.add(item);
					}
					
				}
				return ObjectMapperUtil.toJSON(itemList);
	}

}
