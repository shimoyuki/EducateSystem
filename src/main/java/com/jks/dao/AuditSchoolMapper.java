package com.jks.dao;

import com.jks.entity.AuditSchool;

public interface AuditSchoolMapper {
   
    int deleteByPrimaryKey(Integer id);

   
    int insert(AuditSchool record);

   
    int insertSelective(AuditSchool record);

   
    AuditSchool selectByPrimaryKey(Integer id);

    String selectAdmByAudit(String auditcode);
  
    int updateByPrimaryKeySelective(AuditSchool record);

  
    int updateByPrimaryKey(AuditSchool record);
}