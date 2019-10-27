package com.jks.service;

import java.util.List;

import com.jks.entity.Funds;

public interface FundsService {
	/**
	 * 获得经费列表
	 * @param funds
	 * @return
	 */
	List<Funds> getFundsList(String admcode,String year);
	
	/**
	 * 新增经费
	 */
	boolean saveFunds(Funds funds);
	
	/**
	 * 删除经费
	 * @return
	 */
	boolean deleteFunds(int id);

	/**  
     * 根据 id 查询 对应经费
     */
	Funds findById(int id);

	/**  
     * 根据 id 修改对应应经费
     */
	boolean updateFunds(Funds funds);

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
	List<Funds> findByCity(String city, String year);

	Integer checkYear(Funds fundsObj);

	

}
