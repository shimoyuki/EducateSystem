package com.jks.dao;

import java.util.List;
import java.util.Map;

import com.jks.entity.MajorSchool;

public interface MajorSchoolMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MajorSchool record);

    int insertSelective(MajorSchool record);

    MajorSchool selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MajorSchool record);

    int updateByPrimaryKey(MajorSchool record);
    
    List<MajorSchool> query(Map<String, Object> params);
    
    int delete(Map<String, Object> params);
}