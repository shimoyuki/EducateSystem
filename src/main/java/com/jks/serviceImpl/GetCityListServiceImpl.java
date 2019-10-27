package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jks.dao.GetCityListDao;
import com.jks.entity.User;
import com.jks.service.GetCityListService;

@Service
@Transactional
public class GetCityListServiceImpl implements GetCityListService {
	@Resource
	GetCityListDao getCityListDao;
	
	@Override
	public List<User> getCityList() {
		// TODO Auto-generated method stub
		return this.getCityListDao.getCityList();
	}

}
