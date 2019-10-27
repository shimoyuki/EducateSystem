package com.jks.service;

import java.util.List;

import com.jks.entity.FileInfo;


public interface FileInfoService {

	public List<FileInfo> getFileList(String writer,String year,String source);
	List<FileInfo> findByCity(String city,String year,String source);
	public String getAdmByAudit(String auditcode);
	public int insertAndGet(FileInfo fileinfo);
	public int getCountByNameAndCode(String writer,String name);
	public FileInfo getFileInfoByID(int id);
	public boolean delete(int id);
	public boolean modifyFile(FileInfo file);
}
