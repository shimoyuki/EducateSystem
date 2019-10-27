package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jks.dao.SchoolenterpriseMapper;
import com.jks.entity.Schoolenterprise;
import com.jks.service.SchoolenterpriseService;

@Service
@Transactional 
public class SchoolenterpriseImpl implements SchoolenterpriseService{

	@Resource
	private SchoolenterpriseMapper  schoolenterpriseMapper;

	@Override
	public List<Schoolenterprise> getSchoolenterpriseList(String admcode,String year) {
		// TODO Auto-generated method stub
		List<Schoolenterprise> schoolenterprise = schoolenterpriseMapper.getSchoolenterpriseList(admcode,year);
		return schoolenterprise;
	}
	@Override
	public List<Schoolenterprise> getSchoolenterpriseListByAdmin(String admcode,String year) {
		// TODO Auto-generated method stub
		List<Schoolenterprise> schoolenterprise = schoolenterpriseMapper.getSchoolenterpriseListByAdmin(admcode,year);
		return schoolenterprise;
	}

	@Override
	public List<Schoolenterprise> getByUsercodeAndYear(String admcode, String year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveSchoolenterprise(Schoolenterprise schoolenterprise) {
		// TODO Auto-generated method stub
		schoolenterpriseMapper.saveSchoolenterprise(schoolenterprise);
		
	}

	@Override
	public boolean deleteSchoolenterprise(int id) {
		// TODO Auto-generated method stub
		return schoolenterpriseMapper.deleteSchoolenterprise(id);
	}

	@Override
	public Schoolenterprise findById(int id) {
		// TODO Auto-generated method stub
		Schoolenterprise schoolenterprise = schoolenterpriseMapper.findById(id);
		return schoolenterprise;
	}

	@Override
	public boolean updateSchoolenterprise(Schoolenterprise schoolenterprise) {
		// TODO Auto-generated method stub
		return schoolenterpriseMapper.updateSchoolenterprise(schoolenterprise);
	}

	@Override
	public List<Schoolenterprise> getByAdmcode(String username, String year) {
		// TODO Auto-generated method stub
		return schoolenterpriseMapper.getByUsercodeAndYear(username, year);
	}

	@Override
	public List<Schoolenterprise> findByCity(String city, String year) {
		// TODO Auto-generated method stub
		return schoolenterpriseMapper.findByCity(city, year);
	}
	@Override
	public List<Schoolenterprise> adminFindByCity(String city, String year) {
		// TODO Auto-generated method stub
		return schoolenterpriseMapper.adminFindByCity(city, year);
	}
	@Override
	public boolean updateAudit(int id) {
		// TODO Auto-generated method stub
		return schoolenterpriseMapper.updateAudit(id);
	}

	@Override
	public Integer checkYear(Schoolenterprise schoolenterprise) {
		// TODO Auto-generated method stub
		return schoolenterpriseMapper.checkYear(schoolenterprise);
	}
	

}
