package com.jks.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jks.entity.Internship;


@Service
@Transactional 
public interface InternshipService {

	
	/**
	 * 获得规模列表
	 * @param size
	 * @return
	 */
	List<Internship> getInternshipList(String admcode,String year);
	
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
     * @param city,year
     * @return  
     */
	
	List<Internship> findByCity(String city,String year);
	/**  
     *通过审核  
     * @param id 
     * @return  
     */  
	boolean updateAudit(int id);

	Integer checkYear(Internship internship);

	List<Internship> adminFindByCity(String city, String years);

	List<Internship> getInternshipListByAdmin(String admcode, String years);
}
