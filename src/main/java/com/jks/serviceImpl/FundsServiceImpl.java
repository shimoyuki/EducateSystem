package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jks.dao.FundsDao;
import com.jks.entity.Funds;
import com.jks.service.FundsService;

@Service
@Transactional
public class FundsServiceImpl implements FundsService{
	@Resource  
    private FundsDao fundsDao;	

	@Override
	public List<Funds>  getFundsList(String admcode,String year){
		List<Funds> funds = fundsDao.getFundsList(admcode,year);
		return funds;
	}

	@Override
	public boolean saveFunds(Funds funds) {
		return fundsDao.saveFunds(funds);
		
	}

	@Override
	public boolean deleteFunds(int id) {
		
		return fundsDao.deleteFunds(id);
	}

	@Override
	public Funds findById(int id) {
		Funds funds = fundsDao.findById(id);
		return funds;
	}

	@Override
	public boolean updateFunds(Funds funds) {
		return fundsDao.updateFunds(funds);
	}

	@Override
	public boolean updateAudit(int id) {
		return fundsDao.updateAudit(id);
	}

	@Override
	public List<Funds> findByCity(String city, String year) {
		List<Funds> funds = fundsDao.findByCity( city,  year);
		return funds;
	}

	@Override
	public Integer checkYear(Funds fundsObj) {
		// TODO Auto-generated method stub
		return fundsDao.checkYear(fundsObj);
	}
	

}
