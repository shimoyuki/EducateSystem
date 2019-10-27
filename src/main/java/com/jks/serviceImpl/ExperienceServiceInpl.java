package com.jks.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jks.dao.ExperienceMapper;
import com.jks.entity.Experience;
import com.jks.service.ExperienceService;

@Service("expService")
@Transactional
public class ExperienceServiceInpl extends BaseService implements
		ExperienceService {

	@Resource
	private ExperienceMapper expDAO;
	
	@Override
	public Experience getExperienceById(int eId) {
		// TODO Auto-generated method stub
		return this.expDAO.selectByPrimaryKey(eId);
	}

	@Override
	public boolean addExperience(Experience exp) {
		// TODO Auto-generated method stub
		if (this.expDAO.insertSelective(exp) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteExperience(int eId) {
		// TODO Auto-generated method stub
		if (this.expDAO.deleteByPrimaryKey(eId) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyExperience(Experience exp) {
		// TODO Auto-generated method stub
		if (this.expDAO.updateByPrimaryKeySelective(exp) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public PageInfo<Experience> getExperiencePage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		this.startPage(params);
		Page<Experience> expPage = this.expDAO.query(params);
		return new PageInfo<Experience>(expPage);
	}

	@Override
	public List<String> getAdmcodeByCity(String city) {
		// TODO Auto-generated method stub
		return this.expDAO.selectAdmcodeByCity(city);
	}

}
