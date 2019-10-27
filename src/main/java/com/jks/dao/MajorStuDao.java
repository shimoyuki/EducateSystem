package com.jks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jks.entity.MajorStu;

@Repository("majorStuDao")
public interface MajorStuDao {
	/**
	 * 获得专业人数列表
	 * @param majorLayou
	 * @return
	 */
	List<MajorStu> getMajorStuList(int id);

	/**
	 * 新增专业人数
	 */
	boolean saveMajorStu(MajorStu majorStu);

	/**
	 * 删除专业人数
	 * @return
	 */
	boolean deleteMajorStu(@Param("admcode")String admcode, @Param("year")String year);

	/**
	 * 修改专业人数
	 * @return
	 */
	boolean updateMajorStu(MajorStu majorStu);

	/**  
     * 根据 id 删除对应应专业人数
     */ 
	void deleteMajorStuTable(int ids);

	 /**  
     *通过审核  
     * @param id 
     * @return  
     */  
	boolean updateAudit(int id);

	

}
