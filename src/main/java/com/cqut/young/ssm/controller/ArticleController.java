package com.cqut.young.ssm.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.cqut.young.ssm.service.IArticleService;

@Controller
public class ArticleController {

	@Resource
	private IArticleService articleService;
	
	@RequestMapping(value="/article/getArticleById",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getArticleById(@RequestParam("article_id") String article_id){
		
		Map<String, Object> result = articleService.getArticleById(article_id);
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}
	
	@RequestMapping(value="/article/getArticleByCondition",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getArticleByCondition(@RequestParam("condition") String condition){
		
		List<Map<String, Object>> result = articleService.getArticleByCondition(condition, "0", "10");
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}
	
	@RequestMapping(value="/article/getRecommend",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getRecommend(){
		
		List<Map<String, Object>> result = articleService.getRecommend();
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}
	
	@RequestMapping(value="/article/getHotArticle",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getHotArticle(){
		
		List<Map<String, Object>> result = articleService.getHotArticle();
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}
	
	@RequestMapping(value="/article/getNewArticle",method=RequestMethod.GET,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String getNewArticle(){
		
		List<Map<String, Object>> result = articleService.getNewArticle();
		
		return JSON.toJSON(result).toString().replace("\"", "'");
	}

}
