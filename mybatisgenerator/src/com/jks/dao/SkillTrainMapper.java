package com.jks.dao;

import com.jks.entity.SkillTrain;

public interface SkillTrainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SkillTrain record);

    int insertSelective(SkillTrain record);

    SkillTrain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SkillTrain record);

    int updateByPrimaryKey(SkillTrain record);
}