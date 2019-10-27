package com.jks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jks.entity.Schoolenterprise;

@Repository("schoolenterpriseDao")
public interface SchoolenterpriseMapper {
	
	List<Schoolenterprise> getSchoolenterpriseList(@Param("admcode")String admcode,@Param("year")String year);
	
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
     * @param city ,year
     * @return  
     */
	List<Schoolenterprise> findByCity(@Param("city")String city,@Param("year")String year);
	/**  
     *通过审核  
     * @param id 
     * @return  
     */ 
	boolean updateAudit(int id);

	Integer checkYear(Schoolenterprise schoolenterprise);

	List<Schoolenterprise> adminFindByCity(@Param("city")String city,@Param("year")String year);

	List<Schoolenterprise> getSchoolenterpriseListByAdmin(@Param("admcode")String admcode,@Param("year")String year);
}
