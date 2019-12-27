package com.pd.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pd.pojo.Item;
import com.pd.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService{

	//solrj框架整合springboot
	//springboot项目启动时，能自动调用solrJ框架中的类
	//solrj框架中 
	//@bean
	//SolrClient getSolrClient()
	@Autowired
	SolrClient solrClient;
	@Override
	public List<Item> findItemByKey(String key) {

		try {
			SolrQuery query=new SolrQuery(key);
			//limit 0,20 只取20个数据
			query.setStart(0);
			query.setRows(20);
			
			QueryResponse response=
					solrClient.query(query);
			
			List<Item> itemList=
					response.getBeans(Item.class);
			return itemList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
