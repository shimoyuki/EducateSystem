package com.jks.dao;

import com.jks.entity.Informant;

public interface InformantMapper {
   
    int deleteByPrimaryKey(Integer id);
   
    int insert(Informant record);
   
    int insertSelective(Informant record);
   
    Informant selectByPrimaryKey(Integer id);
  
    int updateByPrimaryKeySelective(Informant record);

    int updateByPrimaryKey(Informant record);
    
    int selectCountByUser(String usercode);
    
    int selectSumUser();
    
    int selectLoginCount();
    
    Informant selectByUserCode(String usercode);
    
    int updateLoginCount(String usercode);
}