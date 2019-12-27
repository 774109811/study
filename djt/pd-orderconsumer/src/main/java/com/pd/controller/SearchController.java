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
	@Autowired
	private SearchService searchService;
	public SearchController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping("/search/toSearch.html")
	public String search(String key,Model model) {
		
		List<Item> itemList = searchService.finItemByKe(key);
		model.addAttribute("list",itemList);
		return"/search.jsp";
	}
}
