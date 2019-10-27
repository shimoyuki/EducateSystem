package com.jks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jks.entity.Policy;

@Repository("policyDao")
public interface PolicyDao {
	/**
	 * 获得政策列表
	 * @param policy
	 * @return
	 */
	List<Policy> getPolicysList(@Param("admcode")String admcode,@Param("year")String year);

	/**
	 * 添加政策
	 * @param policy
	 * @return 
	 */
	boolean savePolicy(Policy policy);

	/**
	 * 删除政策
	 * @param policy
	 * @return
	 */
	boolean deletePolicy(int id);

	/**  
     * 根据 id 查询 对应政策
     */
	Policy findById(int id);

	/**  
     * 根据 id 修改政策
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
	List<Policy> findByCity(@Param("city")String city,@Param("year")String year);

	Integer checkYear(Policy policy);	

}
