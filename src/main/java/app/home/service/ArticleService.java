package app.home.service;

import java.util.List;

import app.home.model.Article;
import app.home.model.ArticleWithBLOBs;

public interface ArticleService {

	Integer add(ArticleWithBLOBs articleInfo);
	
	Integer delete(String id);
	
	ArticleWithBLOBs find(String id);

	Integer save(Article articleInfo);
	
	List<Article> select();
	
}
