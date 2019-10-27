package com.jks.service;

import java.util.List;

import com.jks.entity.MajorLayout;

public interface MajorLayoutService {
	/**
	 * 获得专业布局列表
	 * @param majorLayou
	 * @return
	 */
	List<MajorLayout> getMajorLayoutList(String admcode,String year);

	/**
	 * 新增专业布局
	 */
	boolean saveMajorLayout(MajorLayout majorLayout);
	
	/**
	 * 删除专业布局
	 * @return
	 */
	boolean deleteMajorLayout(int id);

	/**  
     * 根据id查询单个专业布局 
     * @param id  
     * @return  
     */  
	MajorLayout findById(int id);

	/**  
     * 根据id修改单个专业布局 
     * @param id  
     * @return  
     */ 
	boolean updateMajorLayout(MajorLayout majorLayout);

	/**  
     *通过审核  
     * @param id 
     * @return  
     */
	boolean updateAudit(int id);

	/**  
     *市州查询  
     * @param city ,year
     * @return  
     */
	List<MajorLayout> findByCity(String city, String year);

	Integer checkYear(MajorLayout majorLayout);

}
