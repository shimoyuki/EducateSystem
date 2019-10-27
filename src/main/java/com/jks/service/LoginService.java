package com.jks.service;

import com.jks.entity.Informant;
import com.jks.entity.SchoolInfo;
import com.jks.entity.User;

public interface LoginService {
	public int getUserIDByCode(String usercode);
	public String getPWByID(int id);
	public int getInforByUser(String usercode);
	public int insertAndGet(Informant info);
	public SchoolInfo getSchoolInfo(String usercode);
	public User getUserByCode(String usercode);
	public int updateLoginCount(String usercode);
}
