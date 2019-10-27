package com.jks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jks.entity.EducationTrain;

@Repository("educationTrainDao")
public interface EducationTrainDao {
	
	/**
	 * 获得教师培养培训列表
	 * @param size
	 * @return
	 */
	List<EducationTrain> getEducationTrainList(@Param("admcode")String admcode,@Param("year")String year);

	/**
	 * 添加教师培养培训
	 * @param size
	 */
	void saveEducationTrain(EducationTrain educationTrain);

	/**
	 * 删除教师培养培训
	 * @param size
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
	List<EducationTrain> findByCity(@Param("city")String city,@Param("year")String year);

	Integer checkYear(EducationTrain educationTrain);

	
}
