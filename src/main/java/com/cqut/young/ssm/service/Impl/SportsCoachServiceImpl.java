package com.cqut.young.ssm.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqut.young.ssm.dao.base.Dao;
import com.cqut.young.ssm.dao.base.SearchDao;
import com.cqut.young.ssm.entity.SportsCoach;
import com.cqut.young.ssm.entity.base.Entity;
import com.cqut.young.ssm.service.ISportsCoachService;

@Service("sportsCoachService") 
public class SportsCoachServiceImpl implements ISportsCoachService {
	
	@Resource
	private Dao entityDao;
	@Resource
	private SearchDao searchDao;
	
	@Override
	public Map<String, Object> addSportsCoach(Map<String, Object> properties) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Map<String, Object> deleteSportsCoach(String sports_coach_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Map<String, Object> updateSportsCoach(Map<String, Object> properties) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Map<String, Object> getSportsCoachById(String sports_coach_id) {
		
		sports_coach_id = sports_coach_id.trim();
		
		Map<String, Object> result = new HashMap<>();
		
		String condition = " sports_coach_id = '" + sports_coach_id + "'";
		
		String joinEntity = " LEFT JOIN seller on seller.seller_id = sports_coach.seller_id ";
		
			
		result = searchDao.searchWithPageInMysql(new String[]{
					"sports_coach.sports_coach_id",
					"sports_coach.seller_id",
					"sports_coach.sports_coach_name",
					"sports_coach.sports_coach_introl",
					"sports_coach.sports_coach_img_path",
					"sports_coach.sports_coach_type",
					"sports_coach.sports_coach_label",
					"sports_coach.sports_coach_sex",
					"sports_coach.sports_coach_birthday",
					"sports_coach.sport_coach_price",
					"seller.seller_name",
					"seller.seller_img_path",
					"seller.seller_address"},
					Entity.getTableName(SportsCoach.class),
					joinEntity, 
					null, 
					null,
					condition, 
					null, 
					null, 
					null, 
					0,1).get(0);
		
		if( result.isEmpty() || result == null){
			result.put("result", "-1");
			return result;
		}
		result.put("result", "1");
		return result;
	}
	
	@Override
	public List<Map<String, Object>> getSportsCoachByCondition(String condition, String page, String row) {
Map<String, Object> result = new HashMap<>();
		
		condition = condition.trim();
		page = page.trim();
		row = row.trim();
		
		char[] array = condition.toCharArray();
		
		String temp = "%";
		for(char c : array){
			temp += c + "%";
		}
		
		
		String joinEntity = " LEFT JOIN seller on seller.seller_id = sports_coach.seller_id ";
		
		List<Map<String, Object>> resultList = null;
		while(resultList == null || resultList.isEmpty()){
			
			condition = " sports_coach.sports_coach_label like '" + temp 
				+ "' or sports_coach.sports_coach_name like '" + temp + "'";
			
			resultList = searchDao.searchWithPageInMysql(new String[]{
					"sports_coach.sports_coach_id",
					"sports_coach.seller_id",
					"sports_coach.sports_coach_name",
					"sports_coach.sports_coach_introl",
					"sports_coach.sports_coach_img_path",
					"sports_coach.sports_coach_type",
					"sports_coach.sports_coach_label",
					"sports_coach.sports_coach_sex",
					"sports_coach.sports_coach_birthday",
					"sports_coach.sport_coach_price",
					"seller.seller_name",
					"seller.seller_img_path",
					"seller.seller_address"},
					Entity.getTableName(SportsCoach.class),
					joinEntity, 
					null, 
					null,
					condition, 
					null, 
					null, 
					null, 
					Integer.parseInt(page)*Integer.parseInt(row), 
					Integer.parseInt(row));
			

			if(temp.length() > 2){
				temp = temp.substring(0, temp.length() - 2);
			}

			if(temp.length() == 0){
				break;
			}
			
		}
		
		if(resultList == null || resultList.isEmpty()){
			result.put("result", "-1");
			resultList.add(result);
			return resultList;
		}
		
		result.put("result", "1");
		resultList.add(result);
		return resultList;
	}

	@Override
	public List<Map<String, Object>> getRecommend() {
		
		List<SportsCoach> list = entityDao.getByCondition(" 1 = 1 ", SportsCoach.class);
		
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		
		if(list.size() > 3){
			resultList.add(list.get((int)(0+Math.random()*(list.size()-0+1))).toMap());
			resultList.add(list.get((int)(0+Math.random()*(list.size()-0+1))).toMap());
			resultList.add(list.get((int)(0+Math.random()*(list.size()-0+1))).toMap());
		}else{
			for(int a = 0; a < list.size(); a++){
				resultList.add(list.get(a).toMap());
			}
		}
		
		return resultList;
		
	}

	

}
