package com.jks.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.jks.entity.StudentQuality;

@Repository
public interface StudentQualityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StudentQuality record);

    int insertSelective(StudentQuality record);

    StudentQuality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentQuality record);

    int updateByPrimaryKey(StudentQuality record);
    
    Page<StudentQuality> query(Map<String, Object> params);
    
    List<String> selectAdmcodeByCity(String city);
}