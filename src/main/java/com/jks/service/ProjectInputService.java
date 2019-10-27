package com.jks.service;

import java.util.List;

import com.jks.entity.ProjectInput;

public interface ProjectInputService {
	/**
	 * 获得项目投入列表
	 * @param projectInput
	 * @return
	 */
	List<ProjectInput> getProjectInputList(int id);
	
	/**
	 * 新增项目投入
	 */
	boolean saveProjectInput(ProjectInput projectInput);
	
	/**
	 * 删除项目投入
	 * @return
	 */
	boolean deleteProjectInput(String admcode, String year);
	
	/**  
     * 根据 id 修改对应应项目投入
     */ 
	boolean updateProjectInput(ProjectInput projectInput);

	

	/**  
     * 根据 id 删除对应应项目投入
     */ 
	void deleteFundsTable(int ids);

	/**  
     *通过审核  
     * @param id 
     * @return  
     */ 
	boolean updateAudit(int id);
	

}
