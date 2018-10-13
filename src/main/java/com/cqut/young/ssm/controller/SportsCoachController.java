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
import com.cqut.young.ssm.service.ISportsCoachService;

@Controller
public class SportsCoachController {

	@Resource
	private ISportsCoachService sports_coachService;
	
	@RequestMapping(value="/sportscoach/getSportsCoachById",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getSportsCoachById(@RequestParam("sports_coach_id") String sports_coach_id){
		
		Map<String, Object> result = sports_coachService.getSportsCoachById(sports_coach_id);
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}
	
	@RequestMapping(value="/sportscoach/getSportsCoachByCondition",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getSportsCoachByCondition(@RequestParam("condition") String condition){
		
		List<Map<String, Object>> result = sports_coachService.getSportsCoachByCondition(condition, "0", "10");
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}
	
	@RequestMapping(value="/sportscoach/getRecommend",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getRecommend(){
		
		List<Map<String, Object>> result = sports_coachService.getRecommend();
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}

}
