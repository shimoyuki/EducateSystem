package com.jks.service;

import java.util.List;

import com.jks.entity.User;

public interface UserService {
	public List<User> getAllUser();
	public boolean deleteAccount(int id);
	public User findById(int id);
	public int saveUser(User user);
	public boolean updateAccount(User user);
	public int getSum();
	public List<User> getAllUserByAccount(String account);
}
