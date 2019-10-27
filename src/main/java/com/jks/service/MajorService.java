package com.jks.service;

import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.jks.entity.Major;

public interface MajorService {
	/**
	 * 查询主键为majorcode的专业信息信息
	 * 
	 * @param majorcode
	 * @return
	 */
	public Major getMajorById(String majorcode);

	/**
	 * 添加专业信息信息
	 * 
	 * @param major
	 * @return
	 */
	public boolean addMajor(Major major);

	/**
	 * 删除专业信息信息
	 * 
	 * @param majorcode
	 * @return
	 */
	public boolean deleteMajor(String majorcode);

	/**
	 * 修改专业信息信息
	 * 
	 * @param major
	 * @return
	 */
	public boolean modifyMajor(Major major);

	/**
	 * 分页查询专业信息信息
	 * 
	* @param params 包含pageNum，pageSize，majorcode三个值，
	 * pageNum默认为1，查询首页，pageSize默认为12，每页12条数据，majorcode默认为空，为查询的条件
	 * @return
	 */
	public PageInfo<Major> getMajorPage(
			Map<String, Object> params);
	
	/**
	 * 通过专业名称查询其代码
	 * @param majorName
	 * @return
	 */
	public String getMajorCode(String majorName);

}
