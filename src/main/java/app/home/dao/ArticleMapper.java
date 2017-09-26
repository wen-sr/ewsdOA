package app.home.dao;

import java.util.List;

import app.home.model.Article;
import app.home.model.ArticleWithBLOBs;

public interface ArticleMapper {
    int deleteByPrimaryKey(String id);

    int insert(ArticleWithBLOBs record);

    int insertSelective(ArticleWithBLOBs record);

    ArticleWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(ArticleWithBLOBs record);

    int updateByPrimaryKey(Article record);
    
    List<Article> selectAll();
}