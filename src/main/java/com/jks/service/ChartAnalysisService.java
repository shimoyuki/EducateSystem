package com.jks.service;

import java.util.List;

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

public interface ChartAnalysisService {
	
	List<Size> getSizeList(String year,String[] area,String[] school);
	
	//查询条件
	List<TargetName> getTargetList(String source);
    
    String[] getTargetNames(String[] fields, String source);
    
    String[] getTargetFields(String[] names, String source);
    
    String[] getTargetNamesWithMeasure(String[] names, String source);
    
    List<String> getSchoolList(String area, String type);
    
    String getSchoolName(String admcode);
    
    String getSchoolCode(String schoolname);
    
  //基本情况
    List<Size> getSchoolSize(String[] year, String school);
	
	List<Size> getAreaAvgSize(String[] year, String city);
	
	List<Size> getAreaSumSize(String[] year, String city);
	
	List<Equitment> getSchoolEquitment(String[] year, String school);
	
	List<Equitment> getAreaAvgEquitment(String[] year, String city);
	
	List<Equitment> getAreaSumEquitment(String[] year, String city);
	
	List<Teachers> getSchoolTeachers(String[] year, String school);
	
	List<Teachers> getAreaAvgTeachers(String[] year, String city);
	
	List<Teachers> getAreaSumTeachers(String[] year, String city);
	
	List<Information> getSchoolInformation(String[] year, String school);
	
	List<Information> getAreaAvgInformation(String[] year, String city);
	
	List<Information> getAreaSumInformation(String[] year, String city);
	
	//学生发展
	List<StudentQuality> getSchoolStudentQuality(String[] year, String school);
	
	List<StudentQuality> getAreaAvgStudentQuality(String[] year, String city);
	
	List<StudentQuality> getAreaSumStudentQuality(String[] year, String city);
	
	List<Experience> getSchoolExperience(String[] year, String school);
	
	List<Experience> getAreaAvgExperience(String[] year, String city);
	
	List<Experience> getAreaSumExperience(String[] year, String city);
	
	List<EmployQuality> getSchoolEmployQuality(String[] year, String school);
	
	List<EmployQuality> getAreaAvgEmployQuality(String[] year, String city);
	
	List<EmployQuality> getAreaSumEmployQuality(String[] year, String city);
	//质量保障措施 
	List<MajorLayout> getSchoolMajorLayout(String[] year, String school);
	
	List<MajorLayout> getAreaAvgMajorLayout(String[] year, String city);
	
	List<MajorLayout> getAreaSumMajorLayout(String[] year, String city);
	
	List<MajorNum> getSchoolMajorNum(String[] year, String school);
	
	List<MajorNum> getAreaAvgMajorNum(String[] year, String city);
	
	List<MajorNum> getAreaSumMajorNum(String[] year, String city);
	
	List<QualityAssurance> getSchoolQualityAssurance(String[] year, String school);
	
	List<QualityAssurance> getAreaAvgQualityAssurance(String[] year, String city);
	
	List<QualityAssurance> getAreaSumQualityAssurance(String[] year, String city);
	
	List<EducationTrain> getSchoolEducationTrain(String[] year, String school);
	
	List<EducationTrain> getAreaAvgEducationTrain(String[] year, String city);
	
	List<EducationTrain> getAreaSumEducationTrain(String[] year, String city);
	
	//校企合作 
	List<Schoolenterprise> getSchoolSchoolenterprise(String[] year, String school);
	
	List<Schoolenterprise> getAreaAvgSchoolenterprise(String[] year, String city);
	
	List<Schoolenterprise> getAreaSumSchoolenterprise(String[] year, String city);
	
	List<Internship> getSchoolInternship(String[] year, String school);
	
	List<Internship> getAreaAvgInternship(String[] year, String city);
	
	List<Internship> getAreaSumInternship(String[] year, String city);
	
	List<Groupschool> getSchoolGroupschool(String[] year, String school);
	
	List<Groupschool> getAreaAvgGroupschool(String[] year, String city);
	
	List<Groupschool> getAreaSumGroupschool(String[] year, String city);
	
	//社会贡献 
	List<SkillTrain> getSchoolSkillTrain(String[] year, String school);
	
	List<SkillTrain> getAreaAvgSkillTrain(String[] year, String city);
	
	List<SkillTrain> getAreaSumSkillTrain(String[] year, String city);
	
	List<SocialService> getSchoolSocialService(String[] year, String school);
	
	List<SocialService> getAreaAvgSocialService(String[] year, String city);
	
	List<SocialService> getAreaSumSocialService(String[] year, String city);
	
	List<CounpaSupp> getSchoolCounpaSupp(String[] year, String school);
	
	List<CounpaSupp> getAreaAvgCounpaSupp(String[] year, String city);
	
	List<CounpaSupp> getAreaSumCounpaSupp(String[] year, String city);
	
	//举办者履职 
	List<Funds> getSchoolFunds(String[] year, String school);
	
	List<Funds> getAreaAvgFunds(String[] year, String city);
	
	List<Funds> getAreaSumFunds(String[] year, String city);
	
	List<Policy> getSchoolPolicy(String[] year, String school);
	
	List<Policy> getAreaAvgPolicy(String[] year, String city);
	
	List<Policy> getAreaSumPolicy(String[] year, String city);
	
	//党建工作
	List<Partybulid> getSchoolPartybulid(String[] year, String school);
	
	List<Partybulid> getAreaAvgPartybulid(String[] year, String city);
	
	List<Partybulid> getAreaSumPartybulid(String[] year, String city);
	
	//国家标准
	List<Standard> getSchoolStandard(String[] year, String school);
	
	List<Standard> getAreaAvgStandard(String[] year, String city);
	
	List<Standard> getAreaSumStandard(String[] year, String city);
	
}
