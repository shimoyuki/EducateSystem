package com.jks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jks.entity.MajorNum;

@Repository("majorNumDao")
public interface MajorNumDao {
	/**
	 * 获得课程开设列表
	 * @param majorNum
	 * @return
	 */
	List<MajorNum> getMajorNumList(@Param("admcode")String admcode,@Param("year")String year);
	
	/**
	 * 添加课程开设
	 * @param majorNum
	 */
	void saveMajorNum(MajorNum majorNum);
    
	/**
	 * 删除课程开设
	 * @param majorNum
	 * @return
	 */
	boolean deleteMajorNum(int id);

	/**  
     * 根据 id 查询 对应课程开设
     */ 
	MajorNum findById(int id);

	/**  
     * 根据 id 修改课程开设
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
	List<MajorNum> findByCity(@Param("city")String city,@Param("year")String year);

	Integer checkYear(MajorNum majorNum);
	

}
