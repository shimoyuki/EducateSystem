package com.jks.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;
import com.jks.entity.SchoolInfo;

@Repository
public interface SchoolInfoMapper {
   
    int deleteByPrimaryKey(String admcode);

   
    int insert(SchoolInfo record);

  
    int insertSelective(SchoolInfo record);

   
    SchoolInfo selectByPrimaryKey(String admcode);

   
    int updateByPrimaryKeySelective(SchoolInfo record);

    
    int updateByPrimaryKey(SchoolInfo record);
    
    Page<SchoolInfo> query(Map<String, Object> params);
    
    String selectNameByCode(String admcode);
    
    String selectCodeByName(@Param("schoolname")String schoolname);
}