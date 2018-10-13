package com.cqut.young.ssm.service;

import java.util.List;
import java.util.Map;

public interface IArticleService {
	public Map<String, Object> addArticle(Map<String, Object> properties);
	
	public Map<String, Object> deleteArticle(String article_id);
	
	public Map<String, Object> updateArticle(Map<String, Object> properties);
	//不需要指明商家，这是在进入商家页面调用
	public Map<String, Object> getArticleById(String article_id);
	
	public List<Map<String, Object>> getArticleByCondition(String condition, String page, String row);
	//推荐
	public List<Map<String, Object>> getRecommend();
	
	public List<Map<String, Object>> getHotArticle();
	
	public List<Map<String, Object>> getNewArticle();
	
}
