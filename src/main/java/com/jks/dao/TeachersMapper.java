package com.jks.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.jks.entity.Teachers;

@Repository
public interface TeachersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teachers record);

    int insertSelective(Teachers record);

    Teachers selectByPrimaryKey(Integer id);

    List<Teachers> selectByYear(String year);
    
    List<Teachers> selectAll();

    int updateByPrimaryKeySelective(Teachers record);

    int updateByPrimaryKey(Teachers record);
    
    Page<Teachers> query(Map<String, Object> params);
    
    List<String> selectAdmcodeByCity(String city);
}