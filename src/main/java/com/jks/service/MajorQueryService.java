package com.jks.service;

import java.util.List;

import com.jks.entity.Major;

public interface MajorQueryService {
	/**
	 * 获得专业类列表
	 * @param major
	 * @return
	 */
	List<Major> getMajorQueryList();
	
	/**  
     * 根据专业类查询对应专业名称
     */
	List<Major> findByInduName(String induName);

}
