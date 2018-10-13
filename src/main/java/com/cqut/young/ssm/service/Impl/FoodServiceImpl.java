package com.cqut.young.ssm.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqut.young.ssm.dao.base.Dao;
import com.cqut.young.ssm.dao.base.SearchDao;
import com.cqut.young.ssm.entity.Food;
import com.cqut.young.ssm.entity.base.Entity;
import com.cqut.young.ssm.service.IFoodService;

@Service("foodService") 
public class FoodServiceImpl implements IFoodService {
	
	@Resource
	private Dao entityDao;
	@Resource
	private SearchDao searchDao;

	@Override
	public Map<String, Object> addFood(Map<String, Object> properties) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> deleteFood(String food_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> updateFood(Map<String, Object> properties) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getFoodById(String food_id) {
		
		food_id = food_id.trim();
		
		Map<String, Object> result = new HashMap<>();
		
		String condition = " food_id = '" + food_id + "'";
		
		String joinEntity = " LEFT JOIN seller on seller.seller_id = food.seller_id ";
		
		result = searchDao.searchWithPageInMysql(new String[]{
				"food.food_id",
				"food.seller_id",
				"food.food_name",
				"food.food_introl",
				"food.food_img_path",
				"food.food_type",
				"food.food_label",
				"food.food_calorie",
				"food.food_price",
				"seller.seller_name",
				"seller.seller_img_path",
				"seller.seller_address"},
				Entity.getTableName(Food.class),
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
	public List<Map<String, Object>> getFoodByCondition(String condition, String page, String row) {
		Map<String, Object> result = new HashMap<>();
		
		condition = condition.trim();
		page = page.trim();
		row = row.trim();
		
		char[] array = condition.toCharArray();
		
		String temp = "%";
		for(char c : array){
			temp += c + "%";
		}
		
		
		
		String joinEntity = " LEFT JOIN seller on seller.seller_id = food.seller_id ";
		
		List<Map<String, Object>> resultList = null;
		while(resultList == null || resultList.isEmpty()){
			
			condition = " food.food_label like '" + temp 
				+ "' or food.food_name like '" + temp + "'";
			
			resultList = searchDao.searchWithPageInMysql(new String[]{
					"food.food_id",
					"food.seller_id",
					"food.food_name",
					"food.food_introl",
					"food.food_img_path",
					"food.food_type",
					"food.food_label",
					"food.food_calorie",
					"food.food_price",
					"seller.seller_name",
					"seller.seller_img_path",
					"seller.seller_address"},
					Entity.getTableName(Food.class),
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
		
		List<Food> list = entityDao.getByCondition(" 1 = 1 ", Food.class);
		
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
