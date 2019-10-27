package com.jks.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.jks.entity.EmployQuality;

@Repository
public interface EmployQualityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployQuality record);

    int insertSelective(EmployQuality record);

    EmployQuality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EmployQuality record);

    int updateByPrimaryKey(EmployQuality record);
    
    Page<EmployQuality> query(Map<String, Object> params);
    
    List<String> selectAdmcodeByCity(String city);
}