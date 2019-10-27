package com.jks.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.jks.entity.CounpaSupp;

@Repository
public interface CounpaSuppMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CounpaSupp record);

    int insertSelective(CounpaSupp record);

    CounpaSupp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CounpaSupp record);

    int updateByPrimaryKey(CounpaSupp record);
    
    Page<CounpaSupp> query(Map<String, Object> params);
    
    List<String> selectAdmcodeByCity(String city);
    
    List<String> selectYear(String city);
}