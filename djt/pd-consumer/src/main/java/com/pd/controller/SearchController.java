package com.pd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pd.pojo.Item;
import com.pd.service.SearchService;

@Controller
public class SearchController {
	//@Autowired 
	@Reference(version="1.0.0",check=false,timeout=90000)
	private SearchService searchService;
	@RequestMapping("/search/toSearch.html")
	public String search(String key,Model model) {
		
		List<Item> itemList = searchService.finItemByKe(key);
		model.addAttribute("list",itemList);
		return"/search.jsp";
	}
}
