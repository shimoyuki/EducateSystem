package com.jks.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jks.entity.Major;

@Repository("majorQueryDao")
public interface MajorQueryDao {
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
