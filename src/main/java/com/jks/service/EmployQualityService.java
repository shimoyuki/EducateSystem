package com.jks.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.jks.entity.EmployQuality;

public interface EmployQualityService {
	/**
	 * 查询主键为eId的就业质量信息
	 * 
	 * @param eId
	 * @return
	 */
	public EmployQuality getEmployQualityById(int eId);

	/**
	 * 添加就业质量信息
	 * 
	 * @param emp
	 * @return
	 */
	public boolean addEmployQuality(EmployQuality emp);

	/**
	 * 删除就业质量信息
	 * 
	 * @param eId
	 * @return
	 */
	public boolean deleteEmployQuality(int eId);

	/**
	 * 修改就业质量信息
	 * 
	 * @param emp
	 * @return
	 */
	public boolean modifyEmployQuality(EmployQuality emp);

	/**
	 * 分页查询就业质量信息
	 * 
	 * @param params
	 *            包含pageNum，pageSize，year，admcode，city五个值，
	 *            pageNum默认为1，查询首页，pageSize默认为12
	 *            ，每页12条数据，year，admcode，city默认为空，为查询的条件
	 * @return
	 */
	public PageInfo<EmployQuality> getEmployQualityPage(
			Map<String, Object> params);

	/**
	 * 查询市州下属所有学校的admcode
	 * 
	 * @param city
	 * @return
	 */
	public List<String> getAdmcodeByCity(String city);
}
