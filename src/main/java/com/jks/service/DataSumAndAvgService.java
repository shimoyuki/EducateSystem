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
import com.jks.entity.StudentQuality;
import com.jks.entity.Teachers;

public interface DataSumAndAvgService {
	//城市列表
			List<String> getAreaList();
			//基本情况 	
			List<Size> getAvgSize(String year, String city);
			
			List<Size> getSumSize(String year, String city);
			
			List<Equitment> getAvgEquitment(String year, String city);
			
			List<Equitment> getSumEquitment(String year, String city);
			
			List<Teachers> getAvgTeachers(String year, String city);
			
			List<Teachers> getSumTeachers(String year, String city);;
			
			List<Information> getAvgInformation(String year, String city);
			
			List<Information> getSumInformation(String year, String city);
			
			//学生发展
			List<StudentQuality> getAvgStudentQuality(String year, String city);
			
			List<StudentQuality> getSumStudentQuality(String year, String city);
			
			List<Experience> getAvgExperience(String year, String city);
			
			List<Experience> getSumExperience(String year, String city);
			
			List<EmployQuality> getAvgEmployQuality(String year, String city);
			
			List<EmployQuality> getSumEmployQuality(String year, String city);
			//质量保障措施 	
			List<MajorLayout> getAvgMajorLayout(String year, String city);
			
			List<MajorLayout> getSumMajorLayout(String year, String city);
			
			List<MajorNum> getAvgMajorNum(String year, String city);
			
			List<MajorNum> getSumMajorNum(String year, String city);
			
			List<QualityAssurance> getAvgQualityAssurance(String year, String city);
			
			List<QualityAssurance> getSumQualityAssurance(String year, String city);
			
			List<EducationTrain> getAvgEducationTrain(String year, String city);
			
			List<EducationTrain> getSumEducationTrain(String year, String city);
			
			//校企合作 
			List<Schoolenterprise> getAvgSchoolenterprise(String year, String city);
			
			List<Schoolenterprise> getSumSchoolenterprise(String year, String city);
			
			List<Internship> getAvgInternship(String year, String city);
			
			List<Internship> getSumInternship(String year, String city);
			
			List<Groupschool> getAvgGroupschool(String year, String city);
			
			List<Groupschool> getSumGroupschool(String year, String city);
			
			//社会贡献 
			List<SkillTrain> getAvgSkillTrain(String year, String city);
			
			List<SkillTrain> getSumSkillTrain(String year, String city);
			
			List<SocialService> getAvgSocialService(String year, String city);
			
			List<SocialService> getSumSocialService(String year, String city);
			
			List<CounpaSupp> getAvgCounpaSupp(String year, String city);
			
			List<CounpaSupp> getSumCounpaSupp(String year, String city);
			
			//举办者履职 
			
			List<Funds> getAvgFunds(String year, String city);
			
			List<Funds> getSumFunds(String year, String city);
			
			List<Policy> getAvgPolicy(String year, String city);
			
			List<Policy> getSumPolicy(String year, String city);
			
			//党建工作	
			List<Partybulid> getAvgPartybulid(String year, String city);
			
			List<Partybulid> getSumPartybulid(String year, String city);

}
