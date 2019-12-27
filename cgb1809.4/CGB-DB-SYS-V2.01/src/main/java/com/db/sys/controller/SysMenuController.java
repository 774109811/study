package com.db.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.db.sys.common.vo.JsonResult;
import com.db.sys.service.SysMenuService;

@Controller
@RequestMapping("/menu/")
public class SysMenuController {
	@Autowired
	private SysMenuService sysMenuService;
	
	@RequestMapping("doMenuListUI")
	public String doMenuListUI(){
	 return "sys/menu_list";
	}
	
    @RequestMapping("doMenuEditUI")
	public String doMenuEditUI(){
	  return "sys/menu_edit";
	}


	@RequestMapping("doFindZtreeMenuNodes")
	@ResponseBody
	public JsonResult doFindZtreeMenuNodes(){
		 return new JsonResult(
		 sysMenuService.findZtreeMenuNodes());
	}

	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id){
		sysMenuService.deleteObject(id);
		return new JsonResult("delete ok");
	}

	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects(){
		List<Map<String,Object>> list=
				sysMenuService.findObjects();
		System.out.println(list);
		return new JsonResult(list);
	}
}








