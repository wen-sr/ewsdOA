package app.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.home.dao.UserMapper;
import app.home.model.User;
import app.home.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	private UserMapper thisMapper;
	
	public UserMapper getUserMapper() {
		return thisMapper;
	}
	
	@Autowired
	public void setUserMapper(UserMapper thisMapper){
		this.thisMapper = thisMapper;
	}
	
	public List<User> select() {
		return thisMapper.selectAll();
	}

	public List<User> getAll2() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getAll3() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer save(User info) {
		info.setUtime(System.currentTimeMillis());
		return thisMapper.updateByPrimaryKeySelective(info);
	}

	public User find(String uid) {
		return thisMapper.selectByPrimaryKey(uid);
	}

}
