package com.jks.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.jks.entity.SkiTraDTO;
import com.jks.entity.Skill;
import com.jks.entity.SkillTrain;

public interface SkillTrainService {
	/**
	 * 查询主键为sId的技术培养信息
	 * 
	 * @param sId
	 * @return
	 */
	public SkiTraDTO getSkillTrainById(int sId);

	/**
	 * 添加技术培养信息
	 * 
	 * @param skiTraDTO
	 * @return
	 */
	public boolean addSkillTrain(SkiTraDTO skiTraDTO);

	/**
	 * 删除技术培养信息
	 * 
	 * @param sId
	 * @return
	 */
	public boolean deleteSkillTrain(int sId);

	/**
	 * 修改技术培养信息
	 * 
	 * @param skiTra
	 * @return
	 */
	public boolean modifySkillTrain(SkiTraDTO skiTraDTO);

	/**
	 * 分页查询技术培养信息
	 * 
	 * @param params
	 *            包含pageNum，pageSize，year，admcode，city五个值，
	 *            pageNum默认为1，查询首页，pageSize默认为12
	 *            ，每页12条数据，year，admcode，city默认为空，为查询的条件
	 * @return
	 */
	public PageInfo<SkillTrain> getSkillTrainPage(Map<String, Object> params);

	/**
	 * 查询市州下属所有学校的admcode
	 * 
	 * @param city
	 * @return
	 */
	public List<String> getAdmcodeByCity(String city);

	/**
	 * 删除扶贫项目信息
	 * 
	 * @param sId
	 * @return
	 */
	public boolean deleteSkill(int sId);

	/**
	 * 查询技术名称信息
	 * 
	 * @param params
	 * @return
	 */
	public List<Skill> getSkillList(Map<String, Object> params);
}
