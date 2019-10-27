package com.jks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jks.entity.WriteSituation;

@Repository("writeSituationDao")
public interface WriteSituationDao {
	List<WriteSituation> getWriteSituation(@Param("year")String year, @Param("school")String school);
	List<WriteSituation> getWriteSituationNull(String school);
}
