package com.jks.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.jks.entity.SocialService;

@Repository
public interface SocialServiceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SocialService record);

    int insertSelective(SocialService record);

    SocialService selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SocialService record);

    int updateByPrimaryKey(SocialService record);
    
    Page<SocialService> query(Map<String, Object> params);
    
    List<String> selectAdmcodeByCity(String city);
}