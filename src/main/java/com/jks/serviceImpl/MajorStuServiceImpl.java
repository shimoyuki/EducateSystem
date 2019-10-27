package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jks.dao.MajorStuDao;
import com.jks.entity.MajorStu;
import com.jks.service.MajorStuService;

@Service
@Transactional
public class MajorStuServiceImpl implements MajorStuService{
	
	@Resource  
    private MajorStuDao majorStuDao;
	
	@Override
	public List<MajorStu> getMajorStuList(int id){
		
		List<MajorStu> majorStu = majorStuDao.getMajorStuList(id);
		
		return majorStu;
		
	}

	@Override
	public boolean saveMajorStu(MajorStu majorStu) {
		return majorStuDao.saveMajorStu(majorStu);
		
	}

	@Override
	public boolean deleteMajorStu(String admcode, String year) {
		return majorStuDao.deleteMajorStu(admcode,year);
	}

	@Override
	public boolean updateMajorStu(MajorStu majorStu) {
		return majorStuDao.updateMajorStu(majorStu);
		
	}

	@Override
	public void deleteMajorStuTable(int ids) {
		majorStuDao.deleteMajorStuTable(ids);
		
	}

	@Override
	public boolean updateAudit(int id) {
		return majorStuDao.updateAudit(id);
	}

	

}
