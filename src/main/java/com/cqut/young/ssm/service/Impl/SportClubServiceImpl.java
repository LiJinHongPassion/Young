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
import com.cqut.young.ssm.entity.Message;
import com.cqut.young.ssm.entity.SportClub;
import com.cqut.young.ssm.entity.User;
import com.cqut.young.ssm.entity.base.Entity;
import com.cqut.young.ssm.service.ISportClubService;
import com.cqut.young.ssm.tool.EntityIDFactory;

@Service("sportClubService") 
public class SportClubServiceImpl implements ISportClubService {
	
	@Resource
	private Dao entityDao;
	@Resource
	private SearchDao searchDao;

	


	@Override
	public Map<String, Object> createSportClub(Map<String, Object> properties) {
		
		Map<String, Object> result = new HashMap<>();
		SportClub sport_club = new SportClub();
		
		sport_club.setSport_club_id(EntityIDFactory.createId());
		sport_club.setProperties(properties);
		
		int temp = entityDao.save(sport_club);
		
		if(temp == 1){
			
			//创建成功
			String header_id = sport_club.getSport_club_header_id();
			String msg_to_user = "您成功创建运动小组：" + sport_club.getSport_club_id() + "！祝您运动愉快！";
			
			sendMsg("Young",header_id,"恭喜您！成功创建运动小组",msg_to_user);
			
			result.put("result", "1");
			return result;
		}
		
		result.put("result", "-1");
		return result;
	}

	@Override
	public Map<String, Object> deleteSportClub(String sport_club_id) {
		
		sport_club_id = sport_club_id.trim();
		
		Map<String, Object> result = new HashMap<>();
		
		SportClub sport_club = entityDao.getByID(sport_club_id, SportClub.class);
		
		if(sport_club == null){
			result.put("result", "-1");
			return result;
		}
		
		if(sport_club.getSport_club_state().equals("0") 
				|| sport_club.getSport_club_state().equals("-1")){
			//不能删除，正在进行，或还未开始
			result.put("result", "0");
			return result;
		}
		
		int temp = entityDao.deleteByID(sport_club_id, SportClub.class);
		
		if(temp == 1){
			//创建成功
			String header_id = sport_club.getSport_club_header_id();
			String msg_to_user = "您成功删除运动小组：" + sport_club.getSport_club_id() + "！祝您生活愉快！";
			
			sendMsg("Young",header_id,"恭喜您！成功删除运动小组",msg_to_user);
			result.put("result", "1");
			return result;
		}
		result.put("result", "-1");
		return result;
	}

	@Override
	public Map<String, Object> cancelSportClub(String sport_club_id) {
		
		sport_club_id = sport_club_id.trim();
		
		Map<String, Object> result = new HashMap<>();
		
		SportClub sport_club = entityDao.getByID(sport_club_id, SportClub.class);
		
		if(sport_club == null){
			result.put("result", "-1");
			return result;
		}
		
		String state = sport_club.getSport_club_state();
		if(state.equals("0") || state.equals("1") || state.equals("2")){
			//不能取消，正在进行
			result.put("result", "0");
			return result;
		}
		
		sport_club.setSport_club_state("2");
		int temp = entityDao.updatePropByID(sport_club, sport_club.getSport_club_id());
		
		if(temp == 1){
			String header_id = sport_club.getSport_club_header_id();
			String msg_to_header = "您成功取消运动小组：" + sport_club.getSport_club_id() + "！祝您生活愉快！";
			String msg_to_user = "运动小组" + sport_club.getSport_club_id() + "已取消！祝您生活愉快！";
			
			sendMsg("Young",header_id,"成功取消运动小组",msg_to_header);
			
			String[] members = sport_club.getSport_club_menbers_id().split(",");
			for(String str : members){
				sendMsg(header_id,str,"运动小组" + sport_club.getSport_club_id() + "已取消",msg_to_user);
			}
			
			result.put("result", "1");
			return result;
		}
		result.put("result", "-1");
		return result;
	}

	@Override
	public List<Map<String, Object>> getRecommend() {
		
		List<SportClub> list = entityDao.getByCondition(" 1 = 1 ", SportClub.class);
		
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

	@Override
	public Map<String, Object> getSportClubById(String sport_club_id) {
		
		sport_club_id = sport_club_id.trim();
		
		Map<String, Object> result = new HashMap<>();
		
		SportClub sport_club = entityDao.getByID(sport_club_id, SportClub.class);
		
		if(sport_club == null){
			result.put("result", "-1");
			return result;
		}
		result = sport_club.toMap();
		result.put("result", "1");
		return result;
	}

	@Override
	public List<Map<String, Object>> getSportClubByCondition(String condition, String page, String row, String state) {
		Map<String, Object> result = new HashMap<>();
		
		condition = condition.trim();
		page = page.trim();
		row = row.trim();
		state = state.trim();
		
		char[] array = condition.toCharArray();
		
		String temp = "%";
		for(char c : array){
			temp += c + "%";
		}
		
		String joinEntity = " LEFT JOIN user on user.user_id = sport_club.sport_club_header_id ";
		
		List<Map<String, Object>> resultList = null;
		while(resultList == null || resultList.isEmpty()){
			
			condition = " ( sport_club.sport_club_title like '" + temp 
					+ "' or sport_club.sport_club_id like '" + temp 
					+ "' and sport_club.sport_club_state = '" + state +"'";
			
			resultList = searchDao.searchWithPageInMysql(new String[]{
					"sport_club.sport_club_id",
					"sport_club.sport_club_header_id",
					"sport_club.sport_club_title",
					"sport_club.sport_club_start_time",
					"sport_club.sport_club_end_time",
					"sport_club.sport_club_begin_time",
					"sport_club.sport_club_over_time",
					"sport_club.sport_club_people_num",
					"sport_club.sport_club_menbers_id",
					"sport_club.sport_club_state",
					"sport_club.sport_club_address",
					"user.user_name",
					"user.user_img_path",
					"user.user_address",
					"user.user_tel"},
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
	public Map<String, Object> joinSportClub(String user_id, String sport_club_id) {
		Map<String, Object> result = new HashMap<>();
		
		user_id = user_id.trim();
		sport_club_id =sport_club_id.trim();
		
		User user = entityDao.getByID(user_id, User.class);
		
		SportClub sport_club = entityDao.getByID(sport_club_id, SportClub.class);
		
		if(user == null || sport_club == null){
			//加入失败，用户不存在，club不存在
			result.put("result", "-1");
			return result;
		}
		
		String members = sport_club.getSport_club_menbers_id();
		
		String[] temp = members.split(",");
		
		for(String str : temp){
			if(str.equals(user_id)){
				//用户已经加入，不需再次加入
				result.put("result", "0");
				return result;
			}
		}
		
		int num = Integer.parseInt(sport_club.getSport_club_people_num());
		
		if(num == temp.length){
			//人数已满，不能再次加入
			result.put("result", "2");
			return result;
		}
		
		members += "," + user_id;
		sport_club.setSport_club_menbers_id(members);
		int a = entityDao.updatePropByID(sport_club, sport_club_id);
		if(a == 1){
			//加入成功
			String header_id = sport_club.getSport_club_header_id();
			String msg_to_user = "您成功加入 用户：" + header_id + "的队伍！祝您运动愉快！";
			String msg_to_header = "用户：" + user_id + "成功加入您的队伍！运动小组号：" + sport_club.getSport_club_id();
			
			sendMsg("Young",user_id,"恭喜您！成功加入！",msg_to_user);
			sendMsg("Young",header_id,"有人加入你的小组啦！",msg_to_header);
			
			result.put("result", "1");
			return result;
		}
		
		result.put("result", "-1");
		return result;
	}

	//加入、退出消息发送
	private void sendMsg(String sender_id, String receiver_id, String message_title, String message_introl){
		String message_id = EntityIDFactory.createId();
		Message msg = new Message();
		msg.setMessage_id(message_id);
		msg.setSender_id(sender_id);
		msg.setReceiver_id(receiver_id);
		msg.setMessage_title(message_title);
		msg.setMessage_introl(message_introl);
		msg.setMessage_state("0");
		entityDao.save(msg);
	}
	
	@Override
 	public Map<String, Object> existSportClub(String user_id, String sport_club_id) {
		
		Map<String, Object> result = new HashMap<>();
		
		user_id = user_id.trim();
		sport_club_id =sport_club_id.trim();

		User user = entityDao.getByID(user_id, User.class);
		
		SportClub sport_club = entityDao.getByID(sport_club_id, SportClub.class);
		
		if(user == null || sport_club == null){
			//退出失败，用户不存在，club不存在
			result.put("result", "-1");
			return result;
		}
		
		String members = sport_club.getSport_club_menbers_id();
		
		String[] temp = members.split(",");
		int a = 0;
		for( ;a < temp.length - 1; a++){
			if(temp[a].equals(user_id)){
				temp[a] = "";
				break;
			}
		}
		
		if(a == temp.length){
			//用户已经退出，不需再次退出
			result.put("result", "0");
			return result;
		}else{
			members = "";
			for(String str : temp){
				members += "," + str;
			}
			
			members = members.substring(1).replace(",,", ",");
		}
		
		sport_club.setSport_club_menbers_id(members);
		int temp_a = entityDao.updatePropByID(sport_club, sport_club_id);
		if(temp_a == 1){
			String header_id = sport_club.getSport_club_header_id();
			String msg_to_user = "您成功退出 用户：" + header_id + "的队伍！祝您生活愉快！";
			String msg_to_header = "用户：" + user_id + "退出您的队伍！运动小组号：" + sport_club.getSport_club_id();
			
			sendMsg("Young",user_id,"退出成功！",msg_to_user);
			sendMsg("Young",header_id,"有人离开你的小组了。",msg_to_header);
			
			result.put("result", "1");
			return result;
		}
		
		result.put("result", "-1");
		return result;
	}

}
