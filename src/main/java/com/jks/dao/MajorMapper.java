package com.jks.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.jks.entity.Major;

@Repository
public interface MajorMapper {
    int deleteByPrimaryKey(String majorcode);

    int insert(Major record);

    int insertSelective(Major record);

    Major selectByPrimaryKey(String majorcode);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);
    
    Page<Major> query(Map<String, Object> params);
    
    String selectCodeByName(String name);
}