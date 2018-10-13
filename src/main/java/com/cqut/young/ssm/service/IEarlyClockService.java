package com.cqut.young.ssm.service;

import java.util.List;
import java.util.Map;

public interface IEarlyClockService {
	
	//获取前五名
	public List<Map<String, Object>> getTopten(String address);
	
	//获取当前排名
	public Map<String, Object> getSortById(String user_id);
	
	//打卡
	public Map<String, Object> addById(String user_id);
}
