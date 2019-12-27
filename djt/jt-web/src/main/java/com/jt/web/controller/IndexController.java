package com.jt.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.web.service.PageImgeService;

@Controller
public class IndexController {
	@Autowired
	private PageImgeService pageImgeService;
	@RequestMapping("/index")
	public String index(Model model) {
		String adResut=	pageImgeService.getAdItemList();
		model.addAttribute("indexAD1", adResut);
		return "index";
	}
}
