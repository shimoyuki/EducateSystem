package com.jks.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jks.dao.EmployQualityMapper;
import com.jks.entity.EmployQuality;
import com.jks.service.EmployQualityService;

@Service("empService")
@Transactional
public class EmployQualityServiceImpl extends BaseService implements EmployQualityService{

	@Resource
	private EmployQualityMapper empDAO;
	
	@Override
	public EmployQuality getEmployQualityById(int eId) {
		// TODO Auto-generated method stub
		return this.empDAO.selectByPrimaryKey(eId);
	}

	@Override
	public boolean addEmployQuality(EmployQuality emp) {
		// TODO Auto-generated method stub
		if (this.empDAO.insertSelective(emp) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEmployQuality(int eId) {
		// TODO Auto-generated method stub
		if (this.empDAO.deleteByPrimaryKey(eId) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyEmployQuality(EmployQuality emp) {
		// TODO Auto-generated method stub
		if (this.empDAO.updateByPrimaryKeySelective(emp) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public PageInfo<EmployQuality> getEmployQualityPage(
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		this.startPage(params);
		Page<EmployQuality> empPage = this.empDAO.query(params);
		return new PageInfo<EmployQuality>(empPage);
	}

	@Override
	public List<String> getAdmcodeByCity(String city) {
		// TODO Auto-generated method stub
		return this.empDAO.selectAdmcodeByCity(city);
	}

}
