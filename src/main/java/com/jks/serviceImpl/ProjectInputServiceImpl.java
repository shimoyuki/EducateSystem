package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jks.dao.ProjectInputDao;
import com.jks.entity.ProjectInput;
import com.jks.service.ProjectInputService;

@Service
@Transactional
public class ProjectInputServiceImpl implements ProjectInputService{
	
	@Resource  
    private ProjectInputDao projectInputDao;
	
	@Override
	public List<ProjectInput> getProjectInputList(int id) {
		 List<ProjectInput> projectInput = projectInputDao.getProjectInputList(id);
		return projectInput;
	}

	@Override
	public boolean saveProjectInput(ProjectInput projectInput) {
		return projectInputDao.saveProjectInput(projectInput);
		
	}

	@Override
	public boolean deleteProjectInput(String admcode, String year) {
		return projectInputDao.deleteProjectInput( admcode,  year);
	}

	@Override
	public boolean updateProjectInput(ProjectInput projectInput) {
		return projectInputDao.updateProjectInput(projectInput);
		
	}

	@Override
	public void deleteFundsTable(int ids) {
		projectInputDao.deleteFundsTable(ids);
		
	}

	@Override
	public boolean updateAudit(int id) {
		return projectInputDao.updateAudit(id);
	}

}
