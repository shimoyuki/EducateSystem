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
import com.jks.dao.SkillTrainMapper;
import com.jks.dao.SkillMapper;
import com.jks.entity.SkiTraDTO;
import com.jks.entity.SkillTrain;
import com.jks.entity.Skill;
import com.jks.service.SkillTrainService;

@Service("skiTraService")
@Transactional
public class SkillTrainServiceImpl extends BaseService implements
		SkillTrainService {

	@Resource
	private SkillTrainMapper skiTraDAO;
	@Resource
	private SkillMapper skillDAO;
	
	@Override
	public SkiTraDTO getSkillTrainById(int sId) {
		// TODO Auto-generated method stub
		SkiTraDTO skiTraDTO = new SkiTraDTO();
		SkillTrain skiTra = this.skiTraDAO.selectByPrimaryKey(sId);
		skiTraDTO.setMain(skiTra);
		Map<String, Object> params = new TreeMap<String, Object>();
		params.put("admcode", skiTra.getAdmcode());
		params.put("year", skiTra.getYear());
		skiTraDTO.setList(this.skillDAO.query(params));
		return skiTraDTO;
	}

	@Override
	public boolean addSkillTrain(SkiTraDTO skiTraDTO) {
		// TODO Auto-generated method stub
		boolean result = true;
		if (this.skiTraDAO.insertSelective(skiTraDTO.getMain()) == 0) {
			result = false;
			return result;
		}
		if (skiTraDTO.getList() != null) {
			Iterator<Skill> iterator = skiTraDTO.getList().iterator();
			while (iterator.hasNext()) {
				Skill skill = (Skill) iterator.next();
				if (this.skillDAO.insertSelective(skill) == 0) {
					result = false;
				}
			}
		}
		return result;
	}

	@Override
	public boolean deleteSkillTrain(int sId) {
		// TODO Auto-generated method stub
		boolean result = true;
		SkillTrain skiTra = this.skiTraDAO.selectByPrimaryKey(sId);
		Map<String, Object> params = new TreeMap<String, Object>();
		params.put("admcode", skiTra.getAdmcode());
		params.put("year", skiTra.getYear());
		List<Skill> skillList = this.skillDAO.query(params);
		if (skillList.size() > 0) {
			if (this.skillDAO.delete(params) == 0) {
				result = false;
				return result;
			}
		}
		if (this.skiTraDAO.deleteByPrimaryKey(sId) == 0) {
			Iterator<Skill> iterator = skillList.iterator();
			while (iterator.hasNext()) {
				this.skillDAO.insertSelective(iterator.next());
			}
			result = false;
		}
		return result;
	}

	@Override
	public boolean modifySkillTrain(SkiTraDTO skiTraDTO) {
		// TODO Auto-generated method stub
		boolean result = true;
		if (this.skiTraDAO.updateByPrimaryKeySelective(skiTraDTO.getMain()) == 0) {
			result = false;
			return result;
		}
		if (skiTraDTO.getList() != null) {
			Iterator<Skill> iterator = skiTraDTO.getList().iterator();
			while (iterator.hasNext()) {
				Skill skill = (Skill) iterator.next();
				if (skill.getId().equals(-1) ) {
					skill.setId(null);
					if (this.skillDAO.insertSelective(skill) == 0) {
						result = false;
					}
				}else{
					if (this.skillDAO.updateByPrimaryKeySelective(skill) == 0) {
						result = false;
					}
				}
			}
		}
		return result;
	}

	@Override
	public PageInfo<SkillTrain> getSkillTrainPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		this.startPage(params);
		Page<SkillTrain> skiTraPage = this.skiTraDAO.query(params);
		return new PageInfo<SkillTrain>(skiTraPage);
	}

	@Override
	public List<String> getAdmcodeByCity(String city) {
		// TODO Auto-generated method stub
		return this.skiTraDAO.selectAdmcodeByCity(city);
	}

	@Override
	public boolean deleteSkill(int sId) {
		// TODO Auto-generated method stub
		if (this.skillDAO.deleteByPrimaryKey(sId) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Skill> getSkillList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.skillDAO.query(params);
	}

}
