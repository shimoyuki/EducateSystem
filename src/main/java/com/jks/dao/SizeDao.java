package com.jks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jks.entity.Size;

@Repository("sizeDao")
public interface SizeDao {
	
	/**
	 * 获得规模列表
	 * @param size
	 * @return
	 */
	List<Size> getSizeList(@Param("admcode")String admcode,@Param("year")String year);
	
	/**
	 * 添加规模
	 * @param size
	 * @return
	 */
	void saveSize(Size size);
	
	/**
	 * 删除规模
	 * @param size
	 * @return
	 */
	boolean deleteSize(int id);
	
	/**  
     * 根据 id 查询 对应规模
     */ 
	Size findById(int id);
	
	/**  
     * 根据 id 修改对应规模
     */ 
	boolean updateSize(Size size);
	
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
	List<Size> findByCity(@Param("city")String city,@Param("year")String year);
	
	Integer checkYear(Size size);

	Integer checkMajor(@Param("admcode")String admcode,@Param("year")String year);
}
