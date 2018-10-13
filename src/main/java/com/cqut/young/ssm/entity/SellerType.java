package com.cqut.young.ssm.entity;

import com.cqut.young.ssm.entity.base.Entity;

public class SellerType extends Entity {
    private String seller_type_id;

    private String seller_type_name;

    public String getSeller_type_id() {
        return seller_type_id;
    }

    public void setSeller_type_id(String seller_type_id) {
        this.seller_type_id = seller_type_id == null ? null : seller_type_id.trim();
    }

    public String getSeller_type_name() {
        return seller_type_name;
    }

    public void setSeller_type_name(String seller_type_name) {
        this.seller_type_name = seller_type_name == null ? null : seller_type_name.trim();
    }

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "seller_type";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "seller_type_id";
	}
}