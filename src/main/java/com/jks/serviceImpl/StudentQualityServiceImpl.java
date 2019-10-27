package com.jks.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jks.dao.StudentQualityMapper;
import com.jks.entity.StudentQuality;
import com.jks.service.StudentQualityService;

@Service("studService")
@Transactional
public class StudentQualityServiceImpl extends BaseService implements StudentQualityService{

	@Resource
	private StudentQualityMapper studDAO;
	
	@Override
	public StudentQuality getStudentQualityById(int sId) {
		// TODO Auto-generated method stub
		return this.studDAO.selectByPrimaryKey(sId);
	}

	@Override
	public boolean addStudentQuality(StudentQuality stud) {
		// TODO Auto-generated method stub
		if (this.studDAO.insertSelective(stud) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteStudentQuality(int sId) {
		// TODO Auto-generated method stub
		if (this.studDAO.deleteByPrimaryKey(sId) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyStudentQuality(StudentQuality stud) {
		// TODO Auto-generated method stub
		if (this.studDAO.updateByPrimaryKeySelective(stud) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public PageInfo<StudentQuality> getStudentQualityPage(
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		this.startPage(params);
		Page<StudentQuality> studPage = this.studDAO.query(params);
		return new PageInfo<StudentQuality>(studPage);
	}

	@Override
	public List<String> getAdmcodeByCity(String city) {
		// TODO Auto-generated method stub
		return this.studDAO.selectAdmcodeByCity(city);
	}

	
}
