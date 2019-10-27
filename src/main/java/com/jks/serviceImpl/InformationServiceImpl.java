package com.jks.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jks.dao.InformationMapper;
import com.jks.entity.Information;
import com.jks.service.InformationService;

@Service("infoService")
@Transactional
public class InformationServiceImpl extends BaseService implements InformationService {
	@Resource
	private InformationMapper infoDao;
	@Override
	public List<String> getAdmcodeByCity(String city) {
		// TODO Auto-generated method stub
		return infoDao.selectAdmcodeByCity(city);
	}
	@Override
	public PageInfo<Information> getInformationPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		this.startPage(params);
		Page<Information> infoPage=infoDao.query(params);
		return  new PageInfo<Information>(infoPage);
	}
	@Override
	public boolean addInformation(Information info) {
		// TODO Auto-generated method stub
		if (infoDao.insertSelective(info) > 0) {
			return true;
		}
		return false;
	}
	@Override
	public Information getInformationById(int id) {
		// TODO Auto-generated method stub
		return infoDao.selectByPrimaryKey(id);
	}
	@Override
	public boolean modifyInfo(Information info) {
		// TODO Auto-generated method stub
		if (infoDao.updateByPrimaryKeySelective(info) > 0) {
			return true;
		}
		return false;
	}
	@Override
	public boolean deleteInfo(int id) {
		// TODO Auto-generated method stub
		if (infoDao.deleteByPrimaryKey(id) > 0) {
			return true;
		}
		return false;
	}
	
}
