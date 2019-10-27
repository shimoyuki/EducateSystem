package com.jks.dao;

import com.jks.entity.CounpaSupp;

public interface CounpaSuppMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CounpaSupp record);

    int insertSelective(CounpaSupp record);

    CounpaSupp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CounpaSupp record);

    int updateByPrimaryKey(CounpaSupp record);
}