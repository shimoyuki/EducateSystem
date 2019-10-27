package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;  

import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;

import com.jks.dao.EducationTrainDao;
import com.jks.entity.EducationTrain;
import com.jks.service.EducationTrainService;


@Service
@Transactional 
public class EducationTrainServiceImpl implements EducationTrainService{
	
	@Resource  
    private EducationTrainDao educationTrainDao;
	

	@Override
	public List<EducationTrain> getEducationTrainList(String admcode,String year){
		
		List<EducationTrain> educationTrain = educationTrainDao.getEducationTrainList(admcode,year);
		
		return educationTrain;
		
	}


	@Override
	public void saveEducationTrain(EducationTrain educationTrain) {
		
		educationTrainDao.saveEducationTrain(educationTrain);
		
	}

	
	
	@Override
	public  boolean deleteEducationTrain(int id)  {
		
		return  educationTrainDao.deleteEducationTrain(id);
	
	}


	@Override
	public EducationTrain findById(int id) {

		EducationTrain educationTrain = educationTrainDao.findById(id); 
		
		return educationTrain;
	}

		
	
	@Override
	public boolean updateEducationTrain(EducationTrain educationTrain) {  
          return educationTrainDao.updateEducationTrain(educationTrain);  
    }


	@Override
	public boolean updateAudit(int id) {
		return educationTrainDao.updateAudit(id);
	}


	@Override
	public List<EducationTrain> findByCity(String city, String year) {
		List<EducationTrain> list = educationTrainDao.findByCity( city,  year);
		return list;
	}


	@Override
	public Integer checkYear(EducationTrain educationTrain) {
		// TODO Auto-generated method stub
		return educationTrainDao.checkYear(educationTrain);
	}

}
