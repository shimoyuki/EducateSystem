package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jks.dao.MajorQueryDao;
import com.jks.entity.Major;
import com.jks.service.MajorQueryService;

@Service
@Transactional
public class MajorQueryServiceImpl implements MajorQueryService{
	@Resource  
    private MajorQueryDao majorQueryDao;
	
	@Override
	public List<Major> getMajorQueryList(){
		
		List<Major> major = majorQueryDao.getMajorQueryList();
		
		return major;
		
	}
	
	
	@Override
	public List<Major> findByInduName(String induName) { 
		
		List<Major> major = majorQueryDao.findByInduName(induName);  
		
        return major;  
    }

	

}
