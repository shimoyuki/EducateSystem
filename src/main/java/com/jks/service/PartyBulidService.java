package com.jks.service;

import java.util.List;

import com.jks.entity.Partybulid;

public interface PartyBulidService {

	List<Partybulid> getPartyBulidList(String admcode, String year);

	List<Partybulid> findByCity(String city, String year);

	void savePartyBulid(Partybulid partybulid);

	boolean deletePartyBulid(int id);

	Partybulid findById(int id);

	boolean updatePartyBulid(Partybulid partybulid);

	boolean updateAudit(int id);

	List<Partybulid> getPartyBulidListByAdmin(String admcode, String years);

	List<Partybulid> adminFindByCity(String city, String years);

	Integer checkYear(Partybulid partybulid);

	

}
