package com.jks.service;

import java.util.List;

import com.jks.entity.EducationTrain;

public interface EducationTrainService {	
	
	/**
	 * 获取教师培养培训列表
	 * @return
	 */
	List<EducationTrain> getEducationTrainList(String admcode,String year);
	
	/**
	 * 新增教师培养培训
	 */
	void saveEducationTrain(EducationTrain educationTrain);
	
	/**
	 * 删除教师培养培训
	 * @return
	 */
	boolean deleteEducationTrain(int id);

		
	/**  
     * 根据 id 查询 对应教师培养培训
     */ 
	EducationTrain findById(int id);

	
	/**  
     * 根据 id 修改对应教师培养培训
     */
	boolean updateEducationTrain(EducationTrain educationTrain);

	/**  
     *通过审核  
     * @param id 
     * @return  
     */ 
	boolean updateAudit(int id);

	/**  
     *市州查询  
     * @param city,year
     * @return  
     */
	List<EducationTrain> findByCity(String city, String year);

	Integer checkYear(EducationTrain educationTrain);
}
