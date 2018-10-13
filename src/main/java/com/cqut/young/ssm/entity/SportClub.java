package com.cqut.young.ssm.entity;

import com.cqut.young.ssm.entity.base.Entity;

public class SportClub extends Entity {
    private String sport_club_id;

    private String sport_club_header_id;

    private String sport_club_title;

    private String sport_club_start_time;

    private String sport_club_end_time;

    private String sport_club_begin_time;

    private String sport_club_over_time;

    private String sport_club_people_num;

    private String sport_club_menbers_id;

    private String sport_club_state;

    private String sport_club_address;

    public String getSport_club_id() {
        return sport_club_id;
    }

    public void setSport_club_id(String sport_club_id) {
        this.sport_club_id = sport_club_id == null ? null : sport_club_id.trim();
    }

    public String getSport_club_header_id() {
        return sport_club_header_id;
    }

    public void setSport_club_header_id(String sport_club_header_id) {
        this.sport_club_header_id = sport_club_header_id == null ? null : sport_club_header_id.trim();
    }

    public String getSport_club_title() {
        return sport_club_title;
    }

    public void setSport_club_title(String sport_club_title) {
        this.sport_club_title = sport_club_title == null ? null : sport_club_title.trim();
    }

    public String getSport_club_start_time() {
        return sport_club_start_time;
    }

    public void setSport_club_start_time(String sport_club_start_time) {
        this.sport_club_start_time = sport_club_start_time;
    }

    public String getSport_club_end_time() {
        return sport_club_end_time;
    }

    public void setSport_club_end_time(String sport_club_end_time) {
        this.sport_club_end_time = sport_club_end_time;
    }

    public String getSport_club_begin_time() {
        return sport_club_begin_time;
    }

    public void setSport_club_begin_time(String sport_club_begin_time) {
        this.sport_club_begin_time = sport_club_begin_time;
    }

    public String getSport_club_over_time() {
        return sport_club_over_time;
    }

    public void setSport_club_over_time(String sport_club_over_time) {
        this.sport_club_over_time = sport_club_over_time;
    }

    public String getSport_club_people_num() {
        return sport_club_people_num;
    }

    public void setSport_club_people_num(String sport_club_people_num) {
        this.sport_club_people_num = sport_club_people_num == null ? null : sport_club_people_num.trim();
    }

    public String getSport_club_menbers_id() {
        return sport_club_menbers_id;
    }

    public void setSport_club_menbers_id(String sport_club_menbers_id) {
        this.sport_club_menbers_id = sport_club_menbers_id == null ? null : sport_club_menbers_id.trim();
    }

    public String getSport_club_state() {
        return sport_club_state;
    }

    public void setSport_club_state(String sport_club_state) {
        this.sport_club_state = sport_club_state == null ? null : sport_club_state.trim();
    }

    public String getSport_club_address() {
        return sport_club_address;
    }

    public void setSport_club_address(String sport_club_address) {
        this.sport_club_address = sport_club_address == null ? null : sport_club_address.trim();
    }

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "sport_club";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "sport_club_id";
	}
}