package com.jks.serviceImpl;

import java.util.List;

import javax.annotation.Resource;  

import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional; 

import com.jks.dao.SizeDao;
import com.jks.entity.Size;
import com.jks.service.SizeService;


@Service
@Transactional 
public class SizeServiceImpl implements SizeService{
	
	 @Resource  
   private SizeDao sizeDao;
	

	@Override
	public List<Size> getSizeList(String admcode,String year){
		
		List<Size> size = sizeDao.getSizeList(admcode,year);
		
		return size;
		
	}
	
	@Override
	public void saveSize(Size size) {
		
		sizeDao.saveSize(size);
	
	}
	
	@Override
	public  boolean deleteSize(int id)  {
		
		return  sizeDao.deleteSize(id);
	
	}
	
	@Override
	public Size findById(int id) {  
    	Size size = sizeDao.findById(id);  
        return size;  
    }
	
	@Override
	public boolean updateSize(Size size) {  
          return sizeDao.updateSize(size);  
    }

	@Override
	public boolean updateAudit(int id) {
		return sizeDao.updateAudit(id);
	}

	@Override
	public List<Size> findByCity(String city,String year) {
		List<Size> size = sizeDao.findByCity(city, year);
		return size;
	}

	@Override
	public Integer checkYear(Size size) {
		// TODO Auto-generated method stub
		return sizeDao.checkYear(size);
	}

	@Override
	public Integer checkMajor(String admcode, String year) {
		// TODO Auto-generated method stub
		return sizeDao.checkMajor( admcode,  year);
	}

}
