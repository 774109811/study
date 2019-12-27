package com.pd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pd.pojo.Item;
import com.pd.service.SearchService;

@Controller
public class SearchController {

	//searchService要加@service
	@Autowired
	SearchService searchService;
	@RequestMapping("/search/toSearch.html")
	public String search(String key,Model model)
			throws Exception{
		List<Item> itemList=searchService.finItemByKe(key);
		//第一个参数"itemList"必须和jsp中的list一致
		model.addAttribute("list", itemList);
		
		return "/search.jsp";
	}
}







