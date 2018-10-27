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
import com.cqut.young.ssm.service.IMessageService;

@Controller
public class MessageController {

	@Resource
	private IMessageService messageService;
	
	@RequestMapping(value="/message/getUnreadMsg",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getUnreadMsg(@RequestParam("user_id") String receiver_id){
		
		List<Map<String, Object>> result = messageService.getUnreadMsg(receiver_id);
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}
	
	@RequestMapping(value="/message/getReadMsg",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getReadMsg(@RequestParam("message_id") String message_id){
		
		List<Map<String, Object>> result = messageService.getReadMsg(message_id);
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}
	
	@RequestMapping(value="/message/getMsgById",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getMsgById(@RequestParam("message_id") String message_id){
		
		Map<String, Object> result = messageService.getMsgById(message_id);
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}

}
