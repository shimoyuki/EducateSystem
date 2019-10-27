package com.jks.service;

import java.util.List;

import com.jks.entity.WriteSituation;

public interface WriteSituationService {

	List<WriteSituation> getWriteSituation(String year, String school);

	List<WriteSituation> getWriteSituationNull(String school);

}
