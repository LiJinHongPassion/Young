package com.cqut.young.ssm.entity;

import java.math.BigDecimal;

import com.cqut.young.ssm.entity.base.Entity;

public class Food extends Entity {
	 private String food_id;

	    private String seller_id;

	    private String food_name;

	    private String food_img_path;

	    private String food_introl;

	    private String food_calorie;

	    private String food_type;

	    private String food_label;

	    private BigDecimal food_price;

	    public String getFood_id() {
	        return food_id;
	    }

	    public void setFood_id(String food_id) {
	        this.food_id = food_id == null ? null : food_id.trim();
	    }

	    public String getSeller_id() {
	        return seller_id;
	    }

	    public void setSeller_id(String seller_id) {
	        this.seller_id = seller_id == null ? null : seller_id.trim();
	    }

	    public String getFood_name() {
	        return food_name;
	    }

	    public void setFood_name(String food_name) {
	        this.food_name = food_name == null ? null : food_name.trim();
	    }

	    public String getFood_img_path() {
	        return food_img_path;
	    }

	    public void setFood_img_path(String food_img_path) {
	        this.food_img_path = food_img_path == null ? null : food_img_path.trim();
	    }

	    public String getFood_introl() {
	        return food_introl;
	    }

	    public void setFood_introl(String food_introl) {
	        this.food_introl = food_introl == null ? null : food_introl.trim();
	    }

	    public String getFood_calorie() {
	        return food_calorie;
	    }

	    public void setFood_calorie(String food_calorie) {
	        this.food_calorie = food_calorie == null ? null : food_calorie.trim();
	    }

	    public String getFood_type() {
	        return food_type;
	    }

	    public void setFood_type(String food_type) {
	        this.food_type = food_type == null ? null : food_type.trim();
	    }

	    public String getFood_label() {
	        return food_label;
	    }

	    public void setFood_label(String food_label) {
	        this.food_label = food_label == null ? null : food_label.trim();
	    }

	    public BigDecimal getFood_price() {
	        return food_price;
	    }

	    public void setFood_price(BigDecimal food_price) {
	        this.food_price = food_price;
	    }

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "food";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "food_id";
	}
}