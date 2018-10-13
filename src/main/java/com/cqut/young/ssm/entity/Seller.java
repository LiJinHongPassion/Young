package com.cqut.young.ssm.entity;

import com.cqut.young.ssm.entity.base.Entity;

public class Seller extends Entity {
    private String seller_id;

    private String seller_type_id;

    private String seller_name;

    private String seller_address;

    private String seller_introl;

    private String seller_label;

    private String seller_img_path;

    private String seller_tel;

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id == null ? null : seller_id.trim();
    }

    public String getSeller_type_id() {
        return seller_type_id;
    }

    public void setSeller_type_id(String seller_type_id) {
        this.seller_type_id = seller_type_id == null ? null : seller_type_id.trim();
    }

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name == null ? null : seller_name.trim();
    }

    public String getSeller_address() {
        return seller_address;
    }

    public void setSeller_address(String seller_address) {
        this.seller_address = seller_address == null ? null : seller_address.trim();
    }

    public String getSeller_introl() {
        return seller_introl;
    }

    public void setSeller_introl(String seller_introl) {
        this.seller_introl = seller_introl == null ? null : seller_introl.trim();
    }

    public String getSeller_label() {
        return seller_label;
    }

    public void setSeller_label(String seller_label) {
        this.seller_label = seller_label == null ? null : seller_label.trim();
    }

    public String getSeller_img_path() {
        return seller_img_path;
    }

    public void setSeller_img_path(String seller_img_path) {
        this.seller_img_path = seller_img_path == null ? null : seller_img_path.trim();
    }

    public String getSeller_tel() {
        return seller_tel;
    }

    public void setSeller_tel(String seller_tel) {
        this.seller_tel = seller_tel == null ? null : seller_tel.trim();
    }

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "seller";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "seller_id";
	}
}