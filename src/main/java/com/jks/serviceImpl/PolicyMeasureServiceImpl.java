package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jks.dao.PolicyMeasureDao;
import com.jks.entity.PolicyMeasure;
import com.jks.service.PolicyMeasureService;

@Service
@Transactional
public class PolicyMeasureServiceImpl implements PolicyMeasureService{
	
	@Resource  
    private PolicyMeasureDao policyMeasureDao;
	
	@Override
	public List<PolicyMeasure> getPolicyMeasureList(int id) {
		 List<PolicyMeasure> policyMeasure = policyMeasureDao.getPolicyMeasureList(id);
		return policyMeasure;
	}

	@Override
	public boolean savePolicyMeasure(PolicyMeasure policyMeasure) {
		return policyMeasureDao.savePolicyMeasure(policyMeasure);
		
	}

	@Override
	public boolean deletePolicyMeasure(String admcode, String year) {
		
		return policyMeasureDao.deletePolicyMeasure( admcode,  year);
	}

	@Override
	public boolean updateProjectInput(PolicyMeasure policyMeasure) {
		return policyMeasureDao.updateProjectInput(policyMeasure);
		
	}

	@Override
	public void deletePolicyTable(int ids) {
		policyMeasureDao.deletePolicyTable(ids);
		
	}

	@Override
	public boolean updateAudit(int id) {
		return policyMeasureDao.updateAudit(id);
	}

}
