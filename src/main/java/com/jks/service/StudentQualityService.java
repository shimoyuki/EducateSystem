package com.jks.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.jks.entity.StudentQuality;

public interface StudentQualityService {
	/**
	 * 查询主键为sId的学生质量信息
	 * 
	 * @param sId
	 * @return
	 */
	public StudentQuality getStudentQualityById(int sId);

	/**
	 * 添加学生质量信息
	 * 
	 * @param stud
	 * @return
	 */
	public boolean addStudentQuality(StudentQuality stud);

	/**
	 * 删除学生质量信息
	 * 
	 * @param sId
	 * @return
	 */
	public boolean deleteStudentQuality(int sId);

	/**
	 * 修改学生质量信息
	 * 
	 * @param stud
	 * @return
	 */
	public boolean modifyStudentQuality(StudentQuality stud);

	/**
	 * 分页查询学生质量信息
	 * 
	 * @param params
	 *            包含pageNum，pageSize，year，admcode，city五个值，
	 *            pageNum默认为1，查询首页，pageSize默认为12
	 *            ，每页12条数据，year，admcode，city默认为空，为查询的条件
	 * @return
	 */
	public PageInfo<StudentQuality> getStudentQualityPage(
			Map<String, Object> params);

	/**
	 * 查询市州下属所有学校的admcode
	 * 
	 * @param city
	 * @return
	 */
	public List<String> getAdmcodeByCity(String city);
}
