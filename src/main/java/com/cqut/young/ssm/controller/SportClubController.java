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
import com.cqut.young.ssm.service.ISportClubService;

@Controller
public class SportClubController {

	@Resource
	private ISportClubService sport_clubService;
	
	@RequestMapping(value="/sportclub/createSportClub",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String createSportClub(@RequestParam("sport_club_properties") String sport_club_properties){
		
		Map<String, Object> temp = (Map)JSON.parseObject(sport_club_properties);
		
		Map<String, Object> result = sport_clubService.createSportClub(temp);
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}
	
	@RequestMapping(value="/sportclub/deleteSportClub",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String deleteSportClub(@RequestParam("sport_club_id") String sport_club_id){
		
		Map<String, Object> result = sport_clubService.deleteSportClub(sport_club_id);
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}
	
	@RequestMapping(value="/sportclub/cancelSportClub",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String cancelSportClub(@RequestParam("sport_club_id") String sport_club_id){
		
		Map<String, Object> result = sport_clubService.cancelSportClub(sport_club_id);
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}
	
	@RequestMapping(value="/sportclub/getSportClubById",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getSportClubById(@RequestParam("sport_club_id") String sport_club_id){
		
		Map<String, Object> result = sport_clubService.getSportClubById(sport_club_id);
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}
	
	@RequestMapping(value="/sportclub/getSportClubByCondition",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getSportClubByCondition(@RequestParam("condition") String condition,
			@RequestParam("page") String page,
			@RequestParam("row") String row,
			@RequestParam("state") String state){
		
		List<Map<String, Object>> result = sport_clubService.getSportClubByCondition(condition,page,row,state);
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}
	
	@RequestMapping(value="/sportclub/joinSportClub",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String joinSportClub(@RequestParam("sport_club_id") String sport_club_id,
			@RequestParam("user_id") String user_id){
		
		Map<String, Object> result = sport_clubService.joinSportClub(user_id, sport_club_id);
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}
	
	@RequestMapping(value="/sportclub/existSportClub",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String existSportClub(@RequestParam("sport_club_id") String sport_club_id,
			@RequestParam("user_id") String user_id){
		
		Map<String, Object> result = sport_clubService.existSportClub(user_id, sport_club_id);
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}
	
	@RequestMapping(value="/sportclub/getRecommend",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getRecommend(){
		
		List<Map<String, Object>> result = sport_clubService.getRecommend();
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}

}
