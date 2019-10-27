package com.jks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jks.entity.Funds;

@Repository("fundsDao")
public interface FundsDao {
	/**
	 * 获得经费列表
	 * @param funds
	 * @return
	 */
	List<Funds> getFundsList(@Param("admcode")String admcode,@Param("year")String year);

	/**
	 * 添加经费
	 * @param funds
	 */
	boolean saveFunds(Funds funds);

	/**
	 * 删除经费
	 * @param funds
	 * @return
	 */
	boolean deleteFunds(int id);

	/**  
     * 根据 id 查询 对应经费
     */ 
	Funds findById(int id);

	/**  
     * 根据 id 修改经费
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
	List<Funds> findByCity(@Param("city")String city,@Param("year")String year);

	Integer checkYear(Funds fundsObj);

}
