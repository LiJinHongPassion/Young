package com.cqut.young.ssm.service;

import java.util.List;
import java.util.Map;

public interface ISportsCoachService {
	public Map<String, Object> addSportsCoach(Map<String, Object> properties);
	
	public Map<String, Object> deleteSportsCoach(String sports_coach_id);
	
	public Map<String, Object> updateSportsCoach(Map<String, Object> properties);
	
	public Map<String, Object> getSportsCoachById(String sports_coach_id);
	
	public List<Map<String, Object>> getSportsCoachByCondition(String condition, String page, String row);
	//推荐
	public List<Map<String, Object>> getRecommend();
}
