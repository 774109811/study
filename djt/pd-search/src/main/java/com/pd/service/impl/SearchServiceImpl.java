package com.pd.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.pd.pojo.Item;
import com.pd.service.SearchService;
@Service(version="1.0.0")
public class SearchServiceImpl implements SearchService {
	@Autowired
	private SolrClient solrClient;
	@Override
	public List<Item> finItemByKe(String key) {
		//创建查询对象设置查询的条数
		SolrQuery solrQuery=new SolrQuery(key);
		//limit 0,20
		solrQuery.setStart(0);
		solrQuery.setRows(20);
		try {
		//查询并返回
		QueryResponse response=solrClient.query(solrQuery);
		List<Item> items = response.getBeans(Item.class);
		return items;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
