package app.home.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.home.dao.ArticleMapper;
import app.home.model.Article;
import app.home.model.ArticleWithBLOBs;
import app.home.service.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	private ArticleMapper mapper;

	public ArticleMapper getArticleMapper() {
		return mapper;
	}

	@Autowired
	public void setArticleMapper(ArticleMapper mapper) {
		this.mapper = mapper;
	}

	public List<Article> select() {
		return mapper.selectAll();
	}
	
	public ArticleWithBLOBs find(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	public Integer save(Article articleInfo) {
		articleInfo.setUtime(System.currentTimeMillis());
		return mapper.updateByPrimaryKeySelective(articleInfo);
	}

	public Integer add(ArticleWithBLOBs articleInfo) {
		articleInfo.setId(UUID.randomUUID().toString());
		articleInfo.setVisitnums(0);
		articleInfo.setCtime(System.currentTimeMillis());
		return mapper.insertSelective(articleInfo);
	}

	public Integer delete(String id) {
		return mapper.deleteByPrimaryKey(id);
	}
	

}
