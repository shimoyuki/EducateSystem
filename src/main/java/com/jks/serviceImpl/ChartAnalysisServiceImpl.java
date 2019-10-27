package com.jks.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jks.dao.ChartAnalysisDao;
import com.jks.dao.SchoolInfoMapper;
import com.jks.dao.TargetNameMapper;
import com.jks.entity.CounpaSupp;
import com.jks.entity.EducationTrain;
import com.jks.entity.EmployQuality;
import com.jks.entity.Equitment;
import com.jks.entity.Experience;
import com.jks.entity.Funds;
import com.jks.entity.Groupschool;
import com.jks.entity.Information;
import com.jks.entity.Internship;
import com.jks.entity.MajorLayout;
import com.jks.entity.MajorNum;
import com.jks.entity.Partybulid;
import com.jks.entity.Policy;
import com.jks.entity.QualityAssurance;
import com.jks.entity.Schoolenterprise;
import com.jks.entity.Size;
import com.jks.entity.SkillTrain;
import com.jks.entity.SocialService;
import com.jks.entity.Standard;
import com.jks.entity.StudentQuality;
import com.jks.entity.TargetName;
import com.jks.entity.Teachers;
import com.jks.service.ChartAnalysisService;

@Service
@Transactional
public class ChartAnalysisServiceImpl implements ChartAnalysisService{

	@Resource  
	private ChartAnalysisDao chartAnalysisDao;
	@Resource  
	private TargetNameMapper targetNameDAO;
	@Resource  
	private SchoolInfoMapper schoolDAO;
	
	@Override
	public List<Size> getSizeList(String year, String[] area,String[] school) {
		
		List<Size> size = chartAnalysisDao.getSizeList(year,area,school); 
		return size;
	}

	@Override
	public List<TargetName> getTargetList(String source) {
		// TODO Auto-generated method stub
		return this.targetNameDAO.selectBySource(source);
	}

	@Override
	public String[] getTargetNames(String[] fields, String source) {
		// TODO Auto-generated method stub
		String[] names = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			names[i] = this.targetNameDAO.selectNameByField(fields[i], source);
		}
		return names;
	}

	@Override
	public String[] getTargetFields(String[] names, String source) {
		// TODO Auto-generated method stub
		String[] fields = new String[names.length];
		for (int i = 0; i < names.length; i++) {
			fields[i] = this.targetNameDAO.selectFieldByName(names[i], source);
		}
		return fields;
	}
	
	@Override
	public String[] getTargetNamesWithMeasure(String[] names, String source) {
		// TODO Auto-generated method stub
		String[] nwm = new String[names.length];
		for (int i = 0; i < names.length; i++) {
			nwm[i] = names[i]+"("+this.targetNameDAO.selectMeasureByName(names[i], source)+")";
		}
		return nwm;
	}

	@Override
	public List<String> getSchoolList(String area, String type) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new TreeMap<String,Object>();
		params.put("city", area);
		List<String> schoolList = new ArrayList<>();
		switch (type) {
        case "公办":
        	params.put("schoolrun", "0");
        	schoolList = this.chartAnalysisDao.getSchoolList(params);
            break;
        case "民办":
        	params.put("schoolrun", "1");
        	schoolList = this.chartAnalysisDao.getSchoolList(params);
            break;
        case "混合制":
        	params.put("schoolrun", "2");
        	schoolList = this.chartAnalysisDao.getSchoolList(params);
            break;
        case "一般":
        	params.put("schoollevel", "0");
        	schoolList = this.chartAnalysisDao.getSchoolList(params);
            break;
        case "国示校":
        	params.put("schoollevel", "1");
        	schoolList = this.chartAnalysisDao.getSchoolList(params);
            break;
        case "国重校":
        	params.put("schoollevel", "2");
        	schoolList = this.chartAnalysisDao.getSchoolList(params);
            break;
        case "省重校":
        	params.put("schoollevel", "3");
        	schoolList = this.chartAnalysisDao.getSchoolList(params);
            break;
        case "教育行政部":
        	params.put("schoolsubject", "0");
        	schoolList = this.chartAnalysisDao.getSchoolList(params);
            break;
        case "人社部门":
        	params.put("schoolsubject", "1");
        	schoolList = this.chartAnalysisDao.getSchoolList(params);
            break;
        case "行业":
        	params.put("schoolsubject", "2");
        	schoolList = this.chartAnalysisDao.getSchoolList(params);
            break;
    }
		return schoolList;
	}

	@Override
	public String getSchoolName(String admcode) {
		// TODO Auto-generated method stub
		return this.schoolDAO.selectNameByCode(admcode);
	}

	@Override
	public String getSchoolCode(String schoolname) {
		// TODO Auto-generated method stub
		return this.schoolDAO.selectCodeByName(schoolname);
	}
	
	@Override
	public List<Size> getSchoolSize(String[] year, String school) {
		// TODO Auto-generated method stub
		return chartAnalysisDao.getSchoolSize(year, school);
	}

	@Override
	public List<Size> getAreaAvgSize(String[] year, String city) {
		// TODO Auto-generated method stub
		return Size.avg(chartAnalysisDao.getAreaSize(year, city));
	}
	
	@Override
	public List<Size> getAreaSumSize(String[] year, String city) {
		// TODO Auto-generated method stub
		return Size.sum(chartAnalysisDao.getAreaSize(year, city));
	}

	@Override
	public List<Equitment> getSchoolEquitment(String[] year, String school) {
		// TODO Auto-generated method stub
		return chartAnalysisDao.getSchoolEquitment(year, school);
	}

	@Override
	public List<Equitment> getAreaAvgEquitment(String[] year, String city) {
		// TODO Auto-generated method stub
		return Equitment.avg(chartAnalysisDao.getAreaEquitment(year, city));
	}

	@Override
	public List<Equitment> getAreaSumEquitment(String[] year, String city) {
		// TODO Auto-generated method stub
		return Equitment.sum(chartAnalysisDao.getAreaEquitment(year, city));
	}

	@Override
	public List<Teachers> getSchoolTeachers(String[] year, String school) {
		// TODO Auto-generated method stub
		return chartAnalysisDao.getSchoolTeachers(year, school);
	}

	@Override
	public List<Teachers> getAreaAvgTeachers(String[] year, String city) {
		// TODO Auto-generated method stub
		return Teachers.avg(chartAnalysisDao.getAreaTeachers(year, city));
	}

	@Override
	public List<Teachers> getAreaSumTeachers(String[] year, String city) {
		// TODO Auto-generated method stub
		return Teachers.sum(chartAnalysisDao.getAreaTeachers(year, city));
	}

	@Override
	public List<Information> getSchoolInformation(String[] year, String school) {
		// TODO Auto-generated method stub
		return chartAnalysisDao.getSchoolInformation(year, school);
	}

	@Override
	public List<Information> getAreaAvgInformation(String[] year, String city) {
		// TODO Auto-generated method stub
		return Information.avg(chartAnalysisDao.getAreaInformation(year, city));
	}

	@Override
	public List<Information> getAreaSumInformation(String[] year, String city) {
		// TODO Auto-generated method stub
		return Information.sum(chartAnalysisDao.getAreaInformation(year, city));
	}

	@Override
	public List<StudentQuality> getSchoolStudentQuality(String[] year, String school) {
		// TODO Auto-generated method stub
		return chartAnalysisDao.getSchoolStudentQuality(year, school);
	}

	@Override
	public List<StudentQuality> getAreaAvgStudentQuality(String[] year, String city) {
		// TODO Auto-generated method stub
		return StudentQuality.avg(chartAnalysisDao.getAreaStudentQuality(year, city));
	}

	@Override
	public List<StudentQuality> getAreaSumStudentQuality(String[] year, String city) {
		// TODO Auto-generated method stub
		return StudentQuality.sum(chartAnalysisDao.getAreaStudentQuality(year, city));
	}

	@Override
	public List<Experience> getSchoolExperience(String[] year, String school) {
		// TODO Auto-generated method stub
		return chartAnalysisDao.getSchoolExperience(year, school);
	}

	@Override
	public List<Experience> getAreaAvgExperience(String[] year, String city) {
		// TODO Auto-generated method stub
		return Experience.avg(chartAnalysisDao.getAreaExperience(year, city));
	}

	@Override
	public List<Experience> getAreaSumExperience(String[] year, String city) {
		// TODO Auto-generated method stub
		return Experience.sum(chartAnalysisDao.getAreaExperience(year, city));
	}

	@Override
	public List<EmployQuality> getSchoolEmployQuality(String[] year, String school) {
		// TODO Auto-generated method stub
		return chartAnalysisDao.getSchoolEmployQuality(year, school);
	}

	@Override
	public List<EmployQuality> getAreaAvgEmployQuality(String[] year, String city) {
		// TODO Auto-generated method stub
		return EmployQuality.avg(chartAnalysisDao.getAreaEmployQuality(year, city));
	}

	@Override
	public List<EmployQuality> getAreaSumEmployQuality(String[] year, String city) {
		// TODO Auto-generated method stub
		return EmployQuality.sum(chartAnalysisDao.getAreaEmployQuality(year, city));
	}

	@Override
	public List<MajorLayout> getSchoolMajorLayout(String[] year, String school) {
		// TODO Auto-generated method stub
		return chartAnalysisDao.getSchoolMajorLayout(year, school);
	}

	@Override
	public List<MajorLayout> getAreaAvgMajorLayout(String[] year, String city) {
		// TODO Auto-generated method stub
		return MajorLayout.avg(chartAnalysisDao.getAreaMajorLayout(year, city));
	}

	@Override
	public List<MajorLayout> getAreaSumMajorLayout(String[] year, String city) {
		// TODO Auto-generated method stub
		return MajorLayout.sum(chartAnalysisDao.getAreaMajorLayout(year, city));
	}

	@Override
	public List<MajorNum> getSchoolMajorNum(String[] year, String school) {
		// TODO Auto-generated method stub
		return chartAnalysisDao.getSchoolMajorNum(year, school);
	}

	@Override
	public List<MajorNum> getAreaAvgMajorNum(String[] year, String city) {
		// TODO Auto-generated method stub
		return MajorNum.avg(chartAnalysisDao.getAreaMajorNum(year, city));
	}

	@Override
	public List<MajorNum> getAreaSumMajorNum(String[] year, String city) {
		// TODO Auto-generated method stub
		return MajorNum.sum(chartAnalysisDao.getAreaMajorNum(year, city));
	}

	@Override
	public List<QualityAssurance> getSchoolQualityAssurance(String[] year, String school) {
		// TODO Auto-generated method stub
		return chartAnalysisDao.getSchoolQualityAssurance(year, school);
	}

	@Override
	public List<QualityAssurance> getAreaAvgQualityAssurance(String[] year, String city) {
		// TODO Auto-generated method stub
		return QualityAssurance.avg(chartAnalysisDao.getAreaQualityAssurance(year, city));
	}

	@Override
	public List<QualityAssurance> getAreaSumQualityAssurance(String[] year, String city) {
		// TODO Auto-generated method stub
		return QualityAssurance.sum(chartAnalysisDao.getAreaQualityAssurance(year, city));
	}

	@Override
	public List<EducationTrain> getSchoolEducationTrain(String[] year, String school) {
		// TODO Auto-generated method stub
		return chartAnalysisDao.getSchoolEducationTrain(year, school);
	}

	@Override
	public List<EducationTrain> getAreaAvgEducationTrain(String[] year, String city) {
		// TODO Auto-generated method stub
		return EducationTrain.avg(chartAnalysisDao.getAreaEducationTrain(year, city));
	}

	@Override
	public List<EducationTrain> getAreaSumEducationTrain(String[] year, String city) {
		// TODO Auto-generated method stub
		return EducationTrain.sum(chartAnalysisDao.getAreaEducationTrain(year, city));
	}

	@Override
	public List<Schoolenterprise> getSchoolSchoolenterprise(String[] year, String school) {
		// TODO Auto-generated method stub
		return chartAnalysisDao.getSchoolSchoolenterprise(year, school);
	}

	@Override
	public List<Schoolenterprise> getAreaAvgSchoolenterprise(String[] year, String city) {
		// TODO Auto-generated method stub
		return Schoolenterprise.avg(chartAnalysisDao.getAreaSchoolenterprise(year, city));
	}

	@Override
	public List<Schoolenterprise> getAreaSumSchoolenterprise(String[] year, String city) {
		// TODO Auto-generated method stub
		return Schoolenterprise.sum(chartAnalysisDao.getAreaSchoolenterprise(year, city));
	}

	@Override
	public List<Internship> getSchoolInternship(String[] year, String school) {
		// TODO Auto-generated method stub
		return chartAnalysisDao.getSchoolInternship(year, school);
	}

	@Override
	public List<Internship> getAreaAvgInternship(String[] year, String city) {
		// TODO Auto-generated method stub
		return Internship.avg(chartAnalysisDao.getAreaInternship(year, city));
	}

	@Override
	public List<Internship> getAreaSumInternship(String[] year, String city) {
		// TODO Auto-generated method stub
		return Internship.sum(chartAnalysisDao.getAreaInternship(year, city));
	}

	@Override
	public List<Groupschool> getSchoolGroupschool(String[] year, String school) {
		// TODO Auto-generated method stub
		return chartAnalysisDao.getSchoolGroupschool(year, school);
	}

	@Override
	public List<Groupschool> getAreaAvgGroupschool(String[] year, String city) {
		// TODO Auto-generated method stub
		return Groupschool.avg(chartAnalysisDao.getAreaGroupschool(year, city));
	}

	@Override
	public List<Groupschool> getAreaSumGroupschool(String[] year, String city) {
		// TODO Auto-generated method stub
		return Groupschool.sum(chartAnalysisDao.getAreaGroupschool(year, city));
	}

	@Override
	public List<SkillTrain> getSchoolSkillTrain(String[] year, String school) {
		// TODO Auto-generated method stub
		return chartAnalysisDao.getSchoolSkillTrain(year, school);
	}

	@Override
	public List<SkillTrain> getAreaAvgSkillTrain(String[] year, String city) {
		// TODO Auto-generated method stub
		return SkillTrain.avg(chartAnalysisDao.getAreaSkillTrain(year, city));
	}

	@Override
	public List<SkillTrain> getAreaSumSkillTrain(String[] year, String city) {
		// TODO Auto-generated method stub
		return SkillTrain.sum(chartAnalysisDao.getAreaSkillTrain(year, city));
	}

	@Override
	public List<SocialService> getSchoolSocialService(String[] year, String school) {
		// TODO Auto-generated method stub
		return chartAnalysisDao.getSchoolSocialService(year, school);
	}

	@Override
	public List<SocialService> getAreaAvgSocialService(String[] year, String city) {
		// TODO Auto-generated method stub
		return SocialService.avg(chartAnalysisDao.getAreaSocialService(year, city));
	}

	@Override
	public List<SocialService> getAreaSumSocialService(String[] year, String city) {
		// TODO Auto-generated method stub
		return SocialService.sum(chartAnalysisDao.getAreaSocialService(year, city));
	}

	@Override
	public List<CounpaSupp> getSchoolCounpaSupp(String[] year, String school) {
		// TODO Auto-generated method stub
		return chartAnalysisDao.getSchoolCounpaSupp(year, school);
	}

	@Override
	public List<CounpaSupp> getAreaAvgCounpaSupp(String[] year, String city) {
		// TODO Auto-generated method stub
		return CounpaSupp.avg(chartAnalysisDao.getAreaCounpaSupp(year, city));
	}

	@Override
	public List<CounpaSupp> getAreaSumCounpaSupp(String[] year, String city) {
		// TODO Auto-generated method stub
		return CounpaSupp.sum(chartAnalysisDao.getAreaCounpaSupp(year, city));
	}

	@Override
	public List<Funds> getSchoolFunds(String[] year, String school) {
		// TODO Auto-generated method stub
		return chartAnalysisDao.getSchoolFunds(year, school);
	}

	@Override
	public List<Funds> getAreaAvgFunds(String[] year, String city) {
		// TODO Auto-generated method stub
		return Funds.avg(chartAnalysisDao.getAreaFunds(year, city));
	}

	@Override
	public List<Funds> getAreaSumFunds(String[] year, String city) {
		// TODO Auto-generated method stub
		return Funds.sum(chartAnalysisDao.getAreaFunds(year, city));
	}

	@Override
	public List<Policy> getSchoolPolicy(String[] year, String school) {
		// TODO Auto-generated method stub
		return chartAnalysisDao.getSchoolPolicy(year, school);
	}

	@Override
	public List<Policy> getAreaAvgPolicy(String[] year, String city) {
		// TODO Auto-generated method stub
		return Policy.avg(chartAnalysisDao.getAreaPolicy(year, city));
	}

	@Override
	public List<Policy> getAreaSumPolicy(String[] year, String city) {
		// TODO Auto-generated method stub
		return Policy.sum(chartAnalysisDao.getAreaPolicy(year, city));
	}

	@Override
	public List<Partybulid> getSchoolPartybulid(String[] year, String school) {
		// TODO Auto-generated method stub
		return chartAnalysisDao.getSchoolPartybulid(year, school);
	}

	@Override
	public List<Partybulid> getAreaAvgPartybulid(String[] year, String city) {
		// TODO Auto-generated method stub
		return Partybulid.avg(chartAnalysisDao.getAreaPartybulid(year, city));
	}

	@Override
	public List<Partybulid> getAreaSumPartybulid(String[] year, String city) {
		// TODO Auto-generated method stub
		return Partybulid.sum(chartAnalysisDao.getAreaPartybulid(year, city));
	}

	@Override
	public List<Standard> getSchoolStandard(String[] year, String school) {
		// TODO Auto-generated method stub
		return chartAnalysisDao.getSchoolStandard(year, school);
	}

	@Override
	public List<Standard> getAreaAvgStandard(String[] year, String city) {
		// TODO Auto-generated method stub
		return Standard.avg(chartAnalysisDao.getAreaStandard(year, city));
	}

	@Override
	public List<Standard> getAreaSumStandard(String[] year, String city) {
		// TODO Auto-generated method stub
		return Standard.sum(chartAnalysisDao.getAreaStandard(year, city));
	}
	
}
