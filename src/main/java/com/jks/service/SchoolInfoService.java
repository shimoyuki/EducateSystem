package com.jks.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.jks.entity.SchoolDTO;
import com.jks.entity.SchoolInfo;
import com.jks.entity.MajorSchool;

public interface SchoolInfoService {
	/**
	 * 查询主键为admcode的学校信息
	 * 
	 * @param admcode
	 * @return
	 */
	public SchoolDTO getSchoolInfoById(String admcode);

	/**
	 * 添加学校信息
	 * 
	 * @param schoolDTO
	 * @return
	 */
	public boolean addSchoolInfo(SchoolDTO schoolDTO);

	/**
	 * 删除学校信息
	 * 
	 * @param admcode
	 * @return
	 */
	public boolean deleteSchoolInfo(String admcode);

	/**
	 * 修改学校信息
	 * 
	 * @param school
	 * @return
	 */
	public boolean modifySchoolInfo(SchoolDTO schoolDTO);

	/**
	 * 分页查询学校信息
	 * 
	 * @param params
	 *            包含pageNum，pageSize，admcode三个值，
	 *            pageNum默认为1，查询首页，pageSize默认为12
	 *            ，每页12条数据，admcode默认为空，为查询的条件
	 * @return
	 */
	public PageInfo<SchoolInfo> getSchoolInfoPage(Map<String, Object> params);

	/**
	 * 删除学校专业信息
	 * 
	 * @param mId
	 * @return
	 */
	public boolean deleteMajorSchool(int mId);

	/**
	 * 查询学校专业信息
	 * 
	 * @param params
	 * @return
	 */
	public List<MajorSchool> getMajorSchoolList(Map<String, Object> params);
}
