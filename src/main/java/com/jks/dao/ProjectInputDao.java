package com.jks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jks.entity.ProjectInput;

@Repository("projectInputDao")
public interface ProjectInputDao {
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
	boolean deleteProjectInput(@Param("admcode")String admcode,@Param("year") String year);
	
	/**
	 * 修改项目投入
	 * @return
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
