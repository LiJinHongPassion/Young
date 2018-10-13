package com.cqut.young.ssm.service;

import java.util.List;
import java.util.Map;

public interface IMessageService {
	
	public Map<String, Object> sendMsg(Map<String, Object> properties);
	//消息详情
	public Map<String, Object> getMsgById(String msg_id);
	//根据时间排序获取未读消息
	public List<Map<String, Object>> getUnreadMsg(String receiver_id);
	//根据时间排序获取已读消息
	public List<Map<String, Object>> getReadMsg(String receiver_id);
	//根据时间排序获取所有消息
	public List<Map<String, Object>> getMsgSortByTime(String receiver_id);
	
}
