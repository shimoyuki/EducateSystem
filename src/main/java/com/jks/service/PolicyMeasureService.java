package com.jks.service;

import java.util.List;

import com.jks.entity.PolicyMeasure;

public interface PolicyMeasureService {
	/**
	 * 获得政策措施列表
	 * @param projectInput
	 * @return
	 */
	List<PolicyMeasure> getPolicyMeasureList(int id);
	
	/**
	 * 新增政策措施
	 */
	boolean savePolicyMeasure(PolicyMeasure policyMeasure);	
	
	/**
	 * 删除政策措施
	 * @return
	 */
	boolean deletePolicyMeasure(String admcode, String year);

	/**  
     * 根据 id 修改对应应政策措施
     */
	boolean updateProjectInput(PolicyMeasure policyMeasure);

	/**  
     * 根据 id 删除对应应政策措施
     */
	void deletePolicyTable(int ids);

	/**  
     *通过审核  
     * @param id 
     * @return  
     */
	boolean updateAudit(int id);
	
}
