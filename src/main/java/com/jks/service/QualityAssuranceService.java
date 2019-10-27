package com.jks.service;

import java.util.List;

import com.jks.entity.QualityAssurance;

public interface QualityAssuranceService {
	
	/**
	 * 获取质量保证列表
	 * @return
	 */
	List<QualityAssurance> getQualityAssuranceList(String admcode,String year);
	
	/**
	 * 新增质量保证
	 */
	void saveQualityAssurance(QualityAssurance qualityAssurance);

	/**
	 * 删除质量保证
	 * @return
	 */
	boolean deleteQualityAssurance(int id);

	/**  
     * 根据 id 查询 对应质量保证
     */ 
	QualityAssurance findById(int id);

	/**
	 * 根据 id 修改对应修改质量保证
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
	List<QualityAssurance> findByCity(String city, String year);

	Integer checkYear(QualityAssurance qualityAssurance);

}
