package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jks.dao.PolicyDao;
import com.jks.entity.Policy;
import com.jks.service.PolicyService;

@Service
@Transactional
public class PolicyServiceImpl implements PolicyService{
	@Resource  
    private PolicyDao policyDao;	

	@Override
	public List<Policy> getPolicyList(String admcode,String year){
		List<Policy> policy = policyDao.getPolicysList(admcode,year);
		return policy;
	}

	@Override
	public boolean savePolicy(Policy policy) {
		return policyDao.savePolicy(policy);
		
	}

	@Override
	public boolean deletePolicy(int id) {
		return policyDao.deletePolicy(id);
	}

	@Override
	public Policy findById(int id) {
		Policy policy = policyDao.findById(id);
		return policy;
	}

	@Override
	public boolean updatePolicy(Policy policy) {	
		return policyDao.updatePolicy(policy);
	}

	@Override
	public boolean updateAudit(int id) {
		return policyDao.updateAudit(id);
	}

	@Override
	public List<Policy> findByCity(String city, String year) {
		List<Policy> policy = policyDao.findByCity( city,  year);
		return policy;
	}

	@Override
	public Integer checkYear(Policy policy) {
		// TODO Auto-generated method stub
		return policyDao.checkYear(policy);
	}

	
}
