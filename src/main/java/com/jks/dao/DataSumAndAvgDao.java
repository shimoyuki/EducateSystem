package com.jks.dao;

import java.util.List;

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
import com.jks.entity.StudentQuality;
import com.jks.entity.Teachers;

@Repository("dataSumAndAvgDao")
public interface DataSumAndAvgDao {
	//城市列表
	List<String> getAreaList();
    //基本情况		
	List<Size> getCitySize(@Param("year")String year, @Param("city")String city);

	List<Equitment> getCityEquitment(@Param("year")String year, @Param("city")String city);
	
	List<Teachers> getCityTeachers(@Param("year")String year, @Param("city")String city);
	
	List<Information> getCityInformation(@Param("year")String year, @Param("city")String city);
	
	//学生发展				
	List<StudentQuality> getCityStudentQuality(@Param("year")String year, @Param("city")String city);
	
	List<Experience> getCityExperience(@Param("year")String year, @Param("city")String city);
	
	List<EmployQuality> getCityEmployQuality(@Param("year")String year, @Param("city")String city);
	
	//质量保障措施 		
	List<MajorLayout> getCityMajorLayout(@Param("year")String year, @Param("city")String city);
	
	List<MajorNum> getCityMajorNum(@Param("year")String year, @Param("city")String city);
	
	List<QualityAssurance> getCityQualityAssurance(@Param("year")String year, @Param("city")String city);
					
	List<EducationTrain> getCityEducationTrain(@Param("year")String year, @Param("city")String city);
	
	//校企合作 				
	List<Schoolenterprise> getCitySchoolenterprise(@Param("year")String year, @Param("city")String city);
			
	List<Internship> getCityInternship(@Param("year")String year, @Param("city")String city);
	
	List<Groupschool> getCityGroupschool(@Param("year")String year, @Param("city")String city);
	
	//社会贡献 
	List<SkillTrain> getCitySkillTrain(@Param("year")String year, @Param("city")String city);
	
	List<SocialService> getCitySocialService(@Param("year")String year, @Param("city")String city);
	
	List<CounpaSupp> getCityCounpaSupp(@Param("year")String year, @Param("city")String city);
	
	//举办者履职 				
	List<Funds> getCityFunds(@Param("year")String year, @Param("city")String city);
	
	List<Policy> getCityPolicy(@Param("year")String year, @Param("city")String city);
	
	//党建工作 		
	List<Partybulid> getCityPartybulid(@Param("year")String year, @Param("city")String city);


}
