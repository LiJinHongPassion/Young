package com.cqut.young.ssm.entity;

import java.math.BigDecimal;

import com.cqut.young.ssm.entity.base.Entity;

public class SportsCoach extends Entity {
	 private String sports_coach_id;

	    private String seller_id;

	    private String sports_coach_name;

	    private String sports_coach_sex;

	    private String sports_coach_birthday;

	    private String sports_coach_label;

	    private String sports_coach_type;

	    private String sports_coach_img_path;

	    private String sports_coach_introl;

	    private BigDecimal sport_coach_price;

	    public String getSports_coach_id() {
	        return sports_coach_id;
	    }

	    public void setSports_coach_id(String sports_coach_id) {
	        this.sports_coach_id = sports_coach_id == null ? null : sports_coach_id.trim();
	    }

	    public String getSeller_id() {
	        return seller_id;
	    }

	    public void setSeller_id(String seller_id) {
	        this.seller_id = seller_id == null ? null : seller_id.trim();
	    }

	    public String getSports_coach_name() {
	        return sports_coach_name;
	    }

	    public void setSports_coach_name(String sports_coach_name) {
	        this.sports_coach_name = sports_coach_name == null ? null : sports_coach_name.trim();
	    }

	    public String getSports_coach_sex() {
	        return sports_coach_sex;
	    }

	    public void setSports_coach_sex(String sports_coach_sex) {
	        this.sports_coach_sex = sports_coach_sex == null ? null : sports_coach_sex.trim();
	    }

	    public String getSports_coach_birthday() {
	        return sports_coach_birthday;
	    }

	    public void setSports_coach_birthday(String sports_coach_birthday) {
	        this.sports_coach_birthday = sports_coach_birthday == null ? null : sports_coach_birthday.trim();
	    }

	    public String getSports_coach_label() {
	        return sports_coach_label;
	    }

	    public void setSports_coach_label(String sports_coach_label) {
	        this.sports_coach_label = sports_coach_label == null ? null : sports_coach_label.trim();
	    }

	    public String getSports_coach_type() {
	        return sports_coach_type;
	    }

	    public void setSports_coach_type(String sports_coach_type) {
	        this.sports_coach_type = sports_coach_type == null ? null : sports_coach_type.trim();
	    }

	    public String getSports_coach_img_path() {
	        return sports_coach_img_path;
	    }

	    public void setSports_coach_img_path(String sports_coach_img_path) {
	        this.sports_coach_img_path = sports_coach_img_path == null ? null : sports_coach_img_path.trim();
	    }

	    public String getSports_coach_introl() {
	        return sports_coach_introl;
	    }

	    public void setSports_coach_introl(String sports_coach_introl) {
	        this.sports_coach_introl = sports_coach_introl == null ? null : sports_coach_introl.trim();
	    }

	    public BigDecimal getSport_coach_price() {
	        return sport_coach_price;
	    }

	    public void setSport_coach_price(BigDecimal sport_coach_price) {
	        this.sport_coach_price = sport_coach_price;
	    }

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "sports_coach";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "sports_coach_id";
	}
}