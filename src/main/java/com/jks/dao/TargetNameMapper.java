package com.jks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jks.entity.TargetName;

public interface TargetNameMapper {
	int deleteByPrimaryKey(Integer id);

    int insert(TargetName record);

    int insertSelective(TargetName record);

    TargetName selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TargetName record);

    int updateByPrimaryKey(TargetName record);
    
    List<TargetName> selectBySource(String source);
    
    String selectNameByField(@Param("field")String field, @Param("source")String source);
    
    String selectFieldByName(@Param("name")String name, @Param("source")String source);
    
    String selectMeasureByName(@Param("name")String name, @Param("source")String source);
}