package com.pd.service;

import java.util.List;

import com.pd.pojo.Item;

public interface SearchService {
	/**
	 * 根据key去solr服务器查询商品
	 * @param key
	 * @return
	 */
	public List<Item> findItemByKey(String key);

}
