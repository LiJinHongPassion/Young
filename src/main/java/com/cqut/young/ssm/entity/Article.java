package com.cqut.young.ssm.entity;

import com.cqut.young.ssm.entity.base.Entity;

public class Article extends Entity {
    private String article_id;

    private String seller_id;

    private String article_title;

    private String article_introl;

    private String article_img_path;

    private String article_type;

    private String article_label;

    private String article_view_num;
    
    private String article_time;

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id == null ? null : article_id.trim();
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id == null ? null : seller_id.trim();
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title == null ? null : article_title.trim();
    }

    public String getArticle_introl() {
        return article_introl;
    }

    public void setArticle_introl(String article_introl) {
        this.article_introl = article_introl == null ? null : article_introl.trim();
    }

    public String getArticle_img_path() {
        return article_img_path;
    }

    public void setArticle_img_path(String article_img_path) {
        this.article_img_path = article_img_path == null ? null : article_img_path.trim();
    }

    public String getArticle_type() {
        return article_type;
    }

    public void setArticle_type(String article_type) {
        this.article_type = article_type == null ? null : article_type.trim();
    }

    public String getArticle_label() {
        return article_label;
    }

    public void setArticle_label(String article_label) {
        this.article_label = article_label == null ? null : article_label.trim();
    }

    public String getArticle_view_num() {
        return article_view_num;
    }

    public void setArticle_view_num(String article_view_num) {
        this.article_view_num = article_view_num == null ? null : article_view_num.trim();
    }

	public String getArticle_time() {
		return article_time;
	}

	public void setArticle_time(String article_time) {
		this.article_time = article_time;
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "article";
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return "article_id";
	}

}