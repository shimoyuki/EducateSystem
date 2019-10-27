package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jks.dao.AuditSchoolMapper;
import com.jks.dao.FileInfoMapper;
import com.jks.entity.FileInfo;
import com.jks.service.FileInfoService;
@Service
public class FileInfoServiceImpl implements FileInfoService {

	@Resource
	FileInfoMapper fm;
	@Resource
	AuditSchoolMapper am;
	
	
	@Override
	public String getAdmByAudit(String auditcode) {
		// TODO Auto-generated method stub
		return am.selectAdmByAudit(auditcode);
	}
	@Override
	public int insertAndGet(FileInfo fileinfo) {
		// TODO Auto-generated method stub	
		return fm.insertByWriter(fileinfo);
	}
	@Override
	public int getCountByNameAndCode(String writer, String name) {
		// TODO Auto-generated method stub
		return fm.selectFileByName(writer, name);
	}
	@Override
	public FileInfo getFileInfoByID(int id) {
		// TODO Auto-generated method stub
		return fm.selectByPrimaryKey(id);
	}
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return fm.deleteByPrimaryKey(id)>0;
	}
	@Override
	public boolean modifyFile(FileInfo file) {
		// TODO Auto-generated method stub
		if (fm.updateByPrimaryKey(file) > 0) {
			return true;
		}
		return false;
	}
	@Override
	public List<FileInfo> findByCity(String city, String year, String source) {
		// TODO Auto-generated method stub
		return fm.findByCity(city, year,source);
	}
	@Override
	public List<FileInfo> getFileList(String writer, String year, String source) {
		// TODO Auto-generated method stub
		return fm.getFileList(writer, year, source);
	}

}
