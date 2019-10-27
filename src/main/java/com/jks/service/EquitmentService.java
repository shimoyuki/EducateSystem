package com.jks.service;

import java.util.List;

import com.jks.entity.Equitment;

public interface EquitmentService {

	List<Equitment> getEquitmentList(String admcode,String year);
	
	
	/**
	 * 新增规模
	 * @return
	 */
	void saveEquitment(Equitment equitment);
	
	/**
	 * 删除规模
	 * @return
	 */
	boolean deleteEquitment(int id);
	
	/**  
     * 根据 id 查询 对应规模
     */  
	Equitment findById(int id); 
	
	/**  
     * 根据 id 修改对应规模
     */  
	boolean updateEquitment(Equitment equitment);
	
	List<Equitment> getByAdmcode(String username,String year);
	
	boolean updateAudit(int id);
	
	List<Equitment> findByCity(String city,String year);


	Integer checkYear(Equitment equitment);


	List<Equitment> adminFindByCity(String city, String year);


	List<Equitment> getEquitmentListByAdmin(String admcode, String year);
}
