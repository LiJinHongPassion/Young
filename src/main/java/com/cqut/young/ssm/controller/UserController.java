package com.cqut.young.ssm.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.cqut.young.ssm.service.IUserService;

@Controller
public class UserController {
	@Resource
	private IUserService userService;
	
	@RequestMapping(value="/user/login",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String login(@RequestParam("user_id") String user_id,
			@RequestParam("user_password")String user_password){
		
		List<Map<String, Object>> result = userService.login(user_id, user_password);
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}

	@RequestMapping(value="/user/register",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String register(@RequestParam("user_id") String user_id,
			@RequestParam("user_password")String user_password){
		
		Map<String, Object> result = userService.register(user_id, user_password);
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}
	
	@RequestMapping(value="/user/updateUser",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String updateUser(@RequestParam("properties") String properties){

		Map<String, Object> maps = (Map<String, Object>) JSON.parse(properties);

		Map<String, Object> result = userService.updateUser(maps);

		return JSON.toJSON(result).toString().replace("\"", "'");
	}
	
	@RequestMapping(value="/user/getUserById",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getUserById(@RequestParam("user_id") String user_id){
		
		Map<String, Object> result = userService.getUserById(user_id);
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}
}
