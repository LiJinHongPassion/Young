package com.cqut.young.ssm.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqut.young.ssm.dao.base.Dao;
import com.cqut.young.ssm.dao.base.SearchDao;
import com.cqut.young.ssm.entity.EarlyClock;
import com.cqut.young.ssm.entity.base.Entity;
import com.cqut.young.ssm.service.IEarlyClockService;
import com.cqut.young.ssm.tool.EntityIDFactory;

@Service("earlyClockService") 
public class EarlyClockServiceImpl implements IEarlyClockService {

	@Resource
	private Dao entityDao;
	@Resource
	private SearchDao searchDao;
	
	@Override
	public List<Map<String, Object>> getTopten(String address) {
		// TODO Auto-generated method stub
		long nowTime =System.currentTimeMillis();
		long todayStartTime = nowTime - (nowTime + TimeZone.getDefault().getRawOffset())% (1000*3600*24);
		String condition = " early_clock_time between '" 
				+ (todayStartTime + 18000000) + "' and '" + (todayStartTime + 28800000) + "' ";
		
		
		List<Map<String, Object>> resultList = searchDao.searchWithPageInMysql(
				new String[]{
						"user_id",
						"early_clock_id",
						"early_clock_time"
				},Entity.getTableName(EarlyClock.class), 
				null, null, null, condition,
				null, "early_clock_time", null, 
				0, 10);
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "1");
		resultList.add(result);
		return resultList;
	}

	@Override
	public Map<String, Object> getSortById(String user_id) {
		
		Map<String, Object> result = new HashMap<>();
		long nowTime =System.currentTimeMillis();
		long todayStartTime = nowTime - (nowTime + TimeZone.getDefault().getRawOffset())% (1000*3600*24);
		
		String condition = " user_id = '" + user_id 
				+ "' and early_clock_time between '" 
				+ (todayStartTime + 18000000) + "' and '" + (todayStartTime + 28800000) + "' ";
		
		
		List<Map<String, Object>> resultList = searchDao.searchForeign(new String[]{
				"user_id",
				"early_clock_id",
				"early_clock_time"
		}, Entity.getTableName(EarlyClock.class),
				null, null, null, 
				condition);
		
		
		
		if(resultList.size() == 0){
			//没有打卡
			result.put("result", "0");
			return result;
		}else if(resultList.size() != 0){
			//已经打卡
			result = resultList.get(0);
			
			EarlyClock e = new EarlyClock();
			e.setProperties(result);
			condition = " early_clock_time between '" 
					+ (todayStartTime + 18000) + "' and '" + e.getEarly_clock_time() + "' ";
			
			int num = searchDao.getForeignCount(Entity.getPrimaryKey(EarlyClock.class),
					Entity.getTableName(EarlyClock.class),
					null,
					null,
					null,
					condition);
			
			result.put("sort_num",num);
			//查询成功
			result.put("result", "1");
			return result;
		}
		
		//查询失败
		result.put("result", "-1");
		return result;
		
	}

	@Override
	public Map<String, Object> addById(String user_id) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();

		long nowTime =System.currentTimeMillis();
		long todayStartTime = nowTime - (nowTime + TimeZone.getDefault().getRawOffset())% (1000*3600*24);
		long startTime = todayStartTime + 18000000;
		long endTime = todayStartTime + 28800000;
		
		//规定时间段里打卡
		if(nowTime < startTime || nowTime > endTime){
			//不能打卡
			result.put("result", "2");
			return result;
		}
		
		String condition = " user_id = '" + user_id 
				+ "' and early_clock_time between '" 
				+ startTime + "' and '" + endTime + "' ";
		
		
		List<Map<String, Object>> resultList = searchDao.searchForeign(new String[]{
				"user_id",
				"early_clock_id",
				"early_clock_time"
		}, Entity.getTableName(EarlyClock.class),
				null, null, null, 
				condition);
		
		
		if(resultList.size() == 0){
			//可以打卡
			String early_clock_id = EntityIDFactory.createId();
			String early_clock_time = String.valueOf(System.currentTimeMillis());
			
			EarlyClock e = new EarlyClock();
			e.setEarly_clock_id(early_clock_id);
			e.setEarly_clock_time(early_clock_time);
			e.setUser_id(user_id);
			
			entityDao.save(e);
			//打卡成功
			result.put("result", "1");
			return result;
		}else if(resultList.size() != 0){
			//重复打卡
			result.put("result", "0");
			return result;
		}
		//打卡失败
		result.put("result", "-1");
		return result;
	}

}
