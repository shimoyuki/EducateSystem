package com.jks.service;

import java.util.List;

import com.jks.entity.Size;

public interface SizeService {	
	
	/**
	 * 获取规模列表
	 * @return
	 */
	List<Size> getSizeList(String admcode,String year);
	
	
	/**
	 * 新增规模
	 * @return
	 */
	void saveSize(Size size);
	
	/**
	 * 删除规模
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
     * @param city,year
     * @return  
     */
	List<Size> findByCity(String city,String year);

	Integer checkYear(Size size);

	Integer checkMajor(String admcode, String year);
}
