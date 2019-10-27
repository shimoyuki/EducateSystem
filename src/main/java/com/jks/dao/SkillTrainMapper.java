package com.jks.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.jks.entity.SkillTrain;

@Repository
public interface SkillTrainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SkillTrain record);

    int insertSelective(SkillTrain record);

    SkillTrain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SkillTrain record);

    int updateByPrimaryKey(SkillTrain record);
    
    Page<SkillTrain> query(Map<String, Object> params);
    
    List<String> selectAdmcodeByCity(String city);
}