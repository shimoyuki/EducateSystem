package com.jks.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jks.entity.Poor;

@Repository
public interface PoorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Poor record);

    int insertSelective(Poor record);

    Poor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Poor record);

    int updateByPrimaryKey(Poor record);

    List<Poor> query(Map<String, Object> params);
    
    int delete(Map<String, Object> params);
}