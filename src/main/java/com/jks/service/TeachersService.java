package com.jks.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.jks.entity.Teachers;

public interface TeachersService {
	/**
	 * 查询主键为tId的教师队伍信息
	 * 
	 * @param tId
	 * @return
	 */
	public Teachers getTeachersById(int tId);

	@Deprecated
	/**
	 * 查询年份为year的教师队伍信息
	 * @param tId
	 * @return
	 */
	public List<Teachers> getTeachersByYear(String year);

	@Deprecated
	/**
	 * 查询教师队伍的列表信息
	 * @return
	 */
	public List<Teachers> getTeachersList();

	/**
	 * 添加教师队伍信息
	 * 
	 * @param teac
	 * @return
	 */
	public boolean addTeachers(Teachers teac);

	/**
	 * 删除教师队伍信息
	 * 
	 * @param tId
	 * @return
	 */
	public boolean deleteTeachers(int tId);

	/**
	 * 修改教师队伍信息
	 * 
	 * @param teac
	 * @return
	 */
	public boolean modifyTeachers(Teachers teac);

	/**
	 * 分页查询教师信息
	 * 
	 * @param params
	 *            包含pageNum，pageSize，year，admcode，city五个值，
	 *            pageNum默认为1，查询首页，pageSize默认为12
	 *            ，每页12条数据，year，admcode，city默认为空，为查询的条件
	 * @return
	 */
	public PageInfo<Teachers> getTeachersPage(Map<String, Object> params);

	/**
	 * 查询市州下属所有学校的admcode
	 * 
	 * @param city
	 * @return
	 */
	public List<String> getAdmcodeByCity(String city);
}
