package com.cqut.young.ssm.entity;

import com.cqut.young.ssm.entity.base.Entity;

public class EarlyClock extends Entity {
    private String early_clock_id;

    private String user_id;

    private String early_clock_time;

    public String getEarly_clock_id() {
        return early_clock_id;
    }

    public void setEarly_clock_id(String early_clock_id) {
        this.early_clock_id = early_clock_id == null ? null : early_clock_id.trim();
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public String getEarly_clock_time() {
        return early_clock_time;
    }

    public void setEarly_clock_time(String early_clock_time) {
        this.early_clock_time = early_clock_time;
    }

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "early_clock";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "early_clock_id";
	}
}