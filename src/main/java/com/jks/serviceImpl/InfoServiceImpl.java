package com.jks.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jks.dao.InformantMapper;
import com.jks.dao.UserMapper;
import com.jks.entity.Informant;
import com.jks.service.InfoService;
@Service
public class InfoServiceImpl implements InfoService {

	@Resource
	InformantMapper im;
	@Resource
	UserMapper um;
	@Override
	public Informant getInfoByUserCode(String usercode) {
		// TODO Auto-generated method stub
		return im.selectByUserCode(usercode);
	}
	@Override
	public String getPWByUserCode(String usercode) {
		// TODO Auto-generated method stub
		return um.selectPWByUserCode(usercode);
	}
	@Override
	public int updatePWByUserCode(String password, String usercode) {
		// TODO Auto-generated method stub
		return um.updatePWByUserCode(password, usercode);
	}
	@Override
	public int getSum() {
		// TODO Auto-generated method stub
		return im.selectSumUser();
	}
	@Override
	public int getLoginCount() {
		// TODO Auto-generated method stub
		return im.selectLoginCount();
	}
	
}
