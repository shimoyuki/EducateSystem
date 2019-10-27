package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jks.dao.EquitmentDao;
import com.jks.entity.Equitment;
import com.jks.service.EquitmentService;


@Service
@Transactional 
public class EquitmentServiceImpl implements EquitmentService{
	
	@Resource
	private EquitmentDao equitmentDao;

	@Override
	public List<Equitment> getEquitmentList(String admcode,String year) {
		List<Equitment> equitment = equitmentDao.getEquitmentList(admcode,year);	
		return equitment;
	}
	@Override
	public List<Equitment> getEquitmentListByAdmin(String admcode,String year) {
		List<Equitment> equitment = equitmentDao.getEquitmentListByAdmin(admcode,year);	
		return equitment;
	}

	@Override
	public void saveEquitment(Equitment equitment) {
		// TODO Auto-generated method stub
		equitmentDao.saveEquitment(equitment);
	}

	@Override
	public boolean deleteEquitment(int id) {
		// TODO Auto-generated method stub
		return equitmentDao.deleteEquitment(id);
	}

	@Override
	public Equitment findById(int id) {
		// TODO Auto-generated method stub
		Equitment equitment = equitmentDao.findById(id);
		return equitment;
	}

	@Override
	public boolean updateEquitment(Equitment equitment) {
		// TODO Auto-generated method stub
		return equitmentDao.updateEquitment(equitment);
	}

	@Override
	public List<Equitment> getByAdmcode(String username, String year) {
		// TODO Auto-generated method stub
		return equitmentDao.getByUsercodeAndYear(username, year);
	}

	@Override
	public boolean updateAudit(int id) {
		// TODO Auto-generated method stub
		return equitmentDao.updateAudit(id);
	}

	@Override
	public List<Equitment> findByCity(String city, String year) {
		// TODO Auto-generated method stub
		return equitmentDao.findByCity(city, year);
	}
	@Override
	public List<Equitment> adminFindByCity(String city, String year) {
		// TODO Auto-generated method stub
		return equitmentDao.adminFindByCity(city, year);
	}
	@Override
	public Integer checkYear(Equitment equitment) {
		// TODO Auto-generated method stub
		return equitmentDao.checkYear(equitment);
	}

}
