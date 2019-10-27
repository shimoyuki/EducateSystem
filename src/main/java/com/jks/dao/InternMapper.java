package com.jks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jks.entity.Internship;


@Repository("internshipDao")
public interface InternMapper {
	/**
	 * 获得规模列表
	 * @param size
	 * @return
	 */
	List<Internship> getInternshipList(@Param("admcode")String admcode,@Param("year")String year);
	
	List<Internship> getByUsercodeAndYear(String admcode,String year);
	/**
	 * 添加规模
	 * @param size
	 * @return
	 */
	void saveInternship(Internship internship);
	
	/**
	 * 删除规模
	 * @param size
	 * @return
	 */
	boolean deleteInternship(int id);
	
	/**  
     * 根据 id 查询 对应规模
     */ 
	Internship findById(int id);
	
	/**  
     * 根据 id 修改对应规模
     */ 
	boolean updateInternship(Internship internship);
	/**  
     *市州查询  
     * @param city ,year
     * @return  
     */
	List<Internship> findByCity(@Param("city")String city,@Param("year")String year);
	/**  
     *通过审核  
     * @param id 
     * @return  
     */ 
	boolean updateAudit(int id);

	Integer checkYear(Internship internship);

	List<Internship> adminFindByCity(@Param("city")String city,@Param("year")String year);

	List<Internship> getInternshipListByAdmin(@Param("admcode")String admcode,@Param("year")String year);
}
