package com.jks.dao;

import com.jks.entity.SocialService;

public interface SocialServiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SocialService record);

    int insertSelective(SocialService record);

    SocialService selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SocialService record);

    int updateByPrimaryKey(SocialService record);
}