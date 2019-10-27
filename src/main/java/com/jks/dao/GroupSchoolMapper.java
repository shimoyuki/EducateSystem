package com.jks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jks.entity.Groupschool;


@Repository("groupSchoolDao")
public interface GroupSchoolMapper {
	/**
	 * 获得规模列表
	 * @param size
	 * @return
	 */
	List<Groupschool> getGroupschoolList(@Param("admcode")String admcode,@Param("year")String year);
	
	List<Groupschool> getByUsercodeAndYear(String admcode,String year);
	/**
	 * 添加规模
	 * @param size
	 * @return
	 */
	void saveGroupschool(Groupschool groupschool);
	
	/**
	 * 删除规模
	 * @param size
	 * @return
	 */
	boolean deleteGroupschool(int id);
	
	/**  
     * 根据 id 查询 对应规模
     */ 
	Groupschool findById(int id);
	
	/**  
     * 根据 id 修改对应规模
     */ 
	boolean updateGroupschool(Groupschool groupschool);
	/**  
     *市州查询  
     * @param city ,year
     * @return  
     */
	List<Groupschool> findByCity(@Param("city")String city,@Param("year")String year);
	/**  
     *通过审核  
     * @param id 
     * @return  
     */ 
	boolean updateAudit(int id);

	Integer checkYear(Groupschool groupschool);

	List<Groupschool> adminFindByCity(@Param("city")String city,@Param("year")String year);

	List<Groupschool> getGroupschoolListByAdmin(@Param("admcode")String admcode,@Param("year")String year);
}
