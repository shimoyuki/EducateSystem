package com.jks.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jks.dao.TeachersMapper;
import com.jks.entity.Teachers;
import com.jks.service.TeachersService;


@Service("teacService")
@Transactional
public class TeachersServiceImpl extends BaseService implements TeachersService {
	@Resource
	private TeachersMapper teacDAO;

	@Override
	public Teachers getTeachersById(int tId) {
		// TODO Auto-generated method stub
		return this.teacDAO.selectByPrimaryKey(tId);
	}
	
	@Override
	public List<Teachers>  getTeachersByYear(String year) {
		// TODO Auto-generated method stub
		return this.teacDAO.selectByYear(year);
	}

	@Override
	public List<Teachers> getTeachersList() {
		// TODO Auto-generated method stub
		return this.teacDAO.selectAll();
	}

	@Override
	public boolean addTeachers(Teachers teac) {
		// TODO Auto-generated method stub
		if (this.teacDAO.insertSelective(teac) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteTeachers(int tId) {
		// TODO Auto-generated method stub
		if (this.teacDAO.deleteByPrimaryKey(tId) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyTeachers(Teachers teac) {
		// TODO Auto-generated method stub
		if (this.teacDAO.updateByPrimaryKeySelective(teac) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public PageInfo<Teachers> getTeachersPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		
		this.startPage(params);
		Page<Teachers> teacPage = teacDAO.query(params);
		return new PageInfo<Teachers>(teacPage);
	}

	@Override
	public List<String> getAdmcodeByCity(String city) {
		// TODO Auto-generated method stub
		return this.teacDAO.selectAdmcodeByCity(city);
	}

}
