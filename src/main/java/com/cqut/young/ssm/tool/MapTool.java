package com.cqut.young.ssm.tool;

import java.util.Map;

public class MapTool {
	
	public static Object getValue(Map<String, Object> map, String key){
		
		for(String temp : map.keySet()){	
			if(temp.equals(key)){
				return map.get(key);
			}
		}
		return null;
	}

}
