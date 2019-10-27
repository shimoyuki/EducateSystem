package com.jks.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.jks.entity.CounDTO;
import com.jks.entity.CounpaSupp;
import com.jks.entity.Poor;

public interface CounpaSuppService {
	/**
	 * 查询主键为cId的对口支援信息
	 * 
	 * @param cId
	 * @return
	 */
	public CounDTO getCounpaSuppById(int cId);

	/**
	 * 添加对口支援信息
	 * 
	 * @param counDTO
	 * @return
	 */
	public boolean addCounpaSupp(CounDTO counDTO);

	/**
	 * 删除对口支援信息
	 * 
	 * @param cId
	 * @return
	 */
	public boolean deleteCounpaSupp(int cId);

	/**
	 * 修改对口支援信息
	 * 
	 * @param coun
	 * @return
	 */
	public boolean modifyCounpaSupp(CounDTO counDTO);

	/**
	 * 分页查询对口支援信息
	 * 
	 * @param params
	 *            包含pageNum，pageSize，year，admcode，city五个值，
	 *            pageNum默认为1，查询首页，pageSize默认为12
	 *            ，每页12条数据，year，admcode，city默认为空，为查询的条件
	 * @return
	 */
	public PageInfo<CounpaSupp> getCounpaSuppPage(Map<String, Object> params);

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
	 * @param pId
	 * @return
	 */
	public boolean deletePoor(int pId);

	/**
	 * 查询扶贫项目信息
	 * 
	 * @param params
	 * @return
	 */
	public List<Poor> getPoorList(Map<String, Object> params);
}
