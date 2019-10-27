package com.jks.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.jks.entity.Experience;

@Repository
public interface ExperienceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Experience record);

    int insertSelective(Experience record);

    Experience selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Experience record);

    int updateByPrimaryKey(Experience record);
    
    Page<Experience> query(Map<String, Object> params);
    
    List<String> selectAdmcodeByCity(String city);
}