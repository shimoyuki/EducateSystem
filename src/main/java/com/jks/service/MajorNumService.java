package com.jks.service;

import java.util.List;

import com.jks.entity.MajorNum;

public interface MajorNumService {
	/**
	 * 获得课程开设列表
	 * @param majorNum
	 * @return
	 */
	List<MajorNum> getMajorNumList(String admcode,String year);
	
	/**
	 * 新增课程开设
	 */
	void saveMajorNum(MajorNum majorNum);
	
	/**
	 * 删除课程开设
	 * @return
	 */
	boolean deleteMajorNum(int id);

	/**  
     * 根据 id 查询 对应课程开设
     */
	MajorNum findById(int id);

	/**  
     * 根据 id 修改对应应课程开设
     */  
	boolean updateMajorNum(MajorNum majorNum);

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
	List<MajorNum> findByCity(String city, String year);

	Integer checkYear(MajorNum majorNum);

}
