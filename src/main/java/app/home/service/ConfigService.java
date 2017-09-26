package app.home.service;

import java.util.List;

import app.home.model.Config;

public interface ConfigService {

	Integer add(Config record);
	
	Integer delete(String id);
	
	Config find(String id);

	Integer save(Config record);
	
	List<Config> select();
	
}
