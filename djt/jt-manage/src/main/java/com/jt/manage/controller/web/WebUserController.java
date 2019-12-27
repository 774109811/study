package com.jt.manage.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jt.manage.pojo.User;
import com.jt.manage.service.UserService;


@RequestMapping("/user")
@Controller
public class WebUserController {
	@Autowired
	private UserService userService;


}
