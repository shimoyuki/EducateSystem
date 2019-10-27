package com.jks.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jks.dao.SocialServiceMapper;
import com.jks.entity.SocialService;
import com.jks.service.SocialServiceService;

@Service("socialService")
@Transactional
public class SocialServiceServiceImpl extends BaseService implements
		SocialServiceService {

	@Resource
	private SocialServiceMapper socialDAO;
	
	@Override
	public SocialService getSocialServiceById(int sId) {
		// TODO Auto-generated method stub
		return this.socialDAO.selectByPrimaryKey(sId);
	}

	@Override
	public boolean addSocialService(SocialService social) {
		// TODO Auto-generated method stub
		if (this.socialDAO.insertSelective(social) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteSocialService(int sId) {
		// TODO Auto-generated method stub
		if (this.socialDAO.deleteByPrimaryKey(sId) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifySocialService(SocialService social) {
		// TODO Auto-generated method stub
		if (this.socialDAO.updateByPrimaryKeySelective(social) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public PageInfo<SocialService> getSocialServicePage(
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		this.startPage(params);
		Page<SocialService> socialPage = this.socialDAO.query(params);
		return new PageInfo<SocialService>(socialPage);
	}

	@Override
	public List<String> getAdmcodeByCity(String city) {
		// TODO Auto-generated method stub
		return this.socialDAO.selectAdmcodeByCity(city);
	}

}
