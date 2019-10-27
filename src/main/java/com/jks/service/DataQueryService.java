package com.jks.service;

import java.util.List;

import com.jks.entity.CounpaSupp;
import com.jks.entity.EducationTrain;
import com.jks.entity.EmployQuality;
import com.jks.entity.Equitment;
import com.jks.entity.Experience;
import com.jks.entity.FileInfo;
import com.jks.entity.Funds;
import com.jks.entity.Groupschool;
import com.jks.entity.Information;
import com.jks.entity.Internship;
import com.jks.entity.MajorLayout;
import com.jks.entity.MajorNum;
import com.jks.entity.Partybulid;
import com.jks.entity.Policy;
import com.jks.entity.Poor;
import com.jks.entity.QualityAssurance;
import com.jks.entity.Schoolenterprise;
import com.jks.entity.Size;
import com.jks.entity.Skill;
import com.jks.entity.SkillTrain;
import com.jks.entity.SocialService;
import com.jks.entity.StudentQuality;
import com.jks.entity.Teachers;
import com.jks.entity.User;

public interface DataQueryService{
	User getUserByAdmcode(String admcode);
	
	List<Size> getSizeList(String admcode,String city);
	List<Equitment> getEquitmentList(String admcode,String city);
	List<Teachers> getTeachersList(String admcode,String city);
	List<Information> getInformationList(String admcode,String city);
	
	List<StudentQuality> getStudentQualityList(String admcode,String city);
	List<Experience> getExperienceList(String admcode,String city);
	List<EmployQuality> getEmployQualityList(String admcode,String city);
	
	List<MajorLayout> getMajorLayoutList(String admcode,String city);
	List<MajorNum> getMajorNumList(String admcode,String city);
	List<QualityAssurance> getQualityAssuranceList(String admcode,String city);
	List<EducationTrain> getEducationTrainList(String admcode,String city);
	
	List<Schoolenterprise> getSchoolenterpriseList(String admcode,String city);
	List<Internship> getInternshipList(String admcode,String city);
	List<Groupschool> getGroupschoolList(String admcode,String city);
	
	List<SkillTrain> getSkillTrainList(String admcode,String city);
	List<Skill> getSkillList(int id);
	List<SocialService> getSocialServiceList(String admcode,String city);
	List<CounpaSupp> getCounpaSuppList(String admcode,String city);
	List<Poor> getPoorList(int id);
	
	List<Funds> getFundsList(String admcode,String city);
	List<Policy> getPolicyList(String admcode,String city);
	
	List<Partybulid> getPartybuildList(String admcode,String city);
	
	List<FileInfo> getFileInfoList(String admcode,String city);

	

	List<String> getSizeYearList();

	List<String> getEquitmentYearList();

	List<String> getTeachersYearList();

	List<String> getInformationYearList();

	List<String> getEmployQualityYearList();

	List<String> getExperienceYearList();

	List<String> getStudentQualityYearList();

	List<String> getEducationTrainYearList();

	List<String> getQualityAssuranceYearList();

	List<String> getMajorNumYearList();

	List<String> getMajorStuYearList();

	List<String> getMajorLayoutYearList();

	List<String> getSkillTrainYearList();

	List<String> getSkillYearList();

	List<String> getSocialServiceYearList();

	List<String> getCounpaSuppYearList();

	List<String> getPoorYearList();

	List<String> getFundsYearList();

	List<String> getProjectInputYearList();

	List<String> getPolicyYearList();

	List<String> getPolicyMeasureYearList();

	List<String> getPartybulidYearList();

	List<String> getSchoolenterpriseYearList();

	List<String> getGroupschoolYearList();

	List<String> getInternshipYearList();
	
	    
				
}
