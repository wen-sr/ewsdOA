package app.home.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import app.common.base.ExecuteResult;
import app.home.model.Article;
import app.home.model.ArticleWithBLOBs;
import app.home.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController{
	
	private ArticleService articleService;
	private ExecuteResult executeResult = new ExecuteResult();
	private String viewPath = "App/OA/Article/";

	public ArticleService getArticleService() {
		return articleService;
	}

	@Autowired
	public void setUserService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@RequestMapping("add")
	public String add(){
		return viewPath + "add";
	}
	
	@ResponseBody
	@RequestMapping("addInfo")
	public Object addInfo(ArticleWithBLOBs article){
		try {
			if(articleService.add(article) == 1)
				return executeResult.jsonReturn(200);
			else
				return executeResult.jsonReturn(300);
		} catch (Exception e) {
			e.printStackTrace();
			return executeResult.jsonReturn(300, e.getMessage());
		}
	}
	
	@RequestMapping("/index")
	public String showAllList(HttpServletRequest request){
		String a= request.getContextPath();
		System.out.println(a);
		try {
			List<Article> list = articleService.select();
			System.out.println(list);
			request.setAttribute("list", list);
			return viewPath + "index";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
			return viewPath + "result";
		}
	}
	
	@RequestMapping("/edit")
	public String modify(String id,HttpServletRequest request){
		try {
			Article info = articleService.find(id);
			request.setAttribute("info", info);
			return viewPath + "edit";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
			return viewPath + "result";
		}
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Object update(ArticleWithBLOBs article){
		try {
			if(articleService.save(article) == 1)
				return executeResult.jsonReturn(200);
			else
				return executeResult.jsonReturn(300);
		} catch (Exception e) {
			e.printStackTrace();
			return executeResult.jsonReturn(300, e.getMessage());
		}
	}
	
	@RequestMapping("/show/{id}")
	public String showUser(@PathVariable String id, HttpServletRequest request) {
		Article info = articleService.find(id);
		request.setAttribute("info", info);
		return viewPath + "show";
	}
	
	@ResponseBody
	@RequestMapping("delete")
	public Object del(String id,HttpServletRequest request){
		try {
			if (articleService.delete(id) == 1)
				return executeResult.jsonReturn(200, false);
			else
				return executeResult.jsonReturn(300, false);
		} catch (Exception e) {
			e.printStackTrace();
			return executeResult.jsonReturn(300, e.getMessage(), false);
		}
	}
}
