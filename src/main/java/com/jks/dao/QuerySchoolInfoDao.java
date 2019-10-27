package com.jks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jks.entity.SchoolInfo;

@Repository("querySchoolInfoDao")
public interface QuerySchoolInfoDao {
	/**  
     * 查找学校名称  
     * @param response  
     */ 
	List<SchoolInfo> findByArea(@Param("area")String area);
}
