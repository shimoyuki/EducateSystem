package com.jks.serviceImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jks.dao.MajorSchoolMapper;
import com.jks.dao.SchoolInfoMapper;
import com.jks.entity.SchoolDTO;
import com.jks.entity.SchoolInfo;
import com.jks.entity.MajorSchool;
import com.jks.service.SchoolInfoService;

@Service("schoolService")
@Transactional
public class SchoolInfoServiceImpl extends BaseService implements
		SchoolInfoService {
	@Resource
	private SchoolInfoMapper schoolDAO;
	
	@Resource
	private MajorSchoolMapper majSchDAO;

	@Override
	public SchoolDTO getSchoolInfoById(String admcode) {
		// TODO Auto-generated method stub
		SchoolDTO schoolDTO = new SchoolDTO();
		SchoolInfo school = this.schoolDAO.selectByPrimaryKey(admcode);
		schoolDTO.setMain(school);
		Map<String, Object> params = new TreeMap<String, Object>();
		params.put("admcode", school.getAdmcode());
		schoolDTO.setList(this.majSchDAO.query(params));
		return schoolDTO;
	}

	@Override
	public boolean addSchoolInfo(SchoolDTO schoolDTO) {
		// TODO Auto-generated method stub
		boolean result = true;
		if (this.schoolDAO.insertSelective(schoolDTO.getMain()) == 0) {
			result = false;
			return result;
		}
		if (schoolDTO.getList() != null) {
			Iterator<MajorSchool> iterator = schoolDTO.getList().iterator();
			while (iterator.hasNext()) {
				MajorSchool majSch = (MajorSchool) iterator.next();
				if (this.majSchDAO.insertSelective(majSch) == 0) {
					result = false;
				}
			}
		}
		return result;
	}

	@Override
	public boolean deleteSchoolInfo(String admcode) {
		// TODO Auto-generated method stub
		boolean result = true;
		SchoolInfo school = this.schoolDAO.selectByPrimaryKey(admcode);
		Map<String, Object> params = new TreeMap<String, Object>();
		params.put("admcode", school.getAdmcode());
		List<MajorSchool> majSchList = this.majSchDAO.query(params);
		if (majSchList.size() > 0) {
			if (this.majSchDAO.delete(params) == 0) {
				result = false;
				return result;
			}
		}
		if (this.schoolDAO.deleteByPrimaryKey(admcode) == 0) {
			Iterator<MajorSchool> iterator = majSchList.iterator();
			while (iterator.hasNext()) {
				this.majSchDAO.insertSelective(iterator.next());
			}
			result = false;
		}
		return result;
	}

	@Override
	public boolean modifySchoolInfo(SchoolDTO schoolDTO) {
		// TODO Auto-generated method stub
		boolean result = true;
		if (this.schoolDAO.updateByPrimaryKeySelective(schoolDTO.getMain()) == 0) {
			result = false;
			return result;
		}
		if(schoolDTO.getList() != null){
			Iterator<MajorSchool> iterator = schoolDTO.getList().iterator();
			while (iterator.hasNext()) {
				MajorSchool majSch = (MajorSchool) iterator.next();
				if (majSch.getId().equals(-1) ) {
					majSch.setId(null);
					if (this.majSchDAO.insertSelective(majSch) == 0) {
						result = false;
					}
				}else{
					if (this.majSchDAO.updateByPrimaryKeySelective(majSch) == 0) {
						result = false;
					}
				}
			}
		}
		return result;
	}

	@Override
	public PageInfo<SchoolInfo> getSchoolInfoPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		this.startPage(params);
		Page<SchoolInfo> schoolPage = this.schoolDAO.query(params);
		return new PageInfo<SchoolInfo>(schoolPage);
	}

	@Override
	public boolean deleteMajorSchool(int mId) {
		// TODO Auto-generated method stub
		if (this.majSchDAO.deleteByPrimaryKey(mId) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<MajorSchool> getMajorSchoolList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.majSchDAO.query(params);
	}
	
}
