package com.jks.service;

import java.util.List;

import com.jks.entity.Schoolenterprise;


public interface SchoolenterpriseService {

	List<Schoolenterprise> getSchoolenterpriseList(String admcode,String year);
	
	List<Schoolenterprise> getByUsercodeAndYear(String admcode,String year);
	/**
	 * 添加规模
	 * @param size
	 * @return
	 */
	void saveSchoolenterprise(Schoolenterprise schoolenterprise);
	
	/**
	 * 删除规模
	 * @param size
	 * @return
	 */
	boolean deleteSchoolenterprise(int id);
	
	/**  
     * 根据 id 查询 对应规模
     */ 
	Schoolenterprise findById(int id);
	
	/**  
     * 根据 id 修改对应规模
     */ 
	boolean updateSchoolenterprise(Schoolenterprise schoolenterprise);
	/**  
     *市州查询  
     * @param city,year
     * @return  
     */
	
	List<Schoolenterprise> findByCity(String city,String year);
	/**  
     *通过审核  
     * @param id 
     * @return  
     */  
	boolean updateAudit(int id);

	List<Schoolenterprise> getByAdmcode(String username, String year);

	Integer checkYear(Schoolenterprise schoolenterprise);

	List<Schoolenterprise> adminFindByCity(String city, String year);

	List<Schoolenterprise> getSchoolenterpriseListByAdmin(String admcode, String years);
}
