package com.cqut.young.ssm.service;

import java.util.List;
import java.util.Map;

public interface IFoodService {
	public Map<String, Object> addFood(Map<String, Object> properties);
	
	public Map<String, Object> deleteFood(String food_id);
	
	public Map<String, Object> updateFood(Map<String, Object> properties);
	
	public Map<String, Object> getFoodById(String food_id);
	
	public List<Map<String, Object>> getFoodByCondition(String condition, String page, String row);
	//推荐
	public List<Map<String, Object>> getRecommend();
}
