package com.jks.service;

import java.util.List;

import com.jks.entity.MajorStu;

public interface MajorStuService {
	/**
	 * 获得专业人数列表
	 * @param majorStu
	 * @return
	 */
	List<MajorStu> getMajorStuList(int id);
	
	/**
	 * 新增专业人数
	 */
	boolean saveMajorStu(MajorStu majorStu);	
	
	/**
	 * 删除专业人数
	 * @return
	 */
	boolean deleteMajorStu(String admcode, String year);
	
	/**  
     * 根据 id 修改对应应专业人数
     */  
	boolean updateMajorStu(MajorStu majorStu);

	/**  
     * 根据 id 删除对应应专业人数
     */ 
	void deleteMajorStuTable(int ids);

	 /**  
     *通过审核  
     * @param id 
     * @return  
     */  
	boolean updateAudit(int id);

}
