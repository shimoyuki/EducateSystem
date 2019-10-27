package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jks.dao.MajorLayoutDao;
import com.jks.entity.MajorLayout;
import com.jks.service.MajorLayoutService;

@Service
@Transactional
public class MajorLayoutServiceImpl implements MajorLayoutService{
	
	@Resource  
    private MajorLayoutDao majorLayoutDao;
	
	@Override
	public List<MajorLayout> getMajorLayoutList(String admcode,String year){
		
		List<MajorLayout> majorLayout = majorLayoutDao.getMajorLayoutList(admcode,year);
		
		return majorLayout;
		
	}

	@Override
	public boolean saveMajorLayout(MajorLayout majorLayout) {
		return majorLayoutDao.saveMajorLayout(majorLayout);
		
	}

	@Override
	public boolean deleteMajorLayout(int id) {
		
		return majorLayoutDao.deleteMajorLayout(id);
	}

	@Override
	public MajorLayout findById(int id) {
		MajorLayout majorLayout = majorLayoutDao.findById(id);
		return majorLayout;
	}

	@Override
	public boolean updateMajorLayout(MajorLayout majorLayout) {
		
		return majorLayoutDao.updateMajorLayout(majorLayout);
	}

	@Override
	public boolean updateAudit(int id) {
		
		return majorLayoutDao.updateAudit(id);
	}

	@Override
	public List<MajorLayout> findByCity(String city, String year) {
		List<MajorLayout> list = majorLayoutDao.findByCity( city,  year);
		return list;
	}

	@Override
	public Integer checkYear(MajorLayout majorLayout) {
		// TODO Auto-generated method stub
		return majorLayoutDao.checkYear(majorLayout);
	}

}
