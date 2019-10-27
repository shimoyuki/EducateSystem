package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jks.dao.WriteSituationDao;
import com.jks.entity.WriteSituation;
import com.jks.service.WriteSituationService;

@Service
@Transactional
public class WriteSituationServiceImpl implements WriteSituationService{
	@Resource
	WriteSituationDao writeSituationDao;

	@Override
	public List<WriteSituation> getWriteSituation(String year, String school) {		
		List<WriteSituation> WriteSituation = writeSituationDao.getWriteSituation(year,school);
		return WriteSituation;
	}
	
	@Override
	public List<WriteSituation> getWriteSituationNull(String school) {
		List<WriteSituation> WriteSituationNull = writeSituationDao.getWriteSituationNull(school);
		return WriteSituationNull;
	}

}
