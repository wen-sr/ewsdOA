package app.home.dao;

import java.util.List;

import app.home.model.Config;

public interface ConfigMapper {
    int deleteByPrimaryKey(String id);

    int insert(Config record);

    int insertSelective(Config record);

    Config selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Config record);

    int updateByPrimaryKey(Config record);
    
    List<Config> selectAll();
}