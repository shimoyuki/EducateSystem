package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jks.dao.InternMapper;
import com.jks.entity.Internship;
import com.jks.service.InternshipService;;

@Service
@Transactional 
public class InternshipServiceImpl implements InternshipService{
	@Resource
	private InternMapper intern;
	@Override
	public List<Internship> getInternshipList(String admcode,String year) {
		// TODO Auto-generated method stub
		return intern.getInternshipList(admcode,year);
	}

	@Override
	public List<Internship> getByUsercodeAndYear(String admcode, String year) {
		// TODO Auto-generated method stub
		return intern.getByUsercodeAndYear(admcode, year);
	}

	@Override
	public void saveInternship(Internship internship) {
		// TODO Auto-generated method stub
		intern.saveInternship(internship);
	}

	@Override
	public boolean deleteInternship(int id) {
		// TODO Auto-generated method stub
		return intern.deleteInternship(id);
	}

	@Override
	public Internship findById(int id) {
		// TODO Auto-generated method stub
		return intern.findById(id);
	}

	@Override
	public boolean updateInternship(Internship internship) {
		// TODO Auto-generated method stub
		return intern.updateInternship(internship);
	}

	
	public List<Internship> findByCity(String city, String year) {
		// TODO Auto-generated method stub
		return intern.findByCity(city, year);
	}

	@Override
	public boolean updateAudit(int id) {
		// TODO Auto-generated method stub
		return intern.updateAudit(id);
	}

	@Override
	public Integer checkYear(Internship internship) {
		// TODO Auto-generated method stub
		return intern.checkYear( internship);
	}

	@Override
	public List<Internship> adminFindByCity(String city, String years) {
		// TODO Auto-generated method stub
		return intern.adminFindByCity(city, years);
	}

	@Override
	public List<Internship> getInternshipListByAdmin(String admcode, String years) {
		// TODO Auto-generated method stub
		return intern.getInternshipListByAdmin(admcode,years);
	}


}
