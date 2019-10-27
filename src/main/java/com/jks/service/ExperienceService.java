package com.jks.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.jks.entity.Experience;

public interface ExperienceService {
	/**
	 * 查询主键为eId的在校体验信息
	 * 
	 * @param eId
	 * @return
	 */
	public Experience getExperienceById(int eId);

	/**
	 * 添加在校体验信息
	 * 
	 * @param exp
	 * @return
	 */
	public boolean addExperience(Experience exp);

	/**
	 * 删除在校体验信息
	 * 
	 * @param eId
	 * @return
	 */
	public boolean deleteExperience(int eId);

	/**
	 * 修改在校体验信息
	 * 
	 * @param exp
	 * @return
	 */
	public boolean modifyExperience(Experience exp);

	/**
	 * 分页查询在校体验信息
	 * 
	 * @param params
	 *            包含pageNum，pageSize，year，admcode，city五个值，
	 *            pageNum默认为1，查询首页，pageSize默认为12
	 *            ，每页12条数据，year，admcode，city默认为空，为查询的条件
	 * @return
	 */
	public PageInfo<Experience> getExperiencePage(Map<String, Object> params);

	/**
	 * 查询市州下属所有学校的admcode
	 * 
	 * @param city
	 * @return
	 */
	public List<String> getAdmcodeByCity(String city);
}
