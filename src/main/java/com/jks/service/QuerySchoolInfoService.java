package com.jks.service;

import java.util.List;

import com.jks.entity.SchoolInfo;

public interface QuerySchoolInfoService {	
	
	 /**  
     * 查找学校名称  
     * @param response  
     */  
	List<SchoolInfo> findByArea(String area);

}
