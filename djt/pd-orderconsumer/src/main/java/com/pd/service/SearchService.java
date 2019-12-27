package com.pd.service;

import java.util.List;

import com.pd.pojo.Item;

public interface SearchService {
	/**
	 * 根据key查询solr服务器查询商品
	 * 
	 * */
	public List<Item> finItemByKe(String key);
}
