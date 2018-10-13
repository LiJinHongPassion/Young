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
import com.cqut.young.ssm.service.IEarlyClockService;

@Controller
public class EarlyClockController {

	@Resource
	private IEarlyClockService early_clockService;
	
	@RequestMapping(value="/earlyclock/getTopten",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getTopten(){
		
		List<Map<String, Object>> result = early_clockService.getTopten("");
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}
	
	@RequestMapping(value="/earlyclock/getSortById",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getSortById(@RequestParam("user_id") String user_id){
		
		Map<String, Object> result = early_clockService.getSortById(user_id);
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}
	
	@RequestMapping(value="/earlyclock/addById",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String addById(@RequestParam("user_id") String user_id){
		
		Map<String, Object> result = early_clockService.addById(user_id);
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}

}
