package com.cqut.young.ssm.entity;

import com.cqut.young.ssm.entity.base.Entity;

public class Collect extends Entity {

	private String collect_id;
	private String collect_user_id;
	private String collect_type;
	private String collect_collector_id;
	
	
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "collect";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "collect_id";
	}

	public String getCollect_id() {
		return collect_id;
	}

	public void setCollect_id(String collect_id) {
		this.collect_id = collect_id;
	}

	public String getCollect_user_id() {
		return collect_user_id;
	}

	public void setCollect_user_id(String collect_user_id) {
		this.collect_user_id = collect_user_id;
	}

	public String getCollect_type() {
		return collect_type;
	}

	public void setCollect_type(String collect_type) {
		this.collect_type = collect_type;
	}

	public String getCollect_collector_id() {
		return collect_collector_id;
	}

	public void setCollect_collector_id(String collect_collector_id) {
		this.collect_collector_id = collect_collector_id;
	}

}
