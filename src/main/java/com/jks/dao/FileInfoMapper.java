package com.jks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jks.entity.FileInfo;

public interface FileInfoMapper {
   
    int deleteByPrimaryKey(Integer id);
  
    int insert(FileInfo record);

    int insertByWriter(FileInfo fileinfo);
   
    int insertSelective(FileInfo record);
 
    FileInfo selectByPrimaryKey(Integer id);
    
    List<FileInfo> getFileList(@Param("Writer")String writer,@Param("WriteTime")String writetime,@Param("Source")String source,@Param("City")String city);
 
    int selectFileByName(String writer,String name);
    
    int updateByPrimaryKeySelective(FileInfo record);
   
    int updateByPrimaryKey(FileInfo record);

	List<FileInfo> findByCity(@Param("city")String city, @Param("year")String year, @Param("source") String source);
	
	List<FileInfo> getFileList(@Param("Writer")String writer,@Param("WriteTime")String writetime,@Param("Source")String source);
}