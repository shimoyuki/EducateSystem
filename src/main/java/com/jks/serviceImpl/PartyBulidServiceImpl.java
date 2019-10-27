package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jks.dao.PartybulidMapper;
import com.jks.entity.Partybulid;
import com.jks.service.PartyBulidService;
@Service
@Transactional 
public class PartyBulidServiceImpl implements PartyBulidService {
	
	 @Resource
	private PartybulidMapper pbm;
	@Override
	public List<Partybulid> getPartyBulidList(String admcode, String year) {
		// TODO Auto-generated method stub
		List<Partybulid> partybulid = pbm.getPartyBulidList(admcode,year);
		return partybulid;
	}

	@Override
	public void savePartyBulid(Partybulid partybulid) {
		
		pbm.savePartyBulid(partybulid);
	
	}
	
	@Override
	public  boolean deletePartyBulid(int id)  {
		
		return  pbm.deletePartyBulid(id);
	
	}
	
	@Override
	public Partybulid findById(int id) {  
		Partybulid partybulid = pbm.findById(id);  
        return partybulid;  
    }
	
	@Override
	public boolean updatePartyBulid(Partybulid partybulid) {  
          return pbm.updatePartyBulid(partybulid);  
    }

	@Override
	public boolean updateAudit(int id) {
		return pbm.updateAudit(id);
	}

	@Override
	public List<Partybulid> findByCity(String city, String year) {
		// TODO Auto-generated method stub
		List<Partybulid> partybulid=pbm.findByCity(city,year);
		return partybulid;
	}

	@Override
	public List<Partybulid> getPartyBulidListByAdmin(String admcode, String years) {
		// TODO Auto-generated method stub
		List<Partybulid> partybulid = pbm.getPartyBulidListByAdmin(admcode,years);
		return partybulid;
	}

	@Override
	public List<Partybulid> adminFindByCity(String city, String years) {
		// TODO Auto-generated method stub
		List<Partybulid> partybulid=pbm.adminFindByCity(city,years);
		return partybulid;
	}

	@Override
	public Integer checkYear(Partybulid partybulid) {
		// TODO Auto-generated method stub
		return pbm.checkYear(partybulid);
	}

}
