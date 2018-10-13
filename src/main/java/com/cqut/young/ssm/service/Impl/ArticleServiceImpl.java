package com.cqut.young.ssm.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqut.young.ssm.dao.base.Dao;
import com.cqut.young.ssm.dao.base.SearchDao;
import com.cqut.young.ssm.entity.Article;
import com.cqut.young.ssm.entity.base.Entity;
import com.cqut.young.ssm.service.IArticleService;

@Service("articleService") 
public class ArticleServiceImpl implements IArticleService {
	
	@Resource
	private Dao entityDao;
	@Resource
	private SearchDao searchDao;

	@Override
	public Map<String, Object> addArticle(Map<String, Object> properties) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> deleteArticle(String article_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> updateArticle(Map<String, Object> properties) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getArticleById(String article_id) {
		
		article_id = article_id.trim();

		Map<String, Object> result = new HashMap<>();
		
		String joinEntity = " LEFT JOIN seller on seller.seller_id = article.seller_id ";
		
		String condition = " article_id = '" + article_id + "'";
		
		
		result = searchDao.searchWithPageInMysql(new String[]{
					"article.article_id",
					"article.seller_id",
					"article.article_title",
					"article.article_introl",
					"article.article_img_path",
					"article.article_type",
					"article.article_time",
					"article.article_label",
					"article.article_view_num",
					"seller.seller_name",
					"seller.seller_img_path",
					"seller.seller_address"},
					Entity.getTableName(Article.class),
					joinEntity, 
					null, 
					null,
					condition, 
					null, 
					null, 
					null, 
					0, 
					1).get(0);
		
		
		if( result.isEmpty() || result == null){
			result.put("result", "-1");
			return result;
		}
		result.put("result", "1");
		return result;
	}

	@Override
	public List<Map<String, Object>> getArticleByCondition(String condition, String page, String row) {
		
		Map<String, Object> result = new HashMap<>();
		
		condition = condition.trim();
		page = page.trim();
		row = row.trim();
		
		char[] array = condition.toCharArray();
		
		String temp = "%";
		for(char c : array){
			temp += c + "%";
		}
		
		
		
		String joinEntity = " LEFT JOIN seller on seller.seller_id = article.seller_id ";
		
		List<Map<String, Object>> resultList = null;
		while(resultList == null || resultList.isEmpty()){
			
			condition = " article.article_label like '" + temp 
				+ "' or article.article_title like '" + temp + "'";
			
			resultList = searchDao.searchWithPageInMysql(new String[]{
					"article.article_id",
					"article.seller_id",
					"article.article_title",
					"article.article_introl",
					"article.article_img_path",
					"article.article_type",
					"article.article_label",
					"article.article_view_num",
					"seller.seller_name",
					"seller.seller_img_path",
					"seller.seller_address"},
					Entity.getTableName(Article.class),
					joinEntity, 
					null, 
					null,
					condition, 
					null, 
					null, 
					null, 
					Integer.parseInt(page)*Integer.parseInt(row), 
					Integer.parseInt(row));
			

			if(temp.length() > 2){
				temp = temp.substring(0, temp.length() - 2);
			}

			if(temp.length() == 0){
				break;
			}
		}
		
		if(resultList == null || resultList.isEmpty()){
			result.put("result", "-1");
			resultList.add(result);
			return resultList;
		}
		
		result.put("result", "1");
		resultList.add(result);
		return resultList;
	}

	@Override
	public List<Map<String, Object>> getRecommend() {
		
		List<Article> list = entityDao.getByCondition(" 1 = 1 ", Article.class);
		
		Map<String, Object> result = new HashMap<>();
		
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		
		if(list.size() > 3){
			resultList.add(list.get((int)(0+Math.random()*(list.size()-0+1))).toMap());
			resultList.add(list.get((int)(0+Math.random()*(list.size()-0+1))).toMap());
			resultList.add(list.get((int)(0+Math.random()*(list.size()-0+1))).toMap());
		}else{
			for(int a = 0; a < list.size(); a++){
				resultList.add(list.get(a).toMap());
			}
		}
		
		if(resultList.size() == 0 || resultList == null){
			result.put("result", "-1");
			resultList.add(result);
			return resultList;
		}
		
		result.put("result", "1");
		resultList.add(result);
		return resultList;
	}

	@Override
	public List<Map<String, Object>> getNewArticle() {

		Map<String, Object> result = new HashMap<>();
		
		String joinEntity = " LEFT JOIN seller on seller.seller_id = article.seller_id ";
		
		List<Map<String, Object>> resultList = searchDao.searchWithPageInMysql(new String[]{
					"article.article_id",
					"article.seller_id",
					"article.article_title",
					"article.article_introl",
					"article.article_img_path",
					"article.article_type",
					"article.article_time",
					"article.article_label",
					"article.article_view_num",
					"seller.seller_name",
					"seller.seller_img_path",
					"seller.seller_address"},
					Entity.getTableName(Article.class),
					joinEntity, 
					null, 
					null,
					" 1 = 1 ", 
					null, 
					null, 
					"article.article_time",
					0, 
					5);
		
		
		if( result.isEmpty() || result == null){
			result.put("result", "-1");
			resultList.add(result);
			return resultList;
		}
		
		result.put("result", "1");
		resultList.add(result);
		return resultList;
	}

	@Override
	public List<Map<String, Object>> getHotArticle() {
		// TODO Auto-generated method stub
Map<String, Object> result = new HashMap<>();
		
		String joinEntity = " LEFT JOIN seller on seller.seller_id = article.seller_id ";
		
		List<Map<String, Object>> resultList = searchDao.searchWithPageInMysql(new String[]{
					"article.article_id",
					"article.seller_id",
					"article.article_title",
					"article.article_introl",
					"article.article_img_path",
					"article.article_type",
					"article.article_time",
					"article.article_label",
					"article.article_view_num",
					"seller.seller_name",
					"seller.seller_img_path",
					"seller.seller_address"},
					Entity.getTableName(Article.class),
					joinEntity, 
					null, 
					null,
					" 1 = 1 ", 
					null, 
					null, 
					"article.article_view_num",
					0, 
					5);
		
		
		if( result.isEmpty() || result == null){
			result.put("result", "-1");
			resultList.add(result);
			return resultList;
		}
		
		result.put("result", "1");
		resultList.add(result);
		return resultList;
	}
	
	

}
