package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jks.dao.GroupSchoolMapper;
import com.jks.entity.Groupschool;
import com.jks.service.GroupschoolService;

@Service
@Transactional 
public class GroupschoolImpl implements GroupschoolService{
	
	@Resource
	private GroupSchoolMapper groupMapper;

	@Override
	public List<Groupschool> getGroupschoolList(String admcode,String year){
		// TODO Auto-generated method stub
		List<Groupschool> groupschool = groupMapper.getGroupschoolList(admcode,year);
		
		return groupschool;
	}

	@Override
	public void saveGroupschool(Groupschool groupschool) {
		// TODO Auto-generated method stub
		groupMapper.saveGroupschool(groupschool);
	}

	@Override
	public boolean deleteGroupschool(int id) {
		// TODO Auto-generated method stub
		return groupMapper.deleteGroupschool(id);
	}

	@Override
	public Groupschool findById(int id) {
		// TODO Auto-generated method stub
		Groupschool groupschool = groupMapper.findById(id);
		return groupschool;
	}

	@Override
	public boolean updateGroupschool(Groupschool groupschool) {
		// TODO Auto-generated method stub
		return groupMapper.updateGroupschool(groupschool);
	}

	@Override
	public List<Groupschool> getByAdmcode(String username, String year) {
		// TODO Auto-generated method stub
		return groupMapper.getByUsercodeAndYear(username, year);
	}

	@Override
	public List<Groupschool> findByCity(String city, String year) {
		// TODO Auto-generated method stub
		return groupMapper.findByCity(city, year);
	}

	@Override
	public boolean updateAudit(int id) {
		// TODO Auto-generated method stub
		return groupMapper.updateAudit(id);
	}

	@Override
	public Integer checkYear(Groupschool groupschool) {
		// TODO Auto-generated method stub
		return groupMapper.checkYear( groupschool);
	}

	@Override
	public List<Groupschool> adminFindByCity(String city, String years) {
		// TODO Auto-generated method stub
		return groupMapper.adminFindByCity(city, years);
	}

	@Override
	public List<Groupschool> getGroupschoolListByAdmin(String admcode, String years) {
		// TODO Auto-generated method stub
List<Groupschool> groupschool = groupMapper.getGroupschoolListByAdmin(admcode,years);
		
		return groupschool;
	}

}
