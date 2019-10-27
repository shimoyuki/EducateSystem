package com.jks.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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

@Repository("dataQueryDao")
public interface DataQueryDao {

	List<Size> getSizeList(@Param("admcode")String admcode, @Param("city")String city);

	List<Equitment> getEquitmentList(@Param("admcode")String admcode,@Param("city")String city);

	List<Teachers> getTeachersList(@Param("admcode")String admcode,@Param("city")String city);

	List<Information> getInformationList(@Param("admcode")String admcode,@Param("city")String city);

	List<StudentQuality> getStudentQualityList(@Param("admcode")String admcode,@Param("city")String city);

	List<Experience> getExperienceList(@Param("admcode")String admcode,@Param("city")String city);

	List<EmployQuality> getEmployQualityList(@Param("admcode")String admcode,@Param("city")String city);

	List<MajorLayout> getMajorLayoutList(@Param("admcode")String admcode,@Param("city")String city);

	List<MajorNum> getMajorNumList(@Param("admcode")String admcode,@Param("city")String city);

	List<QualityAssurance> getQualityAssuranceList(@Param("admcode")String admcode,@Param("city")String city);

	List<EducationTrain> getEducationTrainList(@Param("admcode")String admcode,@Param("city")String city);

	List<Schoolenterprise> getSchoolenterpriseList(@Param("admcode")String admcode,@Param("city")String city);

	List<Internship> getInternshipList(@Param("admcode")String admcode,@Param("city")String city);

	List<Groupschool> getGroupschoolList(@Param("admcode")String admcode,@Param("city")String city);

	List<SkillTrain> getSkillTrainList(@Param("admcode")String admcode,@Param("city")String city);

	List<SocialService> getSocialServiceList(@Param("admcode")String admcode,@Param("city")String city);

	List<CounpaSupp> getCounpaSuppList(@Param("admcode")String admcode,@Param("city")String city);

	List<Funds> getFundsList(@Param("admcode")String admcode,@Param("city")String city);

	List<Policy> getPolicyList(@Param("admcode")String admcode,@Param("city")String city);

	List<Partybulid> getPartybuildList(@Param("admcode")String admcode,@Param("city")String city);

	List<FileInfo> getFileInfoList(@Param("admcode")String admcode,@Param("city")String city);

	User getUserByAdmcode(String admcode);

	List<Skill> getSkillList(int id);

	List<Poor> getPoorlList(int id);

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
	
	String getSchoolName(String admcode);
	
			
}
