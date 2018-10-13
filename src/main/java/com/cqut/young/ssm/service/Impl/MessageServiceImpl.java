package com.cqut.young.ssm.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqut.young.ssm.dao.base.Dao;
import com.cqut.young.ssm.dao.base.SearchDao;
import com.cqut.young.ssm.entity.Message;
import com.cqut.young.ssm.entity.base.Entity;
import com.cqut.young.ssm.service.IMessageService;

@Service("messageService") 
public class MessageServiceImpl implements IMessageService {
	
	@Resource
	private Dao entityDao;
	@Resource
	private SearchDao searchDao;

	
	
	@Override
	public Map<String, Object> sendMsg(Map<String, Object> properties) {
		
		
		return null;
	}



	@Override
	public Map<String, Object> getMsgById(String msg_id) {
		Map<String, Object> result = new HashMap<>();
		Message msg = entityDao.getByID(msg_id, Message.class);
		
		if(msg == null){
			result.put("result", "-1");
			return result;
		}
		
		result = msg.toMap();
		result.put("result", "1");
		return result;
	}



	@Override
	public List<Map<String, Object>> getUnreadMsg(String receiver_id) {
		Map<String, Object> result = new HashMap<>();
		
		String condition  = " receiver_id = '" + receiver_id 
				+ "' and message_state = '" + 0 + "' "; 
		
		List<Map<String, Object>> resultList = searchDao.searchForeign(new String[]{
				"message_id",
				"receiver_id",
				"sender_id",
				"message_type",
				"message_title",
				"message_introl",
				"message_img_path",
				"message_state",
				"message_time"
		}, Entity.getTableName(Message.class),
				null, 
				null,
				null,
				condition);
		
		if(resultList == null || resultList.isEmpty()){
			//失败
			result.put("result", "-1");
			resultList.add(result);
			return resultList;
		}
		
		//成功
		result.put("result", "1");
		resultList.add(result);
		return resultList;
	}



	@Override
	public List<Map<String, Object>> getReadMsg(String receiver_id) {
		// TODO Auto-generated method stub
		Map<String, Object> result = new HashMap<>();
		
		String condition  = " receiver_id = '" + receiver_id 
				+ "' and message_state = '" + 1 + "' "; 
		
		List<Map<String, Object>> resultList = searchDao.searchForeign(new String[]{
				"message_id",
				"receiver_id",
				"sender_id",
				"message_type",
				"message_title",
				"message_introl",
				"message_img_path",
				"message_state",
				"message_time"
		}, Entity.getTableName(Message.class),
				null, 
				null,
				null,
				condition);
		
		if(resultList == null || resultList.isEmpty()){
			//失败
			result.put("result", "-1");
			resultList.add(result);
			return resultList;
		}
		
		//成功
		result.put("result", "1");
		resultList.add(result);
		return resultList;
	}



	@Override
	public List<Map<String, Object>> getMsgSortByTime(String receiver_id) {
		// TODO Auto-generated method stub
		return null;
	}


}
