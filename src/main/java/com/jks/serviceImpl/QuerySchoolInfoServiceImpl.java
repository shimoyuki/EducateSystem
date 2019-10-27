package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;  

import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional; 

import com.jks.dao.QuerySchoolInfoDao;
import com.jks.entity.SchoolInfo;
import com.jks.service.QuerySchoolInfoService;


@Service
@Transactional 
public class QuerySchoolInfoServiceImpl implements QuerySchoolInfoService{
	
	 @Resource  
   private QuerySchoolInfoDao querySchoolInfoDao;
	

	@Override
	public List<SchoolInfo> findByArea(String area) {
		List<SchoolInfo> schoolInfo = querySchoolInfoDao.findByArea(area);
		return schoolInfo;
	}

}
