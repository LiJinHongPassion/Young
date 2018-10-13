package com.cqut.young.ssm.service;

import java.util.List;
import java.util.Map;

public interface ISportClubService {

	//创建
	public Map<String, Object> createSportClub(Map<String, Object> properties);
	
	//删除
	public Map<String, Object> deleteSportClub(String sport_club_id);
	
	//取消
	public Map<String, Object> cancelSportClub(String sport_club_id);
	
	
	
	//推荐
	public List<Map<String, Object>> getRecommend();
	
	//
	public Map<String,Object> getSportClubById(String sport_club_id);
	
	
	public List<Map<String, Object>> getSportClubByCondition(String condition, String page, String row, String state);
	
	
	//参加
	public Map<String, Object> joinSportClub(String user_id, String sport_club_id);
	
	//退出
	public Map<String, Object> existSportClub(String user_id, String sport_club_id);
	
	
	
}
