package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jks.dao.QualityAssuranceDao;
import com.jks.entity.QualityAssurance;
import com.jks.service.QualityAssuranceService;

@Service
@Transactional 
public class QualityAssuranceServiceImpl implements QualityAssuranceService{
	
	@Resource  
    private QualityAssuranceDao qualityAssuranceDao;
	
	@Override
	public List<QualityAssurance> getQualityAssuranceList(String admcode,String year){
		
		List<QualityAssurance> qualityAssurance = qualityAssuranceDao.getQualityAssuranceList(admcode,year);
		
		return qualityAssurance;
		
	}

	@Override
	public void saveQualityAssurance(QualityAssurance qualityAssurance) {
		qualityAssuranceDao.saveQualityAssurance(qualityAssurance);
				
	}

	@Override
	public boolean deleteQualityAssurance(int id) {
		
		return qualityAssuranceDao.deleteQualityAssurance(id);
	}

	@Override
	public QualityAssurance findById(int id) {
		
		QualityAssurance qualityAssurance = qualityAssuranceDao.findById(id);
		
		return qualityAssurance;
	}

	@Override
	public boolean updateQualityAssurance(QualityAssurance qualityAssurance) {
		
		return qualityAssuranceDao.updateQualityAssurance(qualityAssurance);
	}

	@Override
	public boolean updateAudit(int id) {
		return qualityAssuranceDao.updateAudit(id);
	}

	@Override
	public List<QualityAssurance> findByCity(String city, String year) {
		List<QualityAssurance> list = qualityAssuranceDao.findByCity( city,  year);
		return list;
	}

	@Override
	public Integer checkYear(QualityAssurance qualityAssurance) {
		// TODO Auto-generated method stub
		return qualityAssuranceDao.checkYear(qualityAssurance);
	}

}
