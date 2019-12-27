package com.jt.manage.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jt.manage.pojo.User;
//jqry实现跨域
@RestController
public class JsonPonController {
	//http://manage.jt.com/web/testJSONP
	@RequestMapping("/web/testJSONP")
	public JSONPObject findJson(String callback) {
		User user = new User();
		//user.setId(54);
		//user.setName("真好");
		//参数时callback回调函数和获取数据user对象
		return new JSONPObject(callback, user);
	}
}
