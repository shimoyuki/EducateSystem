package com.jks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jks.entity.Equitment;

@Repository("equitmentDao")
public interface EquitmentDao {
	
	List<Equitment> getEquitmentList(@Param("admcode")String admcode,@Param("year")String year);
	
	List<Equitment> getEquitmentListByAdmin(@Param("admcode")String admcode,@Param("year")String year);
	
	List<Equitment> getByUsercodeAndYear(String admcode,String year);
	
	void saveEquitment(Equitment equitment);
	
	boolean deleteEquitment(int id);
	
	Equitment findById(int id);
	
	boolean updateEquitment(Equitment equitment);
	
	boolean updateAudit(int id);
	
	List<Equitment> findByCity(@Param("city")String city,@Param("year")String year);
	
	List<Equitment> adminFindByCity(@Param("city")String city,@Param("year")String year);

	Integer checkYear(Equitment equitment);
	
	
}
