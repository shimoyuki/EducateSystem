package com.jks.serviceImpl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jks.dao.MajorMapper;
import com.jks.entity.Major;
import com.jks.service.MajorService;

@Service("majorService")
@Transactional
public class MajorServiceImpl extends BaseService implements MajorService {
	@Resource
	private MajorMapper majorDAO;
	
	@Override
	public Major getMajorById(String majorcode) {
		// TODO Auto-generated method stub
		return this.majorDAO.selectByPrimaryKey(majorcode);
	}

	@Override
	public boolean addMajor(Major major) {
		// TODO Auto-generated method stub
		if (this.majorDAO.insertSelective(major) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteMajor(String majorcode) {
		// TODO Auto-generated method stub
		if (this.majorDAO.deleteByPrimaryKey(majorcode) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyMajor(Major major) {
		// TODO Auto-generated method stub
		if (this.majorDAO.updateByPrimaryKeySelective(major) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public PageInfo<Major> getMajorPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		this.startPage(params);
		Page<Major> majorPage = this.majorDAO.query(params);
		return new PageInfo<Major>(majorPage);
	}

	@Override
	public String getMajorCode(String majorName) {
		// TODO Auto-generated method stub
		return this.majorDAO.selectCodeByName(majorName);
	}

	
}
