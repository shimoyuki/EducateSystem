package com.jks.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jks.dao.InformantMapper;
import com.jks.dao.SchoolInfoMapper;
import com.jks.dao.UserMapper;
import com.jks.entity.Informant;
import com.jks.entity.SchoolInfo;
import com.jks.entity.User;
import com.jks.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
	@Resource
	private UserMapper um;
	@Resource
	private InformantMapper im;
	@Resource
	private SchoolInfoMapper sim;
	@Override
	public int getUserIDByCode(String usercode) {
		// TODO Auto-generated method stub
		return um.selectUserIDByCode(usercode);
	}
	@Override
	public String getPWByID(int id) {
		// TODO Auto-generated method stub
		return um.selectPWByID(id);
	}
	@Override
	public int getInforByUser(String usercode) {
		// TODO Auto-generated method stub
		return im.selectCountByUser(usercode);
	}
	@Override
	public int insertAndGet(Informant info) {
		// TODO Auto-generated method stub
		return im.insert(info);
	}
	@Override
	public SchoolInfo getSchoolInfo(String usercode) {
		// TODO Auto-generated method stub
		return sim.selectByPrimaryKey(usercode);
	}
	@Override
	public User getUserByCode(String usercode) {
		// TODO Auto-generated method stub
		return um.selectUserByCode(usercode);
	}
	@Override
	public int updateLoginCount(String usercode) {
		// TODO Auto-generated method stub
		return im.updateLoginCount(usercode);
	}

    
}
