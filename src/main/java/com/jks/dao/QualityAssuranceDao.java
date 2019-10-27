package com.jks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jks.entity.QualityAssurance;

public interface QualityAssuranceDao {
	
	/**
	 * 获得质量保证列表
	 * @param qualityAssurance
	 * @return
	 */
	List<QualityAssurance> getQualityAssuranceList(@Param("admcode")String admcode,@Param("year")String year);

	/**
	 * 添加质量保证
	 * @param qualityAssuranceDao
	 */
	void saveQualityAssurance(QualityAssurance qualityAssurance);

	/**
	 * 删除质量保证
	 * @param qualityAssuranceDao
	 * @return
	 */
	boolean deleteQualityAssurance(int id);
	
	
	/**  
     * 根据 id 查询 对应质量保证
     */ 
	QualityAssurance findById(int id);

	/**  
     * 根据 id 修改 对应质量保证
     */ 
	boolean updateQualityAssurance(QualityAssurance qualityAssurance);

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
	List<QualityAssurance> findByCity(@Param("city")String city,@Param("year")String year);

	Integer checkYear(QualityAssurance qualityAssurance);
}
