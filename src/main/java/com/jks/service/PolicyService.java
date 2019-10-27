package com.jks.service;

import java.util.List;

import com.jks.entity.Policy;

public interface PolicyService {
	/**
	 * 获得政策列表
	 * @param funds
	 * @return
	 */
	List<Policy> getPolicyList(String admcode,String year);

	/**
	 * 新增政策
	 */
	boolean savePolicy(Policy policy);

	/**
	 * 删除政策
	 * @return
	 */
	boolean deletePolicy(int id);

	/**  
     * 根据 id 查询 对应政策
     */
	Policy findById(int id);	

	/**  
     * 根据 id 修改对应应政策
     */
	boolean updatePolicy(Policy policy);

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
	List<Policy> findByCity(String city, String year);

	Integer checkYear(Policy policy);

	

	

}
