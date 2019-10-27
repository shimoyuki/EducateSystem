package com.jks.dao;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.jks.entity.Information;

public interface InformationMapper {
    
    int deleteByPrimaryKey(Integer id);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Integer id);
    
    List<String> selectAdmcodeByCity(String city);
    
    Page<Information> query(Map<String, Object> params);
  
    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);
}