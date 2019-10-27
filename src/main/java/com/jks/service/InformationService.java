package com.jks.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.jks.entity.Information;

public interface InformationService {
	
	/**
	 * 查询市州下属所有学校的admcode
	 * @param city
	 * @return
	 */
	public List<String> getAdmcodeByCity(String city);
	/**
	 * 分页查询信息
	 * @param params 包含pageNum，pageSize，year，admcode，city五个值，
	 * pageNum默认为1，查询首页，pageSize默认为12，每页12条数据，year，admcode，city默认为空，为查询的条件
	 * @return
	 */
	public PageInfo<Information> getInformationPage(Map<String, Object> params);
	/**
	 * 添加信息化
	 * @param teac
	 * @return
	 */
	public boolean addInformation(Information info);
	/**
	 * 查询主键为id的信息
	 * @param tId
	 * @return
	 */
	public Information getInformationById(int id);
	/**
	 * 修改信息
	 * @param teac
	 * @return
	 */
	public boolean modifyInfo(Information info);
	/**
	 * 删除信息
	 * @param tId
	 * @return
	 */
	public boolean deleteInfo(int id);
	
}
