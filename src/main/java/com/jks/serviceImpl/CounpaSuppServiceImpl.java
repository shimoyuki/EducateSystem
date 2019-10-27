package com.jks.serviceImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jks.dao.CounpaSuppMapper;
import com.jks.dao.PoorMapper;
import com.jks.entity.CounDTO;
import com.jks.entity.CounpaSupp;
import com.jks.entity.Poor;
import com.jks.service.CounpaSuppService;

@Service("counService")
@Transactional
public class CounpaSuppServiceImpl extends BaseService implements
		CounpaSuppService {

	@Resource
	private CounpaSuppMapper counDAO;
	@Resource
	private PoorMapper poorDAO;

	@Override
	public CounDTO getCounpaSuppById(int cId) {
		// TODO Auto-generated method stub
		CounDTO counDTO = new CounDTO();
		CounpaSupp coun = this.counDAO.selectByPrimaryKey(cId);
		counDTO.setMain(coun);
		Map<String, Object> params = new TreeMap<String, Object>();
		params.put("admcode", coun.getAdmcode());
		params.put("year", coun.getYear());
		counDTO.setList(this.poorDAO.query(params));
		return counDTO;
	}

	@Override
	public boolean addCounpaSupp(CounDTO counDTO) {
		// TODO Auto-generated method stub
		boolean result = true;
		if (this.counDAO.insertSelective(counDTO.getMain()) == 0) {
			result = false;
			return result;
		}
		if (counDTO.getList() != null) {
			Iterator<Poor> iterator = counDTO.getList().iterator();
			while (iterator.hasNext()) {
				Poor poor = (Poor) iterator.next();
				if (this.poorDAO.insertSelective(poor) == 0) {
					result = false;
				}
			}
		}
		return result;
	}

	@Override
	public boolean deleteCounpaSupp(int cId) {
		// TODO Auto-generated method stub
		boolean result = true;
		CounpaSupp coun = this.counDAO.selectByPrimaryKey(cId);
		Map<String, Object> params = new TreeMap<String, Object>();
		params.put("admcode", coun.getAdmcode());
		params.put("year", coun.getYear());
		List<Poor> poorList = this.poorDAO.query(params);
		if (poorList.size() > 0) {
			if (this.poorDAO.delete(params) == 0) {
				result = false;
				return result;
			}
		}
		if (this.counDAO.deleteByPrimaryKey(cId) == 0) {
			Iterator<Poor> iterator = poorList.iterator();
			while (iterator.hasNext()) {
				this.poorDAO.insertSelective(iterator.next());
			}
			result = false;
		}
		return result;
	}

	@Override
	public boolean modifyCounpaSupp(CounDTO counDTO) {
		// TODO Auto-generated method stub
		boolean result = true;
		if (this.counDAO.updateByPrimaryKeySelective(counDTO.getMain()) == 0) {
			result = false;
			return result;
		}
		if(counDTO.getList() != null){
			Iterator<Poor> iterator = counDTO.getList().iterator();
			while (iterator.hasNext()) {
				Poor poor = (Poor) iterator.next();
				if (poor.getId().equals(-1) ) {
					poor.setId(null);
					if (this.poorDAO.insertSelective(poor) == 0) {
						result = false;
					}
				}else{
					if (this.poorDAO.updateByPrimaryKeySelective(poor) == 0) {
						result = false;
					}
				}
			}
		}
		return result;
	}

	@Override
	public PageInfo<CounpaSupp> getCounpaSuppPage(Map<String, Object> params) {
		// TODO Auto-generated method stub
		this.startPage(params);
		Page<CounpaSupp> counPage = this.counDAO.query(params);
		return new PageInfo<CounpaSupp>(counPage);
	}

	@Override
	public List<String> getAdmcodeByCity(String city) {
		// TODO Auto-generated method stub
		return this.counDAO.selectAdmcodeByCity(city);
	}

	@Override
	public boolean deletePoor(int pId) {
		// TODO Auto-generated method stub
		if (this.poorDAO.deleteByPrimaryKey(pId) > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public List<Poor> getPoorList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.poorDAO.query(params);
	}

}
