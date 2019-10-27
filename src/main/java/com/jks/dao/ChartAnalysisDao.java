package com.jks.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
import com.jks.entity.Teachers;

@Repository("chartAnalysisDao")
public interface ChartAnalysisDao {

	List<Size> getSizeList(@Param("year")String year, @Param("area")String[] area,@Param("school")String[] school);
	
	List<String> getSchoolList(Map<String, Object> params);
	
	//基本情况
	List<Size> getSchoolSize(@Param("year")String[] year, @Param("school")String school);
	
	List<Size> getAreaSize(@Param("year")String[] year, @Param("city")String city);
	
	List<Equitment> getSchoolEquitment(@Param("year")String[] year, @Param("school")String school);
	
	List<Equitment> getAreaEquitment(@Param("year")String[] year, @Param("city")String city);
	
	List<Teachers> getSchoolTeachers(@Param("year")String[] year, @Param("school")String school);
	
	List<Teachers> getAreaTeachers(@Param("year")String[] year, @Param("city")String city);
	
	List<Information> getSchoolInformation(@Param("year")String[] year, @Param("school")String school);
	
	List<Information> getAreaInformation(@Param("year")String[] year, @Param("city")String city);
	
	//学生发展
	List<StudentQuality> getSchoolStudentQuality(@Param("year")String[] year, @Param("school")String school);
	
	List<StudentQuality> getAreaStudentQuality(@Param("year")String[] year, @Param("city")String city);

	List<Experience> getSchoolExperience(@Param("year")String[] year, @Param("school")String school);
	
	List<Experience> getAreaExperience(@Param("year")String[] year, @Param("city")String city);

	List<EmployQuality> getSchoolEmployQuality(@Param("year")String[] year, @Param("school")String school);
	
	List<EmployQuality> getAreaEmployQuality(@Param("year")String[] year, @Param("city")String city);
	
	//质量保障措施 
	List<MajorLayout> getSchoolMajorLayout(@Param("year")String[] year, @Param("school")String school);
	
	List<MajorLayout> getAreaMajorLayout(@Param("year")String[] year, @Param("city")String city);

	List<MajorNum> getSchoolMajorNum(@Param("year")String[] year, @Param("school")String school);
	
	List<MajorNum> getAreaMajorNum(@Param("year")String[] year, @Param("city")String city);

	List<QualityAssurance> getSchoolQualityAssurance(@Param("year")String[] year, @Param("school")String school);
	
	List<QualityAssurance> getAreaQualityAssurance(@Param("year")String[] year, @Param("city")String city);
	
	List<EducationTrain> getSchoolEducationTrain(@Param("year")String[] year, @Param("school")String school);
	
	List<EducationTrain> getAreaEducationTrain(@Param("year")String[] year, @Param("city")String city);
	
	//校企合作 
	List<Schoolenterprise> getSchoolSchoolenterprise(@Param("year")String[] year, @Param("school")String school);
	
	List<Schoolenterprise> getAreaSchoolenterprise(@Param("year")String[] year, @Param("city")String city);

	List<Internship> getSchoolInternship(@Param("year")String[] year, @Param("school")String school);
	
	List<Internship> getAreaInternship(@Param("year")String[] year, @Param("city")String city);

	List<Groupschool> getSchoolGroupschool(@Param("year")String[] year, @Param("school")String school);
	
	List<Groupschool> getAreaGroupschool(@Param("year")String[] year, @Param("city")String city);
	
	//社会贡献 
	List<SkillTrain> getSchoolSkillTrain(@Param("year")String[] year, @Param("school")String school);
	
	List<SkillTrain> getAreaSkillTrain(@Param("year")String[] year, @Param("city")String city);

	List<SocialService> getSchoolSocialService(@Param("year")String[] year, @Param("school")String school);
	
	List<SocialService> getAreaSocialService(@Param("year")String[] year, @Param("city")String city);

	List<CounpaSupp> getSchoolCounpaSupp(@Param("year")String[] year, @Param("school")String school);
	
	List<CounpaSupp> getAreaCounpaSupp(@Param("year")String[] year, @Param("city")String city);
	
	//举办者履职 
	List<Funds> getSchoolFunds(@Param("year")String[] year, @Param("school")String school);
	
	List<Funds> getAreaFunds(@Param("year")String[] year, @Param("city")String city);

	List<Policy> getSchoolPolicy(@Param("year")String[] year, @Param("school")String school);
	
	List<Policy> getAreaPolicy(@Param("year")String[] year, @Param("city")String city);
	
	//党建工作 
	List<Partybulid> getSchoolPartybulid(@Param("year")String[] year, @Param("school")String school);
	
	List<Partybulid> getAreaPartybulid(@Param("year")String[] year, @Param("city")String city);
	
	//国家标准
	List<Standard> getSchoolStandard(@Param("year")String[] year, @Param("school")String school);
	
	List<Standard> getAreaStandard(@Param("year")String[] year, @Param("city")String city);
}
