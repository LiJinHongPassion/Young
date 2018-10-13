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
import com.cqut.young.ssm.service.IFoodService;

@Controller
public class FoodController {

	@Resource
	private IFoodService foodService;
	
	@RequestMapping(value="/food/getFoodById",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getFoodById(@RequestParam("food_id") String food_id){
		
		Map<String, Object> result = foodService.getFoodById(food_id);
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}
	
	@RequestMapping(value="/food/getFoodByCondition",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getFoodByCondition(@RequestParam("condition") String condition){
		
		List<Map<String, Object>> result = foodService.getFoodByCondition(condition, "0", "10");
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}
	
	@RequestMapping(value="/food/getRecommend",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getRecommend(){
		
		List<Map<String, Object>> result = foodService.getRecommend();
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}

}
