package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jks.dao.MajorNumDao;
import com.jks.entity.MajorNum;
import com.jks.service.MajorNumService;

@Service
@Transactional
public class MajorNumServiceImpl implements MajorNumService{
	@Resource  
    private MajorNumDao majorNumDao;
	
	@Override
	public List<MajorNum> getMajorNumList(String admcode,String year){
		
		List<MajorNum> majorNum = majorNumDao.getMajorNumList(admcode,year);
		
		return majorNum;
		
	}
	
	@Override
	public void saveMajorNum(MajorNum majorNum) {
		
		majorNumDao.saveMajorNum(majorNum);
	
	}
	
	@Override
	public  boolean deleteMajorNum(int id)  {
		
		return  majorNumDao.deleteMajorNum(id);
	
	}
	
	@Override
	public MajorNum findById(int id) {  
		MajorNum majorNum = majorNumDao.findById(id);  
        return majorNum;  
    }
	
	@Override
	public boolean updateMajorNum(MajorNum majorNum) {  
          return majorNumDao.updateMajorNum(majorNum);  
    }

	@Override
	public boolean updateAudit(int id) {
		return majorNumDao.updateAudit(id);
	}

	@Override
	public List<MajorNum> findByCity(String city, String year) {
		List<MajorNum> list =  majorNumDao.findByCity( city,  year);
		return list;
	}

	@Override
	public Integer checkYear(MajorNum majorNum) {
		// TODO Auto-generated method stub
		return majorNumDao.checkYear(majorNum);
	}
	

}
