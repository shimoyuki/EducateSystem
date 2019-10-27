package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jks.dao.UserMapper;
import com.jks.entity.User;
import com.jks.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper um;
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return um.selectAllUser();
	}
	@Override
	public boolean deleteAccount(int id) {
		// TODO Auto-generated method stub
		return um.deleteByPrimaryKey(id);
	}
	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return um.selectByPrimaryKey(id);
	}
	@Override
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		return um.saveUser(user);
	}
	@Override
	public boolean updateAccount(User user) {
		// TODO Auto-generated method stub
		return um.updateByPrimaryKey(user)>0;
	}
	@Override
	public int getSum() {
		// TODO Auto-generated method stub
		return um.selectSumUser();
	}
	@Override
	public List<User> getAllUserByAccount(String account) {
		// TODO Auto-generated method stub
		return um.getAllUserByAccount(account);
	}

}
