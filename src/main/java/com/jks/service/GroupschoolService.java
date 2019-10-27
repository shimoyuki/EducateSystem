package com.jks.service;

import java.util.List;

import com.jks.entity.Groupschool;


public interface GroupschoolService {
	
	List<Groupschool> getGroupschoolList(String admcode,String year);
	
	
	/**
	 * 新增规模
	 * @return
	 */
	void saveGroupschool(Groupschool groupschool);
	
	/**
	 * 删除规模
	 * @return
	 */
	boolean deleteGroupschool(int id);
	
	/**  
     * 根据 id 查询 对应规模
     */  
	Groupschool findById(int id);
	
	
	/**  
     * 根据 id 修改对应规模
     */  
	boolean updateGroupschool(Groupschool groupschool);
	
	List<Groupschool> getByAdmcode(String username,String year);

	/**  
     *市州查询  
     * @param city,year
     * @return  
     */
	
	List<Groupschool> findByCity(String city,String year);
	/**  
     *通过审核  
     * @param id 
     * @return  
     */  
	boolean updateAudit(int id);


	Integer checkYear(Groupschool groupschool);


	List<Groupschool> adminFindByCity(String city, String years);


	List<Groupschool> getGroupschoolListByAdmin(String admcode, String years);
}
